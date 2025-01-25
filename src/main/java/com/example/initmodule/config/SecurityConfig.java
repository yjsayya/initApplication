package com.example.initmodule.config;

import com.example.initmodule.etc.security.CustomAuthenticationFilter;
import com.example.initmodule.etc.security.LoginFailHandlerImpl;
import com.example.initmodule.etc.security.LoginSuccessHandlerImpl;
import com.example.initmodule.etc.security.LogoutHandlerImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((auth) -> auth
                .antMatchers("/", "/login", "/api/login", "/join", "/api/yml").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
        );
        http.formLogin((auth) -> auth.loginPage("/login")
                .loginProcessingUrl("/api/login")
                .successHandler(loginSuccessHandler())
//                .defaultSuccessUrl("/yml/config", true)
                .permitAll()
                .failureHandler(LoginFailHandler())  // Bean에 등록했네
        );
        // http.formLogin().disable()
        http.logout((logout) -> logout
                .logoutUrl("/logout") // 로그아웃 처리 URL
                .addLogoutHandler(new LogoutHandlerImpl())
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
        );
        http.sessionManagement((auth) -> auth
                .maximumSessions(1) // 다중 로그인 허용 개수
                .maxSessionsPreventsLogin(true) // 초과 시 새로운 로그인 차단
        );
        http.csrf().disable();
        http.addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /** 여기에 설정해주면 Spring Security의 전체 filter chain을 안 타게 된다. */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                        .antMatchers("/setting/payapp/result",
                                     "/example/추가")
                        // static 파일들도 아예 filter chain에서 제외 해버린다.
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public LoginSuccessHandlerImpl loginSuccessHandler() {
        return new LoginSuccessHandlerImpl(); // Bean으로 등록
    }

    @Bean
    public LoginFailHandlerImpl LoginFailHandler() {
        return new LoginFailHandlerImpl(); // Bean으로 등록
    }

}