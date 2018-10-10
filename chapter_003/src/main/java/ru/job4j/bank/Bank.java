package ru.job4j.bank;

import java.util.*;

public class Bank {
    Map<User, List<Account>> userMap = new HashMap<>();

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        userMap.putIfAbsent(user, list); //do not need a check to null
    }

    public void deleteUser(User user) {
        if (userMap.get(user) != null) {
            userMap.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        if (passport != null && account != null) {
            for (User user : userMap.keySet()) {
                if (user.getPassport().equals(passport)) {
                    userMap.get(user).add(account);
                    break;
                }
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        if (passport != null) {
            for (User user : userMap.keySet()) {
                if (user.getPassport().equals(passport)) {
                    accounts = userMap.get(user);
                    break;
                }
            }
        }
        return accounts;
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (passport != null && account != null) {
            for (User user : userMap.keySet()) {
                if (user.getPassport().equals(passport)) {
                    userMap.get(user).remove(account);
                    break;
                }
            }
        }
    }

    public Account getUserAccountEqualsRequisite(String passport, String requisites) {
        Account result = null; //is this bad practice?
        List<Account> list = getUserAccounts(passport);
        for (Account src : list) {
            if (src.getReguisites().equals(requisites)) {
                result = src;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account src = getUserAccountEqualsRequisite(srcPassport, srcRequisite);
        Account dst = getUserAccountEqualsRequisite(destPassport, dstRequisite);
        if (amount <= src.getValues()) {
            src.setValues(src.getValues() - amount);
            dst.setValues(dst.getValues() + amount);
            result = true;
        }
        return result;
    }
}
