package com.booksmanager.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.booksmanager.api.utils.SenhaUtils;

@SpringBootApplication
public class BooksManagerApplication {
	@Value("${peginacao.qtd_por_pagina}")
	private int qtdPagina;
	
	public static void main(String[] args) {
		SpringApplication.run(BooksManagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### Quantidade de elementos por página - " + this.qtdPagina);
			String encodedPassword = SenhaUtils.generatePasswordBCrypt("123456");
			System.out.println("Senha codificada: "+encodedPassword);
			
			encodedPassword = SenhaUtils.generatePasswordBCrypt("123456");
			System.out.println("Senha codificada novamente: "+encodedPassword);
			
			System.out.println("Senha válida: "+ SenhaUtils.validatePassword("123456", encodedPassword));
		};
	}
}
