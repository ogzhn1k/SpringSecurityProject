package com.usersecurity.userservice;

import com.usersecurity.userservice.domain.Role;
import com.usersecurity.userservice.domain.User;
import com.usersecurity.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"****","oguzhan","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"****","nil","1324",new ArrayList<>()));
            userService.saveUser(new User(null,"*****","onuralp","5432",new ArrayList<>()));
            userService.saveUser(new User(null,"****","ayse","3453",new ArrayList<>()));

            userService.addRoleToUser("oguzhan","ROLE_USER");
            userService.addRoleToUser("oguzhan","ROLE_ADMIN");
            userService.addRoleToUser("oguzhan","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("nil","ROLE_MANAGER");
            userService.addRoleToUser("onuralp","ROLE_ADMIN");
            userService.addRoleToUser("ayse","ROLE_SUPER_ADMIN");
        };
    }



}
