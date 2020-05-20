package me.seung.miniproject_seung.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CORP")
@Getter @Setter
public class Corporation extends Customer{
    
    private Integer corpRegistNum;
    private Integer corpPhoneNum;
    private String representName;
}