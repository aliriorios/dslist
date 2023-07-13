package com.devsuperior.dslist.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "belonging")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Belonging {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private BelongingPk id = new BelongingPk(); //Chave auxiliar para representar o ID da composição de Game e GameList (ManyToMany

    private Integer position;

    // constructor
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);

        this.position = position;
    }
}
