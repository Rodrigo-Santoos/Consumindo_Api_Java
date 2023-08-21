package com.br.consumoapiViaCEP;

import com.br.consumoapiViaCEP.model.Endereco;
import com.br.consumoapiViaCEP.service.ViaCepService;


public class ConsumoApiViaCepApplication {

	public static void main(String[] args) {
		
		
		ViaCepService viaCepService = new ViaCepService();
		
		Endereco endereco = viaCepService.getEndereco("08151000"); // aqui voce coloca o CEP que vai querer buscar
		
		System.out.println(endereco);
	}

}
