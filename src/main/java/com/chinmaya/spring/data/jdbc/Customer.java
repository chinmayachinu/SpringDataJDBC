package com.chinmaya.spring.data.jdbc;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@AllArgsConstructor()
@ToString
public class Customer {
    @Id
    private final Long id;

    private final String firstName;

    private final String lastName;

}