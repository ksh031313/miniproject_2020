package me.seung.miniproject_seung;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Customer {
    
    @Id @GeneratedValue
    Integer custId;

    String custName;
    String address;
    String custType;
    Integer lineAmt;

    // Integer ssan;
    // Integer phoneNum;

    // Integer corpRegistNum;
    // Integer corpPhoneNum;
    // String representName;

}