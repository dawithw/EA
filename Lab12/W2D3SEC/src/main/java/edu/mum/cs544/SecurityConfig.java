package edu.mum.cs544;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // In memory authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/logout","/index","/").permitAll().and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/cars*").hasRole("USER").and()
            .authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN").and()
            .formLogin()
            //.defaultSuccessUrl("/")
            .and().logout();
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.debug(true);
    }
}
