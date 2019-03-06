package com.lambdaschool.coffeebean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/orders/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER')")
                .antMatchers("/products/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER')")
                .antMatchers("/suppliers/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER')")
                .antMatchers("/users/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USR')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
