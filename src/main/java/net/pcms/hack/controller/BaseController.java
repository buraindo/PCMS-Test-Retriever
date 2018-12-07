package net.pcms.hack.controller;

import net.pcms.hack.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Autowired
    private TestService testService;

    public TestService getTestService() {
        return testService;
    }
}
