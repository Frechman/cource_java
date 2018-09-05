package ru.frechman.bank;

import java.util.Objects;

public class Account {

    /**
     * Amount of money.
     */
    private int values;

    /**
     * Bank account details.
     */
    private final String requisites;

    public Account(int values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public int getValues() {
        return values;
    }

    public String getRequisites() {
        return requisites;
    }

    /**
     * Transfer money from this account to another account.
     *
     * @param destination the another account.
     * @param amount the amount of money for transfer.
     * @return true if transfer is successful, otherwise false.
     */
    public boolean transferMoney(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < values && destination != null) {
            this.values -= amount;
            destination.values += amount;
            success = true;
        }
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
