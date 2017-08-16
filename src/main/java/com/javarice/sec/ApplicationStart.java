package com.javarice.sec;


import com.javarice.sec.apis.result.BaseResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/8/14 下午1:52
 * @version: 1.0
 **/
@SpringBootApplication
@ComponentScan(basePackages = { "com.javarice"})
@ImportResource({ "classpath:applicationContext.xml" })
@EnableAutoConfiguration
@RestController
public class ApplicationStart {

    public static void main(String args[]) {
        SpringApplication.run(ApplicationStart.class, args);
        System.out.println("启动成功");
    }

    @RequestMapping({"/","/index"})
    public BaseResult test() {
        return new BaseResult(new Date());
    }
}
