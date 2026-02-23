package JavaTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {
    @RepeatedTest(5)
    @DisplayName("Deposit money")
        // now we are able to get bank account as parameter using DI
    void deposit(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(200);
        assertEquals(200, bankAccount.getBalance());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
    }
}