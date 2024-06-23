package ma.enset.ebankingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("SA")
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends  BankAccount{

    private double interestRate;
}
