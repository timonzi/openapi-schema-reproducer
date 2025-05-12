# openapi-schema-problem

## General

Check...

* [Swagger UI](http://localhost:8080/q/swagger-ui/#/)
* [openapi.json](./openapi/schema/openapi.json)
* [openapi.yaml](./openapi/schema/openapi.yaml)

Compare generated schemas with those in Quarkus 3.15.4 (see branch `quarkus-3.15.4`).

## Problems

### Szenario 1: Merge of `implementation` definition with detected properties/methods

* Example type: `UseSchemaImplementationType`
    * Uses `UseSchemaImplementationImpl` for `@Schema(implemenation)` definition

The type class (`UseSchemaImplementationType`) has some internal properties and also some methods.

#### Quarkus 3.20.0

When I check the schema with Quarkus 3.20.0, I see the following schemas:

```json
"UseSchemaImplementationImpl" : {
  "type" : "object",
  "properties" : {
    "amount" : {
      "type" : "number"
    },
    "currency" : {
      "type" : "string"
    }
  }
},
"UseSchemaImplementationType" : {
  "$ref" : "#/components/schemas/UseSchemaImplementationImpl",
  "type" : "object",
  "properties" : {
    "value" : {
      "type" : "string"
    },
    "internalValue" : {
      "type" : "string"
    },
    "composite" : {
      "type" : "boolean"
    },
    "null" : {
      "type" : "boolean"
    }
  }
},
```

The problem: I have the `ref` definition and also the properties and methods of `UseSchemaImplementationType`.

Side note: I don't understand why methods are part of the schema!?

#### Expected schemas

This is what I get with Quarkus 3.15.4 and what I expect:

```json
"UseSchemaImplementationImpl" : {
  "type" : "object",
  "properties" : {
    "amount" : {
      "type" : "number"
    },
    "currency" : {
      "type" : "string"
    }
  }
},
"UseSchemaImplementationType" : {
  "$ref" : "#/components/schemas/UseSchemaImplementationImpl"
},
```

### Szenario 2: Merge of `ref` definition with detected properties/methods

* Example type: `UseSchemaRefType`
    * Uses `UseSchemaRefDef` for `@Schema(ref)` definition

The type class (`UseSchemaRefType`) has some internal properties and also some methods.


#### Quarkus 3.20.0

When I check the schema with Quarkus 3.20.0, I see the following schemas:

```json
"MonetaryAmountSchema" : {
  "properties" : {
    "amount" : {
      "type" : "number"
    },
    "currency" : {
      "type" : "string"
    }
  },
  "type" : "object"
},
"UseSchemaRefType" : {
  "$ref" : "#/components/schemas/MonetaryAmountSchema",
  "type" : "object",
  "properties" : {
    "value" : {
      "type" : "string"
    },
    "internalValue" : {
      "type" : "string"
    },
    "composite" : {
      "type" : "boolean"
    },
    "null" : {
      "type" : "boolean"
    }
  }
}
```

The problem: I have the `ref` definition and also the properties and methods of `UseSchemaRefType`.

Side note: I don't understand why methods are part of the schema!?

#### Expected schemas

This is what I get with Quarkus 3.15.4 and what I expect:

```json
"MonetaryAmountSchema" : {
  "type" : "object",
  "properties" : {
    "amount" : {
      "type" : "number"
    },
    "currency" : {
      "type" : "string"
    }
  }
},
"UseSchemaRefType" : {
  "$ref" : "#/components/schemas/MonetaryAmountSchema"
}
```


### Szenario 3: Use of native type for `implementation` definition

* Example type: `UseNativeType`
    * Uses `Date` for `@Schema(implementation)` definition

The type class (`UseNativeType`) has some internal properties and also some methods.

#### Quarkus 3.20.0

When I check the schema with Quarkus 3.20.0, I see the following schemas:

```json
"Date" : {
  "type" : "string",
  "format" : "date",
  "examples" : [ "2022-03-10" ]
},
"UseNativeType" : {
  "$ref" : "#/components/schemas/Date",
  "type" : "object",
  "properties" : {
    "value" : {
      "$ref" : "#/components/schemas/Date"
    },
    "internalValue" : {
      "type" : "string"
    },
    "composite" : {
      "type" : "boolean"
    },
    "null" : {
      "type" : "boolean"
    }
  }
},
```

The problem: I have the `ref` definition and also the properties and methods of `UseNativeType`.

Side note: I don't understand why methods are part of the schema!?

#### Expected schemas

This is what I get with Quarkus 3.15.4 and what I expect:

```json
"Date" : {
  "format" : "date",
  "type" : "string",
  "example" : "2022-03-10"
},
"UseNativeType" : {
  "$ref" : "#/components/schemas/Date"
},
```

