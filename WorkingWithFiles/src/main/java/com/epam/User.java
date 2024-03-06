package com.epam;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private String name;
    private String address;
    private transient long salary;
    private double grade;
    private boolean isActive;
}
