package pl.psychoffice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("u").password("u").roles(Roles.USER).and()
                .withUser("a").password("a").roles(Roles.ADMIN).and();



    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/clientHome", "/onlineConsultation", "/onlineTherapy", "/onlineTests",
                        "/directConsultation", "/directPsychotherapy", "/directPsychotherapy",
                        "/companiesDiagnosis", "/companiesTraining", "/companiesNegotiations",
                        "/prices",
                        "/aboutBiography", "/aboutQualifications", "/aboutHow", "/aboutPublications",
                        "/blog", "/faq", "/contact").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/img/demo/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/admin").hasRole(Roles.ADMIN)
                .antMatchers("/clientHome").hasRole(Roles.USER)
                .anyRequest().authenticated();

        http
                .formLogin().failureUrl("/login?error")
                .successHandler(authenticationSuccessHandler())
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll();

        http.csrf().disable();

    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new MyAuthenticationSuccessHandler();
    }

    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("/img/**", "/css/**", "/fonts/**", "/js/**");
    }
}