package com.atl.springboot.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@EqualsAndHashCode
@ToString
@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;

}
