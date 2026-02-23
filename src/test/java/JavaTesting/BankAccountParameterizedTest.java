package JavaTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 200, 300})
    @DisplayName("Deposit money")
    // now we are able to get bank account as parameter using DI
    void deposit(int money, BankAccount bankAccount) {
        bankAccount.deposit(money);
        assertEquals(money, bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"100, Mary", "200, Rachid", "150, Ted"})
    public void depositAndNameTest(double money, String name, BankAccount bankAccount) {
        bankAccount.deposit(money);
        bankAccount.setHolder(name);
        assertEquals(money, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolder());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "details.csv", delimiter = ',')
    public void depositAndNameFileTest(double money, String name, BankAccount bankAccount) {
        bankAccount.deposit(money);
        bankAccount.setHolder(name);
        assertEquals(money, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolder());
    }
}
