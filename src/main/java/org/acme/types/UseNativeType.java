package org.acme.types;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

/**
 * Hint: Works only with <code>type = SchemaType.STRING</code>, which was not the case with older Quarkus versions (at least with 3.8.6 and 3.15.4)
 * Without this, it uses schema type <code>OBJECT</code> and includes all the internal properties (and also methods) again.
 */
@Schema(implementation = Date.class)
public class UseNativeType {

    private final Date value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public UseNativeType() {
        this.value = new Date();
    }


    public UseNativeType(final Date value) {
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
