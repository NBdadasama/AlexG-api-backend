package com.alexg.springbootinit.service.impl;

import com.alexg.springbootinit.service.UserInterfaceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInterfaceInfoServiceImplTest {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void invokeCount() {
        Boolean res = userInterfaceInfoService.invokeCount(1l, 1l);
        assertEquals(res,true);
    }
}