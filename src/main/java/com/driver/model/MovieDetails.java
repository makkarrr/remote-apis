package com.driver.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetails {
    private Integer id;
    private String original_title;
    private Double popularity;
}
