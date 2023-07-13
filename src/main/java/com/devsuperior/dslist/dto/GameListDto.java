package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.GameList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class GameListDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    // constructor
    public GameListDto(GameList list) {
        id = list.getId();
        name = list.getName();
    }
}
