package br.com.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.teste.entidades.Categoria;
import br.com.teste.repositorio.CategoriaDAO;

@Service
public class CategoriaService {
	
	@Autowired private CategoriaDAO dao;
	
	public Categoria getCategoria(Integer id) {
		return dao.findOne(id);
	}

	public List<Categoria> listarCategoria() {
		return dao.findAll();
	}

	@Transactional
	public void salvarCategoria(Categoria categoria) {
          dao.save(categoria);
	}

	public void excluirCategoria(Categoria categoria) {
           dao.delete(categoria);
	}

}
