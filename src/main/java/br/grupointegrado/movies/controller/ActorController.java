package br.grupointegrado.movies.controller;


import br.grupointegrado.movies.dto.ActorResquestDTO;
import br.grupointegrado.movies.dto.MovieRequestDTO;
import br.grupointegrado.movies.model.Actor;
import br.grupointegrado.movies.model.Category;
import br.grupointegrado.movies.model.Movie;
import br.grupointegrado.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    private ActorRepository repository; // preta atencao para nao colocar o mesmo nome da classe

    @GetMapping
    public ResponseEntity<List<Actor>> findAll() {
        List<Actor> actors = this.repository.findAll();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não encontrado"));
    }
    // add coluna save
    @PostMapping
    public ResponseEntity<Actor> save(@RequestBody ActorResquestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        Actor actor = new Actor();
        actor.setNome(dto.nome());

        this.repository.save(actor);
        return ResponseEntity.ok(actor);
    }
    //add coluna delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Actor actor = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não encontrado"));
        this.repository.delete(actor);
        return ResponseEntity.noContent().build();
    }
    //add coluna update
    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Integer id, @RequestBody ActorResquestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Actor actor = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Filme não foi encontrado"));

        actor.setNome(dto.nome());

        this.repository.save(actor);
        return ResponseEntity.ok(actor);
    }


}

