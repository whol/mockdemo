package com.example.mockdemo.service;

import com.example.mockdemo.bean.DemoBean;

public interface DemoService {

    String service1(String param1, Integer param2);

    Boolean service2(Long a, Long b);

    DemoBean service3(String id);

    DemoBean service4(DemoBean demoBean);

    DemoBean service5(String id) throws Exception;
}
