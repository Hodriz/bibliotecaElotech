package br.com.elotech.biblioteca.service;


import br.com.elotech.biblioteca.model.Genre;
import br.com.elotech.biblioteca.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre createGenre (Genre genre){
        return genreRepository.save(genre);
    }

    public List<Genre> listGenre(){
        return genreRepository.findAll();
    }

    public Genre findById(Long id){
        return genreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gênero não encontrado!"));}

    public Genre genreUpdate(long id, Genre genre){
        Genre newGenre=genreRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Gênero não encontrado!!"));

        newGenre.setGenre(genre.getGenre());

        return genreRepository.save(newGenre);
    }

    public String deleteGenre(Long id){
        if (genreRepository.findById(id).isPresent()){
            genreRepository.deleteById(id);
        }else{throw new IllegalArgumentException("Gênero não encontrado");}
        return "Gênero deletado !!";
    }
}
