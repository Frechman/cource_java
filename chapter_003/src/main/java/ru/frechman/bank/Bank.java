package ru.frechman.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    /**
     * Bank list. List of users with account of user.
     */
    private Map<User, List<Account>> listOfAccounts = new HashMap<>();

    /**
     * Add user to the list bank list.
     *
     * @param user the user.
     */
    public void addUser(User user) {
        listOfAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Delete user from the list bank.
     *
     * @param user the user.
     */
    public void deleteUser(User user) {
        listOfAccounts.remove(user);
    }

    /**
     * Set account to the user.
     *
     * @param passport the user passport.
     * @param account the account.
     * @return true if add account to user, false - otherwise.
     */
    public boolean addAccountToUser(String passport, Account account) {
        for (User user : listOfAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                return listOfAccounts.get(user).add(account);
            }
        }
        return false;
    }

    /**
     * Delete account.
     *
     * @param passport the passport of the user.
     * @param account account is which delete.
     * @return true if the account is deleted from the list user account, false - otherwise.
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        for (User user : listOfAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                return listOfAccounts.get(user).remove(account);
            }
        }
        return false;

    }

    /**
     * @return List of account if exist user with the passport, otherwise - empty new ArrayList.
     */
    public List<Account> getUserAccounts(String passport) {
        for (User user : listOfAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                return listOfAccounts.get(user);
            }
        }
        return new ArrayList<>();
    }

    /**
     * Get user account.
     *
     * @param passport the user passport.
     * @param requisite the account requisite.
     * @return if account is exist then return account, otherwise return null.
     */
    private Account getExistAccount(String passport, String requisite) {
        for (Account account : getUserAccounts(passport)) {
            if (account.getRequisites().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Transfer money from the source account to the destination account.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
            String destPassport, String destRequisite, double amount) {

        Account sourceAccount = getExistAccount(srcPassport, srcRequisite);
        Account destinationAccount = getExistAccount(destPassport, destRequisite);
        return sourceAccount != null
                // можно даже убрать эту проверку,
                && destinationAccount != null
                //потому что в методе тоже есть проверка на null.
                && sourceAccount.transferMoney(destinationAccount, amount);
    }

}