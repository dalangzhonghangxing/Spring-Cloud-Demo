package org.test.service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.service.model.Question;
import org.test.service.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    @ResponseBody
    public Page<Question> getQuestions(int currentPage, int numPerPage) {
        return service.getQuestions(currentPage, numPerPage);
    }

    @RequestMapping(value = "/question", method = RequestMethod.DELETE)
    @ResponseBody
    public Page<Question> deleteQuestion(long id, int currentPage,
            int numPerPage) {
        return service.deleteQuestion(id, currentPage, numPerPage);
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    @ResponseBody
    public Page<Question> addQuestion(String question, Integer currentPage,
            Integer numPerPage) {
        return service.addQuestion(question, currentPage, numPerPage);
    }

    @RequestMapping(value = "/question", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modifyQuestion(String question) {
        return service.modifyQuestion(question);
    }

    @RequestMapping(value = "/test-questions", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testQuestions(long id) {
        return service.testQuestions(id);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> submit(long id, String[] answer) {
        return service.submit(id,answer);
    }
}
