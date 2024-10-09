package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public MovieDetailsDTO findById(Long id) {
        return repository.findById(id)
                .map(MovieDetailsDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));
    }
}
