package com.mental.io.data;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Users")
public class User {
     @Id
     @GeneratedValue
     private Long userId;
     private String userName;
     private String password;

}

