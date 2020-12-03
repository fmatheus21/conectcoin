package com.firecode.app.config;

import com.firecode.app.controller.security.LoggingAccessDeniedSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@EnableWebSecurity
//@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true) //  Habilita a seguranca nos metodos
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoggingAccessDeniedSecurity loggingAccessDeniedSecurity;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/app/assets/**",
                        "/app/public**",
                        "/authentication",
                        "/authentication/teste",
                        "/app/error/403",
                        "/app/error",
                        "/recover/password").permitAll()
                .antMatchers("/app/upload**").authenticated()
                .antMatchers(HttpMethod.GET, "/app/dashboard").authenticated()
                .antMatchers(HttpMethod.GET, "/app/conta/perfil").hasAnyAuthority("CLIENTE")
                .antMatchers(HttpMethod.GET, "/app/financiamento/pagamentos").hasAnyAuthority("ADMIN", "CLIENTE")
                .antMatchers(HttpMethod.GET, "/app/contribuicoes").hasAnyAuthority("ADMIN", "CLIENTE")
                .antMatchers(HttpMethod.GET, "/app/pedidos").hasAnyAuthority("ADMIN", "CLIENTE")
                .antMatchers(HttpMethod.GET, "/app/redes/indicados").hasAnyAuthority("ADMIN", "CLIENTE")
                .antMatchers(HttpMethod.GET, "/app/redes/unilateral").hasAnyAuthority("ADMIN", "CLIENTE")
                .antMatchers(HttpMethod.GET, "/coachees/update/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/assessments/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/assessments/assessment/view/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/{\\d+}/assessments/reader").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/coachees/{\\d+}/session/reader").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/create").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/update/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/delete/{\\d+}").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/coachees/filter").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/app/authentication")
                .defaultSuccessUrl("/app/dashboard", true)
                .loginProcessingUrl("/perform_login")
                .passwordParameter("password")
                .usernameParameter("username")
                .failureUrl("/app/authentication?error=1")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/app/logout"))
                .logoutSuccessUrl("/?logout")
                .permitAll()
                .and()
                .rememberMe()
                .userDetailsService(this.userDetailsService)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/authentication?expired")
                .and()
                .sessionFixation().migrateSession()
                .invalidSessionUrl("/app/authentication?invalid")
                .sessionAuthenticationErrorUrl("/app/authentication?invalid")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(this.loggingAccessDeniedSecurity)
                .and()
                .csrf().disable();
    }

    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    // Register HttpSessionEventPublisher
    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService uds) throws Exception {
        auth
                .userDetailsService(uds);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/app/assets/**", "/app/public**");
    }

}
