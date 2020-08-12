package com.sgldts.community.controller;

import com.sgldts.community.dto.PaginationDTO;
import com.sgldts.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author herry
 * @create 2020-08-07-17:56
 */

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PaginationDTO questionDTOList = questionService.list(page, size);
        model.addAttribute("paginationDTO", questionDTOList);

        return "index";
    }
}
