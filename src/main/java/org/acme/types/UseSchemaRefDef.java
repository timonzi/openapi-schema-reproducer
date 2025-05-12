package org.acme.types;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty;

import java.math.BigDecimal;

@Schema(name = "MonetaryAmountSchema", properties = {
        @SchemaProperty(name = "amount", implementation = BigDecimal.class),
        @SchemaProperty(name = "currency", implementation = String.class)
})
public class UseSchemaRefDef {
}
