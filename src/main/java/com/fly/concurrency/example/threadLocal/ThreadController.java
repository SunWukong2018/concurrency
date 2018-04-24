package com.fly.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/threadLocal")
@Slf4j
public class ThreadController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        log.info("test");
        return RequestHolder.getId();
    }
}
