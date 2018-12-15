package com.sjh.code.codegenerator.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/13 23:53
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
