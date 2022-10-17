package cccc.club_management;

import cccc.club_management.enums.Role;
import cccc.club_management.models.Account;
import cccc.club_management.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;



@SpringBootApplication
public class ClubManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubManagementApplication.class, args);
    }

    /*@Bean
    CommandLineRunner run(AccountService accountService){
        return args -> {
          accountService.saveAccount(new Account("admin","admin", Role.ADMIN));
          accountService.saveAccount(new Account("leader","leader", Role.LEADER));

        };
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
