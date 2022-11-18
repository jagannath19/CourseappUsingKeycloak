/**
 * 
 */
package com.courseapp;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * @author JagannathSutar
 * In this we create all the configuration of Keycloak 
 * 
 */
@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Import(KeycloakSpringBootConfigResolver.class)
public class KeycloakWebConfig extends KeycloakWebSecurityConfigurerAdapter{

	
	
	/**
	 *	@param HttpSecurity
	 *	method use for give the authorization request 
	 *	authorizeRequests() Allows restricting access based upon the HttpServletRequest
	 *	permitAll() This will allow the public access that is anyone can access endpoint PUBLIC_URL without authentication
	 *	csrf - Cross-Site Request Forgery
	 *	csrf  is an attack that forces an end user to execute unwanted actions on a web application in which they are currently authenticated.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		super.configure(http);
//        http.authorizeRequests()
//        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/**").hasAnyRole("ADMIN","USER")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
//        http.csrf().disable();
		
		super.configure(http);
        http.authorizeRequests()
                .anyRequest()
                .permitAll();
        http.csrf().disable();
        
        
	}
	
	/**
	 * @param auth
	 * @throws Exception
	 * use for set security while maintaining your config class
	 */
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    
    /**
     *	Allows pluggable support for HttpSession-related behaviour when an authentication occurs
     */
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }

    
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

	
	
	

}
