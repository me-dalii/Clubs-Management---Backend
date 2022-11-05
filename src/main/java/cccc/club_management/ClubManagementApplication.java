package cccc.club_management;

import cccc.club_management.enums.Role;
import cccc.club_management.models.Account;
import cccc.club_management.models.Club;
import cccc.club_management.models.User;
import cccc.club_management.service.AccountService;
import cccc.club_management.service.ClubService;
import cccc.club_management.service.UserService;
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
    CommandLineRunner run(AccountService accountService, UserService userService){
        return args -> {
          Account account = new Account("admin","admin", Role.ADMIN,true,null);
          accountService.saveAccount(account);
          accountService.saveAccount(new Account("leader","leader", Role.LEADER,true,null));
          User user = new User();
          user.setAccount(account);
          user.setFirstName("admin");
          userService.saveUser(user);
        };
    }*/

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
