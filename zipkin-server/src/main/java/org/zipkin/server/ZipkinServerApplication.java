package org.zipkin.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * 链路追踪
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
