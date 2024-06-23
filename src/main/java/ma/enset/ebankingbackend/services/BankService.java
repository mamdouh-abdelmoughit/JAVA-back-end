package ma.enset.ebankingbackend.services;

import jakarta.transaction.Transactional;
import ma.enset.ebankingbackend.entities.BankAccount;
import ma.enset.ebankingbackend.entities.CurrentAccount;
import ma.enset.ebankingbackend.entities.SavingAccount;
import ma.enset.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("051a0322-8c0b-43ed-9dfe-4e48ddecd029").orElse(null);
        if(bankAccount!=null){
            System.out.println("**********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if(bankAccount instanceof CurrentAccount){
                System.out.println("Over Draft =>"+((CurrentAccount) bankAccount).getOverDraft());
            }
            else if(bankAccount instanceof SavingAccount){
                System.out.println("Rate=>"+((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperation().forEach(op->{
                System.out.println("===============================");
                System.out.println(op.getType()+"\t"+op.getAmount()+"\t"+op.getOperationDate());
            });
        }
    }
}
