package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }


    public String getReguisites() {
        return requisites;
    }

    public void setValues(double values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Account{" + "values=" + values + ", requisites='" + requisites + '\'' + '}';
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
        return Double.compare(account.values, values) == 0 && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, requisites);
    }
}
