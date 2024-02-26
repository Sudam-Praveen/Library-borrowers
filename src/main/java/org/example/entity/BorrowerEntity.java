package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BorrowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address; 
    private String doB;
    private String gender;
    private String contactNumber;

}
