package org.acme.types.second;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty;

import java.math.BigDecimal;

@Schema(name = "SecondExampleValue", properties = {
        @SchemaProperty(name = "amount", implementation = BigDecimal.class),
        @SchemaProperty(name = "currency", implementation = String.class)
})
public class SecondExampleImpl {

    private BigDecimal amount;
    private String currency;


    public SecondExampleImpl(
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
        return "MonetaryAmount{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
