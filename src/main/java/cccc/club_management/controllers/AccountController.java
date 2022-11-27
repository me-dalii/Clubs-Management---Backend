package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Account;
import cccc.club_management.models.Club;
import cccc.club_management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return accountService.getAccountById(id);
    }

    @PostMapping("/")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable(name = "id") Long id) throws NotFoundException {
        accountService.deleteAccount(id);
    }

    @PutMapping("/status/{accountId}")
    public Account updateAccountStatus(@PathVariable(name = "accountId") Long accountId, @RequestBody boolean status) throws NotFoundException {
        System.out.println(accountId + " " + status);
        return accountService.updateAccountStatus(accountId, status);
    }
}
