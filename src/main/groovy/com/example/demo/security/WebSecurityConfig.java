package com.example.demo.security;

import com.example.demo.security.jwt.AuthEntryPoint;
import com.example.demo.security.jwt.AuthTockenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsServiceImpl userDetailsService;
    @Autowired private AuthEntryPoint unauthorizedHandler;

//    @Bean
//    public AuthTockenFilter authenticationJwtTokenFilter() {
//        return new AuthTockenFilter();
//    }



    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .csrf().disable()

                .exceptionHandling()
                    .accessDeniedHandler((req, res, e) -> { res.setStatus(401); })

                .authenticationEntryPoint(unauthorizedHandler)

                .and().authorizeRequests().antMatchers("/api/auth/**", "/user/**").permitAll()
                .antMatchers("/api/test/**").permitAll()

                .anyRequest().authenticated()

                .and().formLogin()
                    .loginProcessingUrl("/api/login")
                    .failureHandler((req, res, e) -> { res.setStatus(401); })
                    .successHandler((req, res, e) -> { res.setStatus(200);})
                .and().logout().logoutUrl("/api/logout");


//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}