package br.com.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.entidades.Almoxarifado;
import br.com.teste.entidades.Categoria;
import br.com.teste.service.AlmoxarifadoService;
import br.com.teste.service.CategoriaService;

@Service
public class Fachada {
	@Autowired private AlmoxarifadoService almoxarifadoService;
	@Autowired private CategoriaService categoriaService;

	public Almoxarifado getAlmoxarifado(Integer id) {
		return almoxarifadoService.getAlmoxarifado(id);
	}

	public List<Almoxarifado> listarAlmoxarifados() {
		return almoxarifadoService.listarAlmoxarifados();
	}

	public void salvarAlmoxarifado(Almoxarifado almoxarifado) {
		almoxarifadoService.salvarAlmoxarifado(almoxarifado);
	}

	public void excluirAlmoxarifado(Almoxarifado almoxarifado) {
		almoxarifadoService.excluirAlmoxarifado(almoxarifado);
	}

	

	public Categoria getCategoriao(Integer id) {
		return categoriaService.getCategoria(id);
	}

	public List<Categoria> listarCategorias() {
		return categoriaService.listarCategoria();
	}

	public void salvarCategoria(Categoria categoria) {
		categoriaService.salvarCategoria(categoria);
	}

	public void excluirCategoria(Categoria categoria) {
		categoriaService.excluirCategoria(categoria);
	}

}
