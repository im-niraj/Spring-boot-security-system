package com.spring.sprintbootsecuritylearn;

import com.spring.sprintbootsecuritylearn.Repository.UserRepository;
import com.spring.sprintbootsecuritylearn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SprintBootSecurityLearnApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SprintBootSecurityLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user  = new User();
        user.setEmail("john@gmail.com");
        user.setUsername("john");
        user.setPassword(this.bCryptPasswordEncoder.encode("john101"));
        user.setRole("ROLE_USER");
        this.userRepository.save(user);


        User user1  = new User();
        user1.setEmail("niraj@gmail.com");
        user1.setUsername("niraj");
        user1.setPassword(this.bCryptPasswordEncoder.encode("niraj101"));
        user1.setRole("ROLE_ADMIN");
        this.userRepository.save(user1);
    }
}
