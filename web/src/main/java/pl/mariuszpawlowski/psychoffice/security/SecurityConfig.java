package pl.mariuszpawlowski.psychoffice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/onlineConsultation", "/onlineTherapy",
                        "/directConsultation", "/directDiagnosis", "/directIndividual", "/directPair", "/directGroup",
                        "/companiesDiagnosis", "/forWhom", "/aboutTherapy",
                        "/prices",
                        "/aboutBiography", "/aboutQualifications", "/aboutHow", "/aboutPublications",
                        "/blog", "/faq", "/contact").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/blog/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/img/demo/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                    .failureUrl("/login?error")
                    .successHandler(authenticationSuccessHandler)
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .deleteCookies("remember-me")
                    .permitAll()
                    .and()
                    .rememberMe();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("/img/**", "/css/**", "/fonts/**", "/js/**");
    }
}