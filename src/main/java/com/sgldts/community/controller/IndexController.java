package com.sgldts.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author herry
 * @create 2020-08-07-17:56
 */

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
