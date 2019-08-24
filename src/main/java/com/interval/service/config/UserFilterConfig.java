package com.interval.service.config;

import com.interval.service.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class UserFilterConfig {
    @Bean
    public FilterRegistrationBean userFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns("/web/*");
        registration.setName("userFilte");
        registration.setOrder(101);
        return registration;
    }
}
