package org.acme.types.first;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(implementation = FirstExampleImpl.class)
public class FirstExampleType {

    private final FirstExampleImpl value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public FirstExampleType(
            final BigDecimal amount,
            final String currency
    ) {
        this.value = new FirstExampleImpl(amount, currency);
    }


    public FirstExampleType(final FirstExampleImpl value) {
        this.value = value;
    }


    public final boolean isNull() {
        return value == null;
    }


    public FirstExampleImpl getValue() {
        return value;
    }


    public String getInternalValue() {
        return internalValue;
    }


    public Boolean isComposite() {
        return composite;
    }


    @Override
    public String toString() {
        return "ExampleTypeA{" +
                "value='" + value + '\'' +
                '}';
    }
}
