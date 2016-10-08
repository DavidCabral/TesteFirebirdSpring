package br.com.teste.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.teste.Fachada;
import br.com.teste.entidades.Categoria;

@Controller
@RequestMapping("/almoxarifado/categorias")
public class CategoriaController {
	
	@Autowired Fachada fachada;
	
	@RequestMapping()
	public ModelAndView categoria(Categoria categoria) {		
		ModelAndView mv = new ModelAndView("almoxarifado/pages/cadastro/categoria/cadastroCategoria");
		return mv;
	}
	
	@RequestMapping(value = { "/salvar", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Categoria categoria, BindingResult result, Model model, RedirectAttributes attributes) {
		
		System.out.println("salvando");
		
		if (result.hasErrors()) {
			System.out.println("tem erro");
			return categoria(categoria);
		}		
		fachada.salvarCategoria(categoria);
		attributes.addFlashAttribute("mensagem", "categoria salva com sucesso!");
		return new ModelAndView("redirect:/almoxarifado/categorias");
	}

}
