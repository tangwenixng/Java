package spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spring.service.SimpleCORSFilter;

import javax.servlet.Filter;

/**
 * Created by twx on 2017/8/22.
 */
public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new SimpleCORSFilter()};
        return singleton;
    }
}
