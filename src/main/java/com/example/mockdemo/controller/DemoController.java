package com.example.mockdemo.controller;

import com.example.mockdemo.bean.DemoBean;
import com.example.mockdemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/service1")
    public String service1(String param1, Integer param2) {
        String result = demoService.service1(param1, param2);
        return result;
    }

    @GetMapping(value = "/service2")
    public Boolean service2(Long a, Long b) {
        Boolean result = demoService.service2(a, b);
        return result;
    }

    @GetMapping(value = "/service3")
    public DemoBean service3(String id) {
        DemoBean result = demoService.service3(id);
        return result;
    }

    @GetMapping(value = "/service4")
    public DemoBean service4(DemoBean demoBean) {
        DemoBean result = demoService.service4(demoBean);
        return result;
    }

    @GetMapping(value = "/service5")
    public DemoBean service5(String id) {
        DemoBean result = null;
        try {
            result = demoService.service5(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
