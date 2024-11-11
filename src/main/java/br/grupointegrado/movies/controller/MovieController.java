package br.grupointegrado.movies.controller;
import br.grupointegrado.movies.dto.MovieRequestDTO;
import br.grupointegrado.movies.model.Movie;
import br.grupointegrado.movies.repository.MovieRepository;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = this.repository.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));
    }
    // adiciona a coluna -- save
    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody MovieRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Movie movie = new Movie();
        movie.setNome(dto.nome());

        this.repository.save(movie);
        return ResponseEntity.ok(movie);
    }
    // adiciona a coluna -- delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Movie movie = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        this.repository.delete(movie);
        return ResponseEntity.noContent().build();
    }
    // adiciona a coluna -- update
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Integer id, @RequestBody MovieRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Movie movie = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        movie.setNome(dto.nome());

        this.repository.save(movie);
        return ResponseEntity.ok(movie);
    }
    // adiciona a coluna -- addNota
    @PostMapping("/{id}/nota")
            public  ResponseEntity<Movie> addNota(@PathVariable Integer id,
                                                  @RequestBody BigDecimal nota){
        Movie movie = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        movie.setNota(nota);

        this.repository.save(movie);
        return ResponseEntity.ok(movie);
    }
    // adiciona a coluna -- descricao
    @PostMapping("/{id}/descricao")
    public  ResponseEntity<Movie> descricao(@PathVariable Integer id,
                                          @RequestBody String descricao){
        Movie movie = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        movie.setDescricao(descricao);

        this.repository.save(movie);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/{id}/comentario")
    public  ResponseEntity<Movie> comentario(@PathVariable Integer id,
                                            @RequestBody String comentario){
        Movie movie = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        movie.setComentario(comentario);

        this.repository.save(movie);
        return ResponseEntity.ok(movie);
    }

}