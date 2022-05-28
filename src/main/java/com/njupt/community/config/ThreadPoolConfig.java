package com.njupt.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling// 启动定时任务
@EnableAsync// 启动@Async注释，使加了该注释的方法在多线程环境下，被异步的调用，即跟主线程同时进行
public class ThreadPoolConfig {
}
