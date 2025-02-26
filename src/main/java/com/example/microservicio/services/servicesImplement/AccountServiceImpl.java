package com.example.microservicio.services.servicesImplement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.microservicio.services.AcountService;
import com.example.microservicio.entities.Account;
import com.example.microservicio.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AcountService{
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List <Account>  findAllAccount(){
        return accountRepository.findAll();
    }
    @Override 
    public Account createNewAccount(Account newAccount){
        Account newAccountCreate=accountRepository.save(newAccount);
        return newAccountCreate;
    }

    @Override
    public Account updateAccount(Long id, Account updateAccount){
        Account accountFindById=accountRepository.findById(id).get();
        accountFindById.setAccountNumber(updateAccount.getAccountNumber());
        accountFindById.setAccountState(updateAccount.getAccountState());
        accountFindById.setAccountType(updateAccount.getAccountType());
        accountFindById.setOpeningBalance(updateAccount.getOpeningBalance());
        return accountRepository.save(accountFindById);
    }

    @Override
    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }
}
