package com.example.Springparking;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    String [] pages = new String[]{
            "/editClient", "/editClient/{id}", "/clientForm/cancel", "/deleteClient/{id}", "client/client-view",
            "/editUser/{id}", "/editUser", "/userForm/cancel", "/deleteUser/{id}", "/clientForm", "/userForm"
    };
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(resources).permitAll()
                .requestMatchers(pages).permitAll()
                .requestMatchers("/inicio").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/inicio");

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
        user.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("nami"))
                .roles("USER")
                .build());

        return user;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
