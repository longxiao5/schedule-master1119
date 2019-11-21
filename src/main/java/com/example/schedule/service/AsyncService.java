package com.example.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AsyncService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //线程1 每1秒执行一次
    @Scheduled(cron = "0/1 * * * * ? ")
    @Async("taskExecutor")
    public void executeAsync1() {
        //Thread.sleep(20);
        System.out.println("异步任务::1 现在时间：" + dateFormat.format(new Date()));

    }
    //线程2 每2秒执行一次

    @Scheduled(cron = "0/2 * * * * ? ")
    @Async("taskExecutor")
    public void executeAsync2() {
        System.out.println("异步任务::2 现在时间：" + dateFormat.format(new Date()));
    }

   // public void testAsyncJob(){
    //    System.out.println("hello，lx！现在时间：" + dateFormat.format(new Date()));
    //}
}
