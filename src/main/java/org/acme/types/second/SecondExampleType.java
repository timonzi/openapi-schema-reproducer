package org.acme.types.second;


import org.acme.types.first.FirstExampleImpl;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(ref = "SecondExampleValue")
public class SecondExampleType {

    private final FirstExampleImpl value;

    private final String internalValue1 = "internalValue1";
    private final Boolean internalValue2 = true;


    public SecondExampleType(
            final BigDecimal amount,
            final String currency
    ) {
        this.value = new FirstExampleImpl(amount, currency);
    }


    public SecondExampleType(final FirstExampleImpl value) {
        this.value = value;
    }


    public final boolean isNull() {
        return value == null;
    }


    public FirstExampleImpl getValue() {
        return value;
    }


    public String getInternalValue1() {
        return internalValue1;
    }


    public Boolean getInternalValue2() {
        return internalValue2;
    }


    @Override
    public String toString() {
        return "SecondExampleType{" +
                "value=" + value +
                '}';
    }
}
