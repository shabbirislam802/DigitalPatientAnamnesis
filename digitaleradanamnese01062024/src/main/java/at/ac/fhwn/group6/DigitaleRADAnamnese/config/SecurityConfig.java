package at.ac.fhwn.group6.DigitaleRADAnamnese.config;


import at.ac.fhwn.group6.DigitaleRADAnamnese.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/help", "/user/logIn", "/user/signUp", "/js/**", "/css/**", "/images/**", "/h2-console/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/staff/**").hasRole("STAFF")
                                .requestMatchers("/patient/**").hasRole("PATIENT")
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/user/logIn")
                                .loginProcessingUrl("/user/logIn")
                                .successHandler((request, response, authentication) -> {
                                    var authorities = authentication.getAuthorities();
                                    if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                                        response.sendRedirect("/admin/user-management");
                                    } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_STAFF"))) {
                                        response.sendRedirect("/staff/welcome");
                                    } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_PATIENT"))) {
                                        response.sendRedirect("/patient/welcome");
                                    } else {
                                        response.sendRedirect("/"); // Standard Redirect, falls keine passenden Rollen vorhanden sind
                                    }
                                })
                                .failureUrl("/user/logIn?error=true")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/user/logout")
                                .logoutSuccessUrl("/user/signIn?logout=true")
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions
                                .sameOrigin()
                        )
                );
        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
