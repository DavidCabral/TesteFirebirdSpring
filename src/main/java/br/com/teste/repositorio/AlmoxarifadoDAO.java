package br.com.teste.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.entidades.Almoxarifado;

@Repository
public interface AlmoxarifadoDAO extends JpaRepository<Almoxarifado, Integer> {

}
