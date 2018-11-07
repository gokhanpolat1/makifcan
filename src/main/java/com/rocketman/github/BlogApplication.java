package com.rocketman.github;

import com.rocketman.github.entity.security.Role;
import com.rocketman.github.entity.security.User;
import com.rocketman.github.service.security.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@Configuration
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new User(
                    "user", //username
                    "user", //password
                    Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
                    true//Active
            ));
        };
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
//        builder.userDetailsService(s -> new CustomUserDetails(userRepository.findByUsername(s)));
////        builder.userDetailsService(new UserDetailsService() {
////            @Override
////            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
////                return new  CustomUserDetails (userRepository.findByUsername(s));
////            }
////        });
//    }
}
