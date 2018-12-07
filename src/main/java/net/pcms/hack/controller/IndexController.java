package net.pcms.hack.controller;

import com.google.common.hash.Hashing;
import net.pcms.hack.domain.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class IndexController extends BaseController {

    @GetMapping(path = "")
    public String index(Model model) {
        model.addAttribute("tests", getTestService().findAll());
        return "IndexPage";
    }

    @SuppressWarnings({"deprecation", "UnstableApiUsage"})
    @GetMapping(path = "/add")
    public String add(@RequestParam(value = "content") String content) {
        Test test = new Test();
        test.setContent(content);
        String hash = Hashing.sha1().hashString(content, StandardCharsets.UTF_8).toString();
        test.setHash(hash);
        if (getTestService().findByHash(hash) == null) {
            getTestService().add(test);
        }
        return "redirect:/";
    }

    @GetMapping(path = "/get")
    public void get(@RequestParam(value = "hash") String hash, HttpServletResponse response) throws IOException {
        Test test = getTestService().findByHash(hash);
        response.getWriter().print(test == null ? "null" : test.getAnswer());
        response.getWriter().flush();
    }

    @GetMapping(path = "/update/{hash}")
    public String update(@PathVariable(value = "hash") String hash, @RequestParam(value = "answer") String answer) {
        getTestService().update(hash, answer);
        return "redirect:/";
    }

}