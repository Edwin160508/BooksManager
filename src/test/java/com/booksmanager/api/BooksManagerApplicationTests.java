package com.booksmanager.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.booksmanager.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BooksManagerApplicationTests {

	@Value("${peginacao.qtd_por_pagina}")
	private int qtdPagina;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCarregaContextoTeste() {
		assertEquals(300, this.qtdPagina);
	}
	
	/**
	 * Descrição: Teste de validação usando pacote spring Security "BCryptor"
	 * 
	 * Objetivo: Testar vários Hahs gerados pelo "BCryptor" validado com a mesma senha, deve
	 * retornar true para passar no teste. 
	 *   
	 */
	@Test
	public void testValidatePassword() {
		String encodedPassword = PasswordUtils.generatePasswordBCrypt("123456");
		System.out.println("Senha codificada: "+encodedPassword);
		
		encodedPassword = PasswordUtils.generatePasswordBCrypt("123456");
		System.out.println("Senha codificada novamente: "+encodedPassword);
		
		System.out.println("Senha válida: "+ PasswordUtils.validatePassword("123456", encodedPassword));
		
		assertEquals(true, PasswordUtils.validatePassword("123456", encodedPassword));
	}

}
