package net.pcms.hack.service;

import net.pcms.hack.domain.Test;
import net.pcms.hack.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public void add(Test test) {
        testRepository.save(test);
    }

    public void update(String hash, String answer) {
        testRepository.setAnswerByHash(answer, hash);
    }

    public Test findByHash(String hash) {
        return testRepository.findByHash(hash);
    }
}
