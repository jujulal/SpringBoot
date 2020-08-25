package com.irene.appointments.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Bibek on 3/14/2018.
 */
@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
