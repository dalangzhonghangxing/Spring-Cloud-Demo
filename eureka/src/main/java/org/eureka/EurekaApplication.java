package org.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka是用来为每个微服务做负载均衡的，它可以有多个节点，节点之间会自动同步。
 * 其他的微服务都要配置Eureka集群中的一个节点即可，然后微服务之间通过彼此的name就能够来通信，而不用通过ip来访问。
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
