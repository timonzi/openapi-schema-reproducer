package org.acme.types;

import java.math.BigDecimal;

public class UseSchemaImplementationImpl {

    private BigDecimal amount;
    private String currency;


    public UseSchemaImplementationImpl(
            final BigDecimal amount,
            final String currency
    ) {
        this.amount = amount;
        this.currency = currency;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(final String currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "UseSchemaImplementationImpl{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
