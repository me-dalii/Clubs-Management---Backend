package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Account;
import cccc.club_management.repositories.AccountRepository;
import cccc.club_management.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;



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
}
