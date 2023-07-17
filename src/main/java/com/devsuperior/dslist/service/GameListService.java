package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.entity.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll () {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDto::new).toList();
    }

    @Transactional
    public void move (Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> result = gameRepository.findByList(listId);
        GameMinProjection obj = result.remove(sourceIndex); //removendo da posição de origem
        result.add(destinationIndex, obj); //adicionando na nova posição

        //Pegando os intervalos; game acima e abaixo
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i < max; i++) {
            gameListRepository.updateBelongingPosition(listId, result.get(i).getId(), i);
        }
    }
}
