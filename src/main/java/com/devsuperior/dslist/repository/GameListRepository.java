package com.devsuperior.dslist.repository;

import com.devsuperior.dslist.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
    /* Atualização da posição ao mover um jogo na lista */
    @Modifying //para funções que não sejam "SELECT"
    @Query(nativeQuery = true,
    value = "UPDATE belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
