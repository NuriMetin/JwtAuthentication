package com.company.jwtauthentication;

import com.company.jwtauthentication.domain.Role;
import com.company.jwtauthentication.domain.User;
import com.company.jwtauthentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

   //@Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Nuri Metin","nurimetin98","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Ramazanov Rakif","ramazanovrakif98","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Yaverli Nicat","yaverlinicat98","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Cahangirli Murad","cahangirlimurad98","1234",new ArrayList<>()));

            userService.addRoleToUser("yaverlinicat98","ROLE_USER");
            userService.addRoleToUser("cahangirlimurad98","ROLE_USER");
            userService.addRoleToUser("ramazanovrakif98","ROLE_MANAGER");
            userService.addRoleToUser("nurimetin98","ROLE_ADMIN");
            userService.addRoleToUser("nurimetin98","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("nurimetin98","ROLE_MANAGER");
        };
    }
}
