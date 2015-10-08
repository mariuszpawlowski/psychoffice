package pl.psychoffice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("u").password("u").roles("USER").and()
                .withUser("a").password("a").roles("ADMIN").and()
                .withUser("manager").password("manager").roles("MANAGER");


    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/clientHome", "/onlineConsultation", "/onlineTherapy",
                        "/directConsultation", "/directDiagnosis", "/directIndividual", "/directPair", "/directGroup",
                        "/companiesDiagnosis", "/companiesTraining", "/companiesNegotiations",
                        "/prices",
                        "/aboutBiography", "/aboutQualifications", "/aboutHow", "/aboutPublications",
                        "/blog", "/faq", "/contact").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/blog/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/img/demo/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/manage/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("/img/**", "/css/**", "/fonts/**", "/js/**");
    }
}