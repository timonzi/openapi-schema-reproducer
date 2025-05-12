package org.acme.types;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

/**
 * Hint: Works also without `type = SchemaType.STRING`, which is not the case for Quarkus 3.20.0
 */

@Schema(implementation = Date.class)
public class UseNativeTypeType {

    private final Date value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public UseNativeTypeType() {
        this.value = new Date();
    }


    public UseNativeTypeType(final Date value) {
        this.value = value;
    }


    public final boolean isNull() {
        return value == null;
    }


    public Date getValue() {
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
        return "UseNativeTypeType{" +
                "value=" + value +
                ", internalValue='" + internalValue + '\'' +
                ", composite=" + composite +
                '}';
    }
}
