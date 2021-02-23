package com.alibaba.nacos.test.Own;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

/**
 * @author dizhang
 * @date 2021-02-23
 */
public class Pub {
    public static void main(String[] args) {
        String serviceName = "helloworldservice";
        try {
            NamingService namingService = NamingFactory.createNamingService("127.0.0.1:8848");
            namingService.registerInstance(serviceName, "127.0.0.1", 8080);
            Thread.sleep(60000);
        } catch (NacosException | InterruptedException e) {
            System.out.println("exception");
        }

        System.exit(0);
    }
}
