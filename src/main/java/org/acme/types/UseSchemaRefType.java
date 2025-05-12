package org.acme.types;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(ref = "MonetaryAmountSchema")
public class UseSchemaRefType {

    private final String value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public UseSchemaRefType(
            final BigDecimal amount,
            final String currency
    ) {
        this.value = amount + " " + currency;
    }


    public UseSchemaRefType(final String value) {
        this.value = value;
    }


    public final boolean isNull() {
        return value == null;
    }


    public String getValue() {
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
        return "UseSchemaRefType{" +
                "value='" + value + '\'' +
                ", internalValue='" + internalValue + '\'' +
                ", composite=" + composite +
                '}';
    }
}
