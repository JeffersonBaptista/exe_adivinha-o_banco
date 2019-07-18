package exeAdinvinhacaoBanco.services;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exeAdinvinhacaoBanco.models.Jogador;
import exeAdinvinhacaoBanco.models.NumeroSortiado;
import exeAdinvinhacaoBanco.repositories.JogadorRepository;
import exeAdinvinhacaoBanco.repositories.NumeroSortiadoRopository;

@Service
public class NumeroSortiadoService {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private NumeroSortiadoRopository numeroSortiadoRopository;

	public String salvarJogo(Jogador jogador) {
		
		NumeroSortiado jogo = new NumeroSortiado();
		Random random = new Random();
		int numero = 1+random.nextInt(5);
		String mensagen="";
	
		
		if(jogador.getNumeroJogado()== numero) {
			jogo.setNumero(numero);
			jogo.setJogador(jogador);
			jogador.setNumeroSortiado(jogo);
			jogadorRepository.save(jogador);
					
			mensagen= "Parabéns vc ganhou\nNumero jogado "+ jogador.getNumeroJogado()+" numero sortiado" + numero;
		}else {
			mensagen= "Não foi desta vez\nNumero jogado "+ jogador.getNumeroJogado()+" numero sortiado" + numero;
		}

		return mensagen;
	}
	
	
}
