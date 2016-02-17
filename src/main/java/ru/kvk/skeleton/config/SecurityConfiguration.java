package ru.kvk.skeleton.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kvk.skeleton.module.system_user.entity.enums.SystemRole;

import javax.sql.DataSource;

/**
 * Created by King on 09.12.2015.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery(
                    "select login, password, enabled from system_user where login=?")
            .authoritiesByUsernameQuery(
                    "select s.login, sr.system_role from system_role sr inner join system_user s on sr.system_id_fk = s.id and s.login=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/module/system_user/admin/**").hasAuthority(SystemRole.ROLE_SYSTEM_USER_ADMIN.name())
            .antMatchers("/module/system_user/**").authenticated()
            .antMatchers("/**").permitAll()
            .and().formLogin()
                .defaultSuccessUrl("/", false)
                .loginPage("/sign_in")
                .failureUrl("/sign_in?error")
                .usernameParameter("login").passwordParameter("password")
                .loginProcessingUrl("/sign_in_check")
            .and().logout()
                .logoutSuccessUrl("/")
                .logoutUrl("/sign_out")
                .logoutRequestMatcher(new AntPathRequestMatcher("/sign_out"))
            .and()
                .exceptionHandling().accessDeniedPage("/access_denied")
            .and().csrf();
    }
}
