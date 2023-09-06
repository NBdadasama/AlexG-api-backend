package com.alexg.springbootinit;

import com.alexg.apicommon.service.InnerUserInterfaceInfoService;
import com.alexg.springbootinit.config.WxOpenConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 主类测试
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private InnerUserInterfaceInfoService innerUserInterfaceInfoService;

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }

    @Test
    void testInvokeInterfaceCount(){
        innerUserInterfaceInfoService.invokeInterfaceCount(1,1);

    }

}
