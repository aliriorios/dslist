package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //Garantindo que esse método é apenas de leitura
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById (Long id) {
        Optional<Game> result = gameRepository.findById(id);
        return new GameDto(result.get());
    }
}
