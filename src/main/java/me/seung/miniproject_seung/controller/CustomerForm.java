package me.seung.miniproject_seung.controller;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerForm {

    @NotBlank(message = "고객 이름은 필수 입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;

    private String custType;
    private int lineAmt;
    
    private Integer ssan;
    private Integer phoneNum;

    private Integer compRegistNum;
    private Integer compPhoneNum;
    private String representName;
}