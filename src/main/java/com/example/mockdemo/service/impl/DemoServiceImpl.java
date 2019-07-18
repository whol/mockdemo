package com.example.mockdemo.service.impl;

import com.example.mockdemo.bean.DemoBean;
import com.example.mockdemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Override
    public String service1(String param1, Integer param2) {
        return null;
    }

    @Override
    public Boolean service2(Long a, Long b) {
        return null;
    }

    @Override
    public DemoBean service3(String id) {
        return null;
    }

    @Override
    public DemoBean service4(DemoBean demoBean) {
        return null;
    }

    @Override
    public DemoBean service5(String id) throws Exception {
        return null;
    }
}
