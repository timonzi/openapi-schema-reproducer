# openapi-schema-problem


## Problem

Check either...
* [Swagger UI](http://localhost:8080/q/swagger-ui/#/)
* [openapi.json](./openapi/schema/openapi.json)
* [openapi.yaml](./openapi/schema/openapi.yaml)

### Schema with Quarkus 3.20.0 (JSON)

```json
{
  "openapi" : "3.1.0",
  "components" : {
    "schemas" : {
      "FirstExampleImpl" : {
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
      "FirstExampleType" : {
        "$ref" : "#/components/schemas/FirstExampleImpl",
        "type" : "object",
        "properties" : {
          "value" : {
            "$ref" : "#/components/schemas/FirstExampleImpl"
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
      "SecondExampleType" : {
        "$ref" : "#/components/schemas/SecondExampleValue",
        "type" : "object",
        "properties" : {
          "value" : {
            "$ref" : "#/components/schemas/FirstExampleImpl"
          },
          "internalValue1" : {
            "type" : "string"
          },
          "internalValue2" : {
            "type" : "boolean"
          },
          "null" : {
            "type" : "boolean"
          }
        }
      },
      "SecondExampleValue" : {
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
      "ThirdExampleType" : {
        "type" : "string",
        "format" : "date",
        "examples" : [ "2022-03-10" ]
      }
    }
  },
  "paths" : {
    "/hello" : {
      "get" : {
        "responses" : {
          "200" : {
            "description" : "OK",
            "content" : {
              "text/plain" : {
                "schema" : {
                  "type" : "string"
                }
              }
            }
          }
        },
        "summary" : "Hello",
        "tags" : [ "Greeting Resource" ]
      }
    },
    "/hello/first" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/FirstExampleType"
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
        "summary" : "First",
        "tags" : [ "Greeting Resource" ]
      }
    },
    "/hello/second" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/SecondExampleType"
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
        "summary" : "Second",
        "tags" : [ "Greeting Resource" ]
      }
    },
    "/hello/third" : {
      "post" : {
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/ThirdExampleType"
              }
            }
          },
          "required" : true
        },
        "responses" : {
          "201" : {
            "description" : "Created"
          }
        },
        "summary" : "Third",
        "tags" : [ "Greeting Resource" ]
      }
    }
  },
  "info" : {
    "title" : "openapi-schema-problem API",
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


### Schema with Quarkus 3.15.4 (JSON)

```json
{
  "openapi" : "3.0.3",
  "info" : {
    "title" : "openapi-schema-problem API",
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
    "/hello" : {
      "get" : {
        "tags" : [ "Greeting Resource" ],
        "responses" : {
          "200" : {
            "description" : "OK",
            "content" : {
              "text/plain" : {
                "schema" : {
                  "type" : "string"
                }
              }
            }
          }
        }
      }
    },
    "/hello/first" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/FirstExampleType"
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
    "/hello/second" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/SecondExampleType"
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
    "/hello/third" : {
      "post" : {
        "tags" : [ "Greeting Resource" ],
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/ThirdExampleType"
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
      "FirstExampleImpl" : {
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
      "FirstExampleType" : {
        "$ref" : "#/components/schemas/FirstExampleImpl"
      },
      "SecondExampleType" : {
        "$ref" : "#/components/schemas/SecondExampleValue"
      },
      "SecondExampleValue" : {
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
      "ThirdExampleType" : {
        "format" : "date",
        "type" : "string",
        "example" : "2022-03-10"
      }
    }
  }
}
```