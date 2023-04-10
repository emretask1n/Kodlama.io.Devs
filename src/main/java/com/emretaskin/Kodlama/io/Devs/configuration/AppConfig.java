package com.emretaskin.Kodlama.io.Devs.configuration;

import com.emretaskin.Kodlama.io.Devs.logger.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
