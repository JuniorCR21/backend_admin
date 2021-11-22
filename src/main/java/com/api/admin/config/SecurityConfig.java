package com.api.admin.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.admin.security.filters.JwtRequestFilter;
import com.api.admin.security.models.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled =  true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
    }
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// Disable CSRF
        http.csrf().disable()
        // Set session management to stateless
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
         // Set unauthorized requests exception handler
             .exceptionHandling()
             .authenticationEntryPoint(
                 (request, response, ex) -> {
                     response.sendError(
                         HttpServletResponse.SC_UNAUTHORIZED,
                         ex.getMessage()
                     );
                 }
             )
             .and()
             .authorizeRequests()
             .antMatchers("/api/v1/users/**").permitAll()
             .antMatchers("/v2/api-docs","/api/v1/**", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html/**", "/webjars/**","/swagger-resources/configuration/ui","/swagger-ui.html").permitAll()
             .antMatchers("/actuator/health").permitAll()
          //.antMatchers(HttpMethod.GET,"/api/vehiculos").hasRole("ADMIN")
             .anyRequest().authenticated().and()
          // Add JWT token filter
             .addFilterBefore(
            		 jwtRequestFilter,
                     UsernamePasswordAuthenticationFilter.class
              );
    }
    
    /*Used by spring security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }*/
}
