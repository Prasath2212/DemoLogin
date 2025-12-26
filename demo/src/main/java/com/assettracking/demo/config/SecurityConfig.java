package com.assettracking.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/*
 * package com.assettracking.demo.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration public class SecurityConfig {
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http .csrf().disable() .authorizeRequests()
 * .antMatchers("/auth/**", "/swagger-ui/**", "/swagger-ui.html",
 * "/v3/api-docs/**") .permitAll() .anyRequest().authenticated() // Changed to
 * require authentication (remove for demo if needed) .and()
 * .addFilterBefore(new JwtAuthenticationFilter(),
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter.class); // Add the filter
 * 
 * return http.build(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); } }
 */



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll();

        return http.build();
    }

    @Bean
    public HttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedCarriageReturn(true); // ⚠️ allows %0A
        firewall.setAllowUrlEncodedCarriageReturn(true); // %0D
        return firewall;
    }
    
    @Bean public PasswordEncoder passwordEncoder() { return new
    		  BCryptPasswordEncoder(); } 
    
    

}