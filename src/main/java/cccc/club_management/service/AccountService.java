package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    Account getAccountById(Long id) throws NotFoundException;
    Account saveAccount(Account account);
    void deleteAccount(Long id) throws NotFoundException;

}
