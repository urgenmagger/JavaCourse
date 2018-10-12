package ru.job4j.bank;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("John", "1");
        bank.addUser(user);
        boolean result = bank.userMap.containsKey(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("John", "1");
        bank.deleteUser(user);
        boolean result = bank.userMap.containsKey(user);
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAccountUser() {
        Bank bank = new Bank();
        User user = new User("John", "1");
        Account accountFirst = new Account(12.5, "1");
        Account accountDouble = new Account(200086.5, "2");
        bank.addUser(user);
        bank.addAccountToUser("1", accountFirst);
        bank.addAccountToUser("1", accountDouble);
        List<Account> result = bank.getUserAccounts("1");
        assertThat(result.size(), is(2));

    }

    @Test
    public void ifDuplicateAccount() {
        Bank bank = new Bank();
        User user = new User("John", "1");
        Account accountFirst = new Account(12.5, "1");
        Account accountDouble = new Account(200086.5, "2");
        bank.addUser(user);
        bank.addAccountToUser("1", accountFirst);
        bank.addAccountToUser("1", accountFirst);
        bank.addAccountToUser("1", accountDouble);
        bank.addAccountToUser("1", accountDouble);
        List<Account> result = bank.getUserAccounts("1");
        assertThat(result.size(), is(2));

    }

    @Test
    public void whenDeleteUserAccounts() {
        Bank bank = new Bank();
        User user = new User("John", "1");
        Account accountFirst = new Account(12.5, "1");
        Account accountDouble = new Account(200086.5, "2");
        bank.addUser(user);
        bank.addAccountToUser("1", accountFirst);
        bank.addAccountToUser("1", accountDouble);
        bank.deleteAccountFromUser("1", accountDouble);
        List<Account> result = bank.getUserAccounts("1");
        int expected = result.indexOf(accountDouble);
        assertThat(-1, is(expected));

    }

    @Test
    public void whenTransferOneAccountSuccess() {
        Bank bank = new Bank();
        User user = new User("John", "10");
        Account accountFirst = new Account(10, "1");
        Account accountDouble = new Account(10, "2");
        bank.addUser(user);
        bank.addAccountToUser("10", accountFirst);
        bank.addAccountToUser("10", accountDouble);
        boolean tran = bank.transferMoney("10", "1", "10", "2", 5);
        assertThat(tran, is(true));

    }

    @Test
    public void whenTransferFailure() {
        Bank bank = new Bank();
        User user = new User("John", "10");
        User userM = new User("Mason", "11");
        Account accountFirst = new Account(5, "1");
        Account accountDouble = new Account(10, "2");
        bank.addUser(user);
        bank.addUser(userM);
        bank.addAccountToUser("10", accountFirst);
        bank.addAccountToUser("11", accountDouble);
        boolean tran = bank.transferMoney("10", "1", "11", "2", 5.1);
        assertThat(tran, is(false));

    }

    @Test
    public void auditByOneUser() {
        Bank bank = new Bank();
        User user = new User("John", "10");
        Account accountFirst = new Account(5.0, "1");
        Account accountDouble = new Account(10.0, "2");
        bank.addUser(user);
        bank.addAccountToUser("10", accountFirst);
        bank.addAccountToUser("10", accountDouble);
        boolean tran = bank.transferMoney("10", "1", "10", "2", 5.0);
        List<Account> listAccount = bank.getUserAccounts(user.getPassport());
        int index = listAccount.indexOf(accountDouble);
        double expected = listAccount.get(index).getValues();
        assertThat(15.0, is(expected));
    }

}
