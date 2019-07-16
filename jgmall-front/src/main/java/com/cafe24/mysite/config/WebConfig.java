package com.cafe24.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan({"com.cafe24.mysite.controller", "com.cafe24.mysite.exception"})
@Import({MVCConfig.class, MessageConfig.class, FileuploadConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
}
