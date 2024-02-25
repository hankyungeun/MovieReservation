package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    
    private String passwd;
    
    private String name;
}
