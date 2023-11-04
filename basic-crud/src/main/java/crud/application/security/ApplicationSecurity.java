//package crud.application.security;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//
//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurity {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf(csrf -> csrf.disable());
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/api/v1/auth/login").permitAll()
//                .requestMatchers("/api/v1/auth/register").permitAll()
//                .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
//                .anyRequest().authenticated());;
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    //Cryptography
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//}
