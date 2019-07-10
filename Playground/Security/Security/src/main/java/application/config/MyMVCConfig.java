package application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/* 
    Configure the web application context
*/
@Configuration                  // Specify class is configuration -- declares beans
@EnableWebMvc                   // Add default spring MVC configurations for web
@ComponentScan("application")   // Base package to scan for annotated classes (components)
public class MyMVCConfig implements WebMvcConfigurer {

    /*
        
    */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
        Creates the view resolver and sets the prefix and suffix
        to attach to the String view name returned from the controller.
        Prefix: Path of the view page starting from the "webapp" directory
        Suffix: extension of the view page
    */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
}