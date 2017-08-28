package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spring.service.SimpleCORSFilter;
import spring.service.XmlGenerateService;

import javax.servlet.Filter;

/**
 * Created by twx on 2017/8/22.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring")

public class HelloWorldConfiguration {
//    @Bean
//    public Filter getXmlGenerator() {
//        return  new SimpleCORSFilter();
//    }
}
