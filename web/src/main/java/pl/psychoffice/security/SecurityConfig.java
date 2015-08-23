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

    private static final String[] STATIC_PAGES = new String[]{"/", "/clientHome", "/onlineConsultation", "/onlineTherapy", "/onlineTests",
            "/directConsultation", "/directPsychotherapy", "/directPsychotherapy", "/companiesDiagnosis", "/companiesTraining", "/companiesNegotiations",
            "/prices", "/aboutBiography", "/aboutQualifications", "/aboutHow", "/aboutPublications", "/blog", "/faq", "/contact"};

    private static final String[] STATIC_RESOURCES = new String[]{"/css/**", "/img/**", "/img/demo/**", "/js/**", "/fonts/**"};
    private static final String[] ADMIN_PAGES = new String[]{"/admin", "admin/a"};
    private static final String[] CLIENT_PAGES = new String[]{"/clientHome", "clientHome/a"};

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
                .antMatchers(STATIC_PAGES).permitAll()
                .antMatchers(STATIC_RESOURCES).permitAll()
                .antMatchers(ADMIN_PAGES).hasRole(Roles.ADMIN)
                .antMatchers(CLIENT_PAGES).hasRole(Roles.USER)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .failureUrl("/login?error")
                    .successHandler(authenticationSuccessHandler())
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and();

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