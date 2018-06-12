package test;

import javalab2.Account;
import javalab2.BankException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test case of account methods
 * 
 * @author Gall Anonim
 * @version 1.0
 * 
 */
public class AccountTest {

    Account account;

    @Test
    public void testPayment() throws javalab2.BankException, BankException {
        account = new Account(20);
        account.payment(100);
		assertEquals("Payment 100", account.getBalance(), 120, 0.01);

		account.payment(0);
		fail("Should an exception occurred during the gold deposit 0");

        account.payment(-30);
		fail("Should an exception occurred during the payment of the amount of negative");
    }

    @Test
    public void testMonthlyCapitalisation() {
        account = new Account(100);
        account.monthlyCapitalisation(3);
        assertEquals("Capitalisation 3% from 100",
                account.getBalance(), (100 + 100 * (3.0 / 100 / 12)), 0.01);

        account = new Account(0);
        account.monthlyCapitalisation(3);
        assertEquals("Capitalisation 3% from empty account",
                account.getBalance(), 0, 0.01);

        account = new Account(100);
        account.monthlyCapitalisation(0);
        assertEquals("Capitalisation 0% from 100",
                account.getBalance(), 100, 0.01);

        account = new Account(100);
        account.monthlyCapitalisation(-3);
        assertEquals("Capitalisation -3% from 100",
                account.getBalance(), 100 - 100 * (3.0 / 100 / 12), 0.01);
    }

    @Test
    public void testPayoff() {
        // to implement
    }
}
