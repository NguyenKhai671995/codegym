package com.codegym.validmusic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity(name = "Music")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "not exits")
    @Size(max = 800, message = "max size 800")
//    @Pattern(regexp = "[^&+,:;=?@#|'<>.-^*()%!]")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String name;

    @NotBlank(message = "not empty")
    @Size(max = 300, message = "max size 300")
//    @Pattern(regexp = "[^&+:;=?@#|'<>.-^*()%!]")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$")
    private String singer;
    private String link;

    //    @NotBlank(message = "not null")
//    @FutureOrPresent
    private Date date;

    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = false, referencedColumnName = "id")
    private Category category;

}
