package org.acme.types;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(implementation = UseSchemaImplementationImpl.class)
public class UseSchemaImplementationType {

    private final String value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public UseSchemaImplementationType(
            final BigDecimal amount,
            final String currency
    ) {
        this.value = amount + " " + currency;
    }


    public UseSchemaImplementationType(final String value) {
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
        return "UseSchemaImplementationType{" +
                "value='" + value + '\'' +
                ", internalValue='" + internalValue + '\'' +
                ", composite=" + composite +
                '}';
    }
}
