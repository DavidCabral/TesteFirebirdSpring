package br.com.teste.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.entidades.Categoria;


@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

}
