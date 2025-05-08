package org.acme.types.third;


import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

// Hint: `type = SchemaType.STRING` is not needed (like with Quarkus 3.20.0)
@Schema(implementation = Date.class, type = SchemaType.STRING)
public class ThirdExampleType {

    private final Date value;

    private final String internalValue = "internalValue";
    private final Boolean composite = true;


    public ThirdExampleType() {
        this.value = new Date();
    }


    public ThirdExampleType(final Date value) {
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
        return "ThirdExampleType{" +
                "value=" + value +
                '}';
    }
}
