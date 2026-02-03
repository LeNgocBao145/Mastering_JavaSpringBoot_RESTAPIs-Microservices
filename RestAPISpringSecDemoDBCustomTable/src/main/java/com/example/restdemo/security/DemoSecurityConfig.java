package com.example.restdemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	// getting users and roles from database (users and authorities)
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {		
    	JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    	
    	String q = "SELECT\r\n"
    			+ "    u.login_name,\r\n"
    			+ "    r.role_code\r\n"
    			+ "FROM app_user u\r\n"
    			+ "JOIN app_user_role ur ON u.user_id = ur.user_id\r\n"
    			+ "JOIN app_role r ON ur.role_id = r.role_id\r\n"
    			+ "WHERE u.login_name = ?";
    	jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(q);
    	
    	jdbcUserDetailsManager.setUsersByUsernameQuery("select login_name, password_hash, enabled from app_user where login_name = ?");
    	
    	return jdbcUserDetailsManager;
	}
   
    // restrict access based on http method and end point / path
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				);
		//use HTTP basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable CSRF
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
}

//	CREATE TABLE app_user (
//	    user_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
//	    login_name     VARCHAR(50)  NOT NULL UNIQUE,
//	    password_hash  VARCHAR(68)  NOT NULL,
//	    email          VARCHAR(100),
//	    full_name      VARCHAR(100),
//
//	    enabled        BOOLEAN      NOT NULL DEFAULT TRUE,
//	    account_locked BOOLEAN      NOT NULL DEFAULT FALSE,
//
//	    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//	    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
//	);
//
//	CREATE TABLE app_role (
//	    role_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
//	    role_code  VARCHAR(50) NOT NULL UNIQUE,
//	    role_name  VARCHAR(100)
//	);
//
//	CREATE TABLE app_user_role (
//	    user_id BIGINT NOT NULL,
//	    role_id BIGINT NOT NULL,
//
//	    PRIMARY KEY (user_id, role_id),
//
//	    CONSTRAINT fk_user
//	        FOREIGN KEY (user_id) REFERENCES app_user(user_id)
//	        ON DELETE CASCADE,
//
//	    CONSTRAINT fk_role
//	        FOREIGN KEY (role_id) REFERENCES app_role(role_id)
//	        ON DELETE CASCADE
//	);

//INSERT INTO app_user
//(login_name, password_hash, email, full_name, enabled, account_locked)
//VALUES
//('john',
// '$2a$10$V9g8sT1k5WZ2n6e8x0oZ0eQ2x6x0kZ1b1Pp2y6p6o7dXkK9aZQyq',
// 'john.doe@gmail.com',
// 'John Doe',
// 1,
// 0
//),
//
//('mary',
// '$2a$10$V9g8sT1k5WZ2n6e8x0oZ0eQ2x6x0kZ1b1Pp2y6p6o7dXkK9aZQyq',
// 'mary.public@gmail.com',
// 'Mary Public',
// 1,
// 0
//),
//
//('susan',
// '$2a$10$V9g8sT1k5WZ2n6e8x0oZ0eQ2x6x0kZ1b1Pp2y6p6o7dXkK9aZQyq',
// 'susan.adams@gmail.com',
// 'Susan Adams',
// 1,
// 0
//);

//-- john → EMPLOYEE
//INSERT INTO app_user_role (user_id, role_id)
//SELECT u.user_id, r.role_id
//FROM app_user u, app_role r
//WHERE u.login_name='john' AND r.role_code='ROLE_EMPLOYEE';
//
//-- mary → EMPLOYEE + MANAGER
//INSERT INTO app_user_role (user_id, role_id)
//SELECT u.user_id, r.role_id
//FROM app_user u, app_role r
//WHERE u.login_name='mary'
//AND r.role_code IN ('ROLE_EMPLOYEE','ROLE_MANAGER');
//
//-- susan → EMPLOYEE + MANAGER + ADMIN
//INSERT INTO app_user_role (user_id, role_id)
//SELECT u.user_id, r.role_id
//FROM app_user u, app_role r
//WHERE u.login_name='susan'
//AND r.role_code IN ('ROLE_EMPLOYEE','ROLE_MANAGER','ROLE_ADMIN');