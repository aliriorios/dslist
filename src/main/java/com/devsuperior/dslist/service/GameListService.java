package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.entity.GameList;
import com.devsuperior.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll () {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDto::new).toList();
    }
}
