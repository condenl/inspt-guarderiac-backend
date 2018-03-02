package com.inspt.guarderiacaracol.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication()
    		.usersByUsernameQuery(usersQuery)
    		.authoritiesByUsernameQuery(rolesQuery)
    		.dataSource(dataSource)
    		.passwordEncoder(bCryptPasswordEncoder);
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
				.authorizeRequests()
				.antMatchers("/index.html", "/", "/api/**").permitAll() //, "/home", "/login"
				.anyRequest().authenticated()
			.and()
				.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and()
				.formLogin()
				.loginPage("/")
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/*.bundle.*");
    }
	
}
