package exeAdinvinhacaoBanco.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import exeAdinvinhacaoBanco.models.Jogador;
import exeAdinvinhacaoBanco.services.JogadorService;
import exeAdinvinhacaoBanco.services.NumeroSortiadoService;

@Controller
public class NumeroSortidoController {

	@Autowired
	private NumeroSortiadoService numeroSortiadoService;

	@Autowired
	private JogadorService JogadorService;

	@GetMapping("/")
	public ModelAndView mapiarHome() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		modelAndView.addObject("ganhadores", JogadorService.listarGanhadores());
		return modelAndView;
	}

	@GetMapping("/jogar")
	public ModelAndView mapiarJogar() {
		ModelAndView modelAndView = new ModelAndView("jogar.html");
		return modelAndView;
	}
	
	@PostMapping("/jogar")
	public ModelAndView salvarGanhador(@Valid Jogador jogador, BindingResult bindingJogador) {
		ModelAndView modelAndView = new ModelAndView("jogar.html");
				
		List<String> mensagens = new ArrayList<String>();
		List<String> erros = new ArrayList<String>();
		
		if(bindingJogador.hasErrors()) {
			
			for (ObjectError objectError : bindingJogador.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
				modelAndView.addObject("erros", erros);			
				
			}
			
		}else {
			mensagens.add(numeroSortiadoService.salvarJogo(jogador));
			modelAndView.addObject("mensagens", mensagens);
		}
		
		return modelAndView;
		
		
	}
	
	
}
