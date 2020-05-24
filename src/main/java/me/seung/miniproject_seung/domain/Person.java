package me.seung.miniproject_seung.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERSON")
@Getter @Setter
public class Person extends Customer {
    
    private Integer ssan;
    private Integer phoneNum;
}