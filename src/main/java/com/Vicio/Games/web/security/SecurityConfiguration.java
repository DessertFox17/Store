package com.Vicio.Games.web.security;

import com.Vicio.Games.domain.service.StoreUserDetailService;
import com.Vicio.Games.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private StoreUserDetailService storeUserDetailService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(storeUserDetailService);
    }

    @Override
    public void configure(WebSecurity web)throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui",
                "/swagger-resources/**", "/configuration/security",
                "/swagger-ui.html", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/**/authenticate","/**/smartfilter","/**/dynamicfilter","/**/product/specific","/**/user/new")
                .permitAll()
                .antMatchers("/**/user/all").hasAnyAuthority("Super User","Admin")
                .antMatchers("/**/user/delete").hasAnyAuthority("Super User","Admin")
                .antMatchers("/**/image/new").hasAnyAuthority("Super User","Admin")
                .antMatchers("/**/purchase/specific").hasAnyAuthority("Super User","Admin")
                .antMatchers("/**/purchase/update").hasAnyAuthority("Super User","Admin")
                .anyRequest()
                .authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
