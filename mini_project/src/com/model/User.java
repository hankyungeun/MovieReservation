package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Table;

@Table(name = "USER")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    
    private String passwd;
    
    private String name;
}
