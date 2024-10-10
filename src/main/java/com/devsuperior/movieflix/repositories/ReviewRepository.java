package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("""
            SELECT new com.devsuperior.movieflix.dto.ReviewDTO(obj)
            FROM Review obj
            WHERE obj.movie.id = :id
            """)
    Page<ReviewDTO> findByMovieId(Long id, Pageable pageable);
}
