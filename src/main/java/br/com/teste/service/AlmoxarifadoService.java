package br.com.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.teste.entidades.Almoxarifado;
import br.com.teste.repositorio.AlmoxarifadoDAO;

@Service
public class AlmoxarifadoService {

	@Autowired private AlmoxarifadoDAO dao;
	
	public Almoxarifado getAlmoxarifado(Integer id) {
		return dao.findOne(id);
	}

	public List<Almoxarifado> listarAlmoxarifados() {
		return dao.findAll();
	}

	@Transactional
	public void salvarAlmoxarifado(Almoxarifado almoxarifado) {
          dao.save(almoxarifado);
	}

	public void excluirAlmoxarifado(Almoxarifado almoxarifado) {
           dao.delete(almoxarifado);
	}

}
