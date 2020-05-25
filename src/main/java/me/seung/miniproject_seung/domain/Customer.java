package me.seung.miniproject_seung.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "custType")
@Getter @Setter
public abstract class Customer {
    
    @Id @GeneratedValue
    @Column(name = "cust_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // @Enumerated(EnumType.STRING)
    //private CustType custType;
    private String custType;
    private int lineAmt;

	public void setCustId(int i) {
    }

}