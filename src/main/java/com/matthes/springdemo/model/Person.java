package com.matthes.springdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;
public class Person {

    private final UUID id;

    // Don't know how to add the dependency for this:
    // @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        System.out.println("Person-Constructor. id=" + id + ", name: " + name);
        this.id = id;
        this.name = name;
    }

    public String toString() {
        StringBuffer resultBuffer = new StringBuffer();
        if(id != null) {
            resultBuffer.append("id="+id.toString());
        } else {
            resultBuffer.append("id=<null>");
        }
        if(name != null) {
            resultBuffer.append(", name="+name.toString());
        } else {
            resultBuffer.append(", name=<null>");
        }
        return resultBuffer.toString();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

