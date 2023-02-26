package com.cnu.devblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity(name = "slang")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Slang {
    @Id
    private String slang;
}
