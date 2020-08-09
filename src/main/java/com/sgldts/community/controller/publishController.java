package com.sgldts.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author herry
 * @create 2020-08-09-16:31
 */
@Controller
public class publishController {

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

}
