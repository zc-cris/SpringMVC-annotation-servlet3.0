package com.zc.cris.springMVC.annotation.async;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.web.context.request.async.DeferredResult;

// 模拟保存 DeferredResult的集合
public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<>();
    
    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }
    public static DeferredResult<Object> get(){
        return queue.poll();
    }
    
}
