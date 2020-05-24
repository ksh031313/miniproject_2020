package me.seung.miniproject_seung.repository;

import lombok.Getter;
import lombok.Setter;
import me.seung.miniproject_seung.domain.CustType;

@Getter @Setter
public class CustomerSearch {

    private String customerName;
    private CustType custType;
}