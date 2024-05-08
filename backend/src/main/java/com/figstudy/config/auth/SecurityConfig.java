package com.figstudy.config.auth;

import com.figstudy.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable
            )
            .headers((headerConfig) ->
                    headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
            )
            .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
            )
            .logout((logoutConfig) ->
                    logoutConfig.logoutSuccessUrl("/"))
            .oauth2Login((oauth2) -> oauth2
                        //.loginPage("/oauth2/authorization/google") // 권한 접근 실패 시 로그인 페이지로 이동
                        //.defaultSuccessUrl("http://localhost:3000")
                        //.failureUrl("/oauth2/authorization/google") // 로그인 실패 시 이동 페이지
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                        .userService(customOAuth2UserService)));
        return http.build();
    }
}