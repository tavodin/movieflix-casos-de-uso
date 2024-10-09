package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private AuthService authService;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review reviewEntity = new Review();
        Movie movieEntity = movieRepository.getReferenceById(dto.getMovieId());
        User userEntity = authService.authenticated();

        reviewEntity.setText(dto.getText());
        reviewEntity.setMovie(movieEntity);
        reviewEntity.setUser(userEntity);

        return new ReviewDTO(repository.save(reviewEntity));
    }
}
