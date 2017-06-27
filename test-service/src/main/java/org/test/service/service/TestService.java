package org.test.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.test.service.model.Question;
import org.test.service.repository.QuestionRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {

    @Autowired
    private QuestionRepository questionRepository;

    private Gson gson = new GsonBuilder().create();

    private Map<String, Object> answers = new HashMap<>();

    @HystrixCommand(fallbackMethod = "getQuestionsFallback")
    public Page<Question> getQuestions(int currentPage, int numPerPage) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(currentPage, numPerPage, sort);
        return questionRepository.findAll(pageable);
    }

    public Page<Question> getQuestionsFallback(int currentPage,
            int numPerPage) {
        return null;
    }

    public Page<Question> deleteQuestion(long id, int currentPage,
            int numPerPage) {
        questionRepository.delete(id);
        return getQuestions(currentPage, numPerPage);
    }

    public Page<Question> addQuestion(String question, int currentPage,
            int numPerPage) {
        Question que = (Question) gson.fromJson(question, Question.class);
        que.setTotals(0);
        que.setCorrects(0);
        questionRepository.save(que);
        return getQuestions(currentPage, numPerPage);
    }

    public Map<String, Object> modifyQuestion(String question) {
        Question que = (Question) gson.fromJson(question, Question.class);
        questionRepository.save(que);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("state", 1);
        return res;
    }

    public Map<String, Object> testQuestions(long id) {
        Map<String, Object> res = new HashMap<String, Object>();
        List<Question> quesions = new ArrayList<>();
        List<Map<String, Object>> qs = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        long count = questionRepository.count();
        if (count > 30) {
            int begin = Double.valueOf((Math.random() * (count - 30)))
                    .intValue();
            quesions = questionRepository.findAll(begin, 30);
        } else {
            quesions = questionRepository.findAll();
        }
        for (Question q : quesions) {
            Map<String, Object> t = new HashMap<>();
            t.put("test", q.getQuestionName());
            t.put("op1", q.getA());
            t.put("op2", q.getB());
            t.put("op3", q.getC());
            t.put("op4", q.getD());
            qs.add(t);
            answer.add(q.getAnswer());
        }
        answers.put(String.valueOf(id), answer);
        res.put("questions", qs);
        return res;
    }

    public Map<String, Object> submit(long id, String[] answer) {
        Map<String, Object> res = new HashMap<>();
        int corrects = 0;
        List<String> ans = (List<String>) answers.get(String.valueOf(id));
        for (int i = 0; i < ans.size(); i++) {
            if (answer[i].equals(ans.get(i))) corrects++;
        }
        res.put("corrects", corrects);
        return res;
    }

}
