package com.cafe24.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan({"com.cafe24.mysite.service", "com.cafe24.mysite.repository", "com.cafe24.mysite.aspect"})
//@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
}