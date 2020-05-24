package me.seung.miniproject_seung.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("COMPANY")
@Getter @Setter
public class Company extends Customer{
    
    private Integer compRegistNum;
    private Integer compPhoneNum;
    private String representName;
}