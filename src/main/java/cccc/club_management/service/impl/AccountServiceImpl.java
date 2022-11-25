package cccc.club_management.service.impl;

import cccc.club_management.enums.Role;
import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Account;
import cccc.club_management.models.Club;
import cccc.club_management.repositories.AccountRepository;
import cccc.club_management.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;



    @Override
    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) throws NotFoundException {
        if(this.accountRepository.findById(id).isPresent()) {
            return this.accountRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Account saveAccount(Account account) {
        log.info("Saving new account to the DB");
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return this.accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) throws NotFoundException {
        if(this.accountRepository.existsById(id)) {
            this.accountRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null){
            log.error("Account not found in the database");
            throw new UsernameNotFoundException("Account not found in the database");
        }else if(account.getStatus() == null || !account.getStatus()){
            log.error("Account not Active");
            throw new UsernameNotFoundException("Account not active");
        }
        else{
            log.info("Account found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole().name()));
        return new User(account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public Account updateAccountStatus(Long accountId, boolean status) throws NotFoundException{
        Account account = this.getAccountById(accountId);
        account.setStatus(status);
        return this.accountRepository.save(account);

    }
}
