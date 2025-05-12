package org.acme.types;


import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

/**
 * Hint: Works only with `type = SchemaType.STRING`, which was not the case with older Quarkus versions (at least with 3.8.6 and 3.15.4)
 * Without this, it uses schema type `OBJECT`
 */

@Schema(implementation = Date.class, type = SchemaType.STRING)
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
