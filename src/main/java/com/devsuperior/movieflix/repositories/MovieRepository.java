package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("""
            SELECT new com.devsuperior.movieflix.dto.MovieCardDTO(obj)
            FROM Movie obj
            WHERE (:genreId = 0 OR obj.genre.id = :genreId)
            ORDER BY obj.title
            """)
    Page<MovieCardDTO> findByGenre(Long genreId, Pageable pageable);

}
