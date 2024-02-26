package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Borrower {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address;
    private String doB;
    private String gender;
    private String contactNumber;

}
