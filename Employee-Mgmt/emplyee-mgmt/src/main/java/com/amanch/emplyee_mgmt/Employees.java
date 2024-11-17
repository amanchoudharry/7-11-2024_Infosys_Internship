package com.amanch.emplyee_mgmt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private Long id ;
    private String name;
    private String contact;
    private String email;

//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName (String Name){
//        return name;
//    }
}
