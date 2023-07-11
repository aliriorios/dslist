package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class GameMinDto {

    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    // constructor
    public GameMinDto(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }
}
