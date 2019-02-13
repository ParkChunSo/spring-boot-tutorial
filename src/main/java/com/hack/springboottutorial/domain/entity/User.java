package com.hack.springboottutorial.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "user_tbl")
public class User {
    @Id
    private String id;

    private String pw;

    private String name;
}
