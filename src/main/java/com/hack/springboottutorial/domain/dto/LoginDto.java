package com.hack.springboottutorial.domain.dto;

import com.hack.springboottutorial.domain.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String id;

    private String pw;

    private String name;

    public User toEntity(){
        return User.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
