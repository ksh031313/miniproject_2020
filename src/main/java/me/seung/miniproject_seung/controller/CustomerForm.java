package me.seung.miniproject_seung.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerForm {

    @NotEmpty(message = "고객 이름은 필수 입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}