package com.alibaba.nacos.test.Own;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

/**
 * @author dizhang
 * @date 2021-02-23
 */
public class Sub {
    public static void main(String[] args) {
        String serviceName = "helloworldservice";
        try {
            NamingService namingService = NamingFactory.createNamingService("127.0.0.1:8848");
            //订阅一个服务
            namingService.subscribe(serviceName, event -> {
                if (NamingEvent.class.isAssignableFrom(event.getClass())) {
                    System.out.println("订阅到数据");
                    System.out.println(((NamingEvent) event).getInstances());
                }
            });

            System.out.println("订阅完成，准备等数来");
            Thread.sleep(60000);

        } catch (NacosException | InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
