package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class GameDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    // constructor
    public GameDto(Game game) {
        BeanUtils.copyProperties(game, this);

        /* BeanUtils
        * Usando o "copyProperties" para copiar os valores de cada campo.
        * Apenas se os nomes dos atriubtos forem iguais ao do Objeto copiado.
        * */
    }
}
