package exeAdinvinhacaoBanco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exeAdinvinhacaoBanco.models.Jogador;
import exeAdinvinhacaoBanco.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public void salvarJogador(Jogador jogador) {
		jogadorRepository.save(jogador);
	}
	
	public Iterable<Jogador> listarGanhadores(){
		return jogadorRepository.findAll();
	}

}
