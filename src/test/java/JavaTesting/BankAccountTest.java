package JavaTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class BankAccountTest {

    @Test
    @DisplayName("Withdraw Check")
    void withdraw() {
        BankAccount bk = new BankAccount(1000, -500);
        assertEquals(500, bk.withdraw(500));
    }

    @Test
    @DisplayName("Withdraw more than minimum balance")
    void withdrawMoreThanBalance() {
        BankAccount bk = new BankAccount(1000, -500);
        assertThrows(RuntimeException.class, () -> bk.withdraw(2000));
    }

    @Test
    @DisplayName("Deposit money")
    void deposit() {
        BankAccount bk = new BankAccount(1000, -500);
        assertEquals(1200, bk.deposit(200));
    }

    @Test
    @DisplayName("Withdraw from active account")
    void isActive() {
        BankAccount bk = new BankAccount(1000, -500);
        // test runs only if our assumption is true, otherwise it is aborted
        assumingThat(bk.isActive(), () -> assertEquals(-200, bk.withdraw(1200)));
    }

    @Test
    void activeBalance() {
        BankAccount bk = new BankAccount(1000, -500);
        assumeTrue(bk.isActive());
    }

    @Test
    @DisplayName("Holder check")
    void getHolder() {
        BankAccount bk = new BankAccount(1000, -500);
        assertNull(bk.getHolder());
    }
}