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

## Full schema definition 3.20.0

```json
{
  "openapi" : "3.1.0",
  "components" : {
    "schemas" : {
      "Date" : {
        "type" : "string",
        "format" : "date",
        "examples" : [ "2022-03-10" ]
      },
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
    }
  },
  "paths" : {
    "/schema/UseNativeType" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseNativeType"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          },
          "400" : {
            "description" : "Bad Request"
          }
        },
        "summary" : "Use Native Type",
        "tags" : [ "Greeting Resource" ]
      }
    },
    "/schema/UseSchemaImplementationType" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseSchemaImplementationType"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          },
          "400" : {
            "description" : "Bad Request"
          }
        },
        "summary" : "Use Schema Implementation Type",
        "tags" : [ "Greeting Resource" ]
      }
    },
    "/schema/UseSchemaRefType" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseSchemaRefType"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          },
          "400" : {
            "description" : "Bad Request"
          }
        },
        "summary" : "Use Schema Ref Type",
        "tags" : [ "Greeting Resource" ]
      }
    }
  },
  "info" : {
    "title" : "openapi-schema-reproducer API",
    "version" : "1.0.0-SNAPSHOT"
  },
  "servers" : [ {
    "url" : "http://localhost:8080",
    "description" : "Auto generated value"
  }, {
    "url" : "http://0.0.0.0:8080",
    "description" : "Auto generated value"
  } ]
}
```


## Full schema definition 3.15.4

```json
{
  "openapi" : "3.0.3",
  "info" : {
    "title" : "openapi-schema-reproducer API",
    "version" : "1.0.0-SNAPSHOT"
  },
  "servers" : [ {
    "url" : "http://localhost:8080",
    "description" : "Auto generated value"
  }, {
    "url" : "http://0.0.0.0:8080",
    "description" : "Auto generated value"
  } ],
  "paths" : {
    "/schema/UseNativeType" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseNativeType"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          }
        }
      }
    },
    "/schema/UseSchemaImplementationType" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseSchemaImplementationType"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          }
        }
      }
    },
    "/schema/UseSchemaRefType" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/UseSchemaRefType"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "Date" : {
        "format" : "date",
        "type" : "string",
        "example" : "2022-03-10"
      },
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
      "UseNativeType" : {
        "$ref" : "#/components/schemas/Date"
      },
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
      "UseSchemaRefType" : {
        "$ref" : "#/components/schemas/MonetaryAmountSchema"
      }
    }
  }
}
```