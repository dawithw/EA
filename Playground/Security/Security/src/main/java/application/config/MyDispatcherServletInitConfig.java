package application.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
    Configure the dispatcher servlet to get all custom configuration classes and available servlet mappings
    DispatcherServlet is already instantiated by the AbstractAnnotationConfigDispatcherServletInitializer
*/
public class MyDispatcherServletInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
        Root config class: Non web related classes
    */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /*
        Get out custom configuration class where the controllers and views
        are configured (the Spring MVC configuration)
    */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MyMVCConfig.class};
    }

    /*
        Get the default mapping for the servlet 
        This will be the <path> @ http://host:port/<path>/
    */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}