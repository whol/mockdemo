package com.example.mockdemo.controller;


import com.alibaba.fastjson.JSON;
import com.example.mockdemo.bean.DemoBean;
import com.example.mockdemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoControllerTest {

    @InjectMocks
    private DemoController demoControllerMock;

    @Mock
    private DemoService demoService;

    @Test
    public void test01_01_service1() {
        //模拟动作
        Mockito.doReturn("aaa").when(demoService).service1(Mockito.anyString(), Mockito.anyInt());
        //调用接口
        String result = demoControllerMock.service1("abc", 233);
        log.info("service1 返回：" + result);
        //验证返回值
        Assert.assertEquals(result, "aaa");
    }

    @Test
    public void test01_02_service1() {
        //模拟动作
        Mockito.doReturn(null).when(demoService).service1(Mockito.anyString(), Mockito.anyInt());
        String result = demoControllerMock.service1("abc", 233);
        log.info("service1 返回：" + result);
        Assert.assertEquals(result, null);
    }

    @Test
    public void test02_01_service2() {
        //模拟动作
        Mockito.doReturn(true).when(demoService).service2(Mockito.anyLong(), Mockito.anyLong());
        Boolean result = demoControllerMock.service2(100L, 233L);
        log.info("service2 返回：" + result);
        Assert.assertTrue(result);
    }

    @Test
    public void test02_02_service2() {
        //模拟动作
        Mockito.doReturn(false).when(demoService).service2(Mockito.anyLong(), Mockito.anyLong());
        Boolean result = demoControllerMock.service2(100L, 233L);
        log.info("service2 返回：" + result);
        Assert.assertFalse(result);
    }

    @Test
    public void test03_01_service3() {
        //组织数据
        DemoBean demoBean = new DemoBean();
        demoBean.setName("wang");
        demoBean.setNumber(200);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        demoBean.setList(list);

        //模拟动作
        Mockito.doReturn(demoBean).when(demoService).service3(Mockito.anyString());
        //调用接口
        DemoBean result = demoControllerMock.service3("abc");
        log.info("service3 返回：" + JSON.toJSONString(result));
        //验证返回值
        Assert.assertNotNull(result);
    }

    @Test
    public void service4() {
        DemoBean demoBean = new DemoBean();
        demoBean.setName("wang");
        demoBean.setNumber(200);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        demoBean.setList(list);

        //模拟动作
        Mockito.doReturn(demoBean).when(demoService).service4(Mockito.any());
        DemoBean result = demoControllerMock.service4(new DemoBean());
        log.info("service4 返回：" + JSON.toJSONString(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void service5() throws Exception {
        //模拟动作
        Mockito.doThrow(new Exception("模拟覆盖异常分支")).when(demoService).service5(Mockito.any());
        DemoBean result = demoControllerMock.service5("abc");
        log.info("service5 返回：" + JSON.toJSONString(result));
        Assert.assertNull(result);
    }
}