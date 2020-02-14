package com.tina.cloud_consumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfig {
    //配置 服务的实时数据采集，默认的servlet
    @Bean
    public ServletRegistrationBean createS(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean();
        registrationBean.setServlet(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }
}
