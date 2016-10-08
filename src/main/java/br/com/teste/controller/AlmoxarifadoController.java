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
import br.com.teste.entidades.Almoxarifado;

@Controller
@RequestMapping("/almoxarifado/almoxarifados")
public class AlmoxarifadoController {

	@Autowired Fachada fachada;
	
	@RequestMapping()
	public ModelAndView almoxarifado(Almoxarifado almoxarifado) {		
		ModelAndView mv = new ModelAndView("almoxarifado/pages/cadastro/almoxarifado/cadastroAlmoxarifado");
		return mv;
	}
	
	@RequestMapping(value = { "/salvar", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Almoxarifado almoxarifado, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return almoxarifado(almoxarifado);
		}		
		fachada.salvarAlmoxarifado(almoxarifado);
		attributes.addFlashAttribute("mensagem", "almoxarifado salvo com sucesso!");
		return new ModelAndView("redirect:/almoxarifado/almoxarifados");
	}
	
	
	
	
}
