package com.cafe24.jgmall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.RestTemplateConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.jgmall.security", "com.cafe24.jgmall.service",  "com.cafe24.jgmall.repository"})
@Import({RestTemplateConfig.class})
public class AppConfig {
}