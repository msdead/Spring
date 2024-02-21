package DZ7.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/public-data").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/private-data").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/")
                        .permitAll());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        var user1 = User.withUsername("user").password("{bcrypt}$2a$10$c1vaZ1uaHp2vbOL9/kwTd.C0t1/u.blwU3Zzr3FoVQ.u65xqaiCg6").roles("USER").build();
        var user2 = User.withUsername("admin").password("{bcrypt}$2a$10$p9cPd1CR5e4qTNxgKd7d.uehfSMwrpA7gGbV1gba.NJAQTcTQ1Fdq").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
