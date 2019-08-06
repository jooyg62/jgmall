package com.cafe24.jgmall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.RestTemplateConfig;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan({"com.cafe24.jgmall.controller", "com.cafe24.jgmall.exception"})
@Import({MVCConfig.class, MessageConfig.class, FileuploadConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
}
