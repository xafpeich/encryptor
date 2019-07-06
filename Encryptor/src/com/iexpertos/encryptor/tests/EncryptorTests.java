package com.iexpertos.encryptor.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import com.iexpertos.encryptor.Encryptor;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class EncryptorTests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	void Encrypt_word_test() {
		
		Encryptor encryptor = new Encryptor();
		
		String result = encryptor.cryptWord("foo");
		
		assertThat(result, is("hqq"));
		
	}
	
	@Test
	void throw_error_when_encrypt_word_have_space() {
       
		//Arrange
		Encryptor encryptor = new Encryptor();
		
		assertThrows(InvalidParameterException.class,() ->{
			encryptor.cryptWord("foo bar");
		});
		
		
	}
	
	@Test
	void encrypt_word_to_numbers_test(){
		Encryptor encryptor = new Encryptor();
		
		String result = encryptor.cryptWordToNumbers("Hola");
		
		assertThat(result, is("7411311099"));
	}
	
	@Test
	void throw_error_when_encrypt_word_to_numbers_have_space() {
       
		Encryptor encryptor = new Encryptor();
		
		assertThrows(InvalidParameterException.class,() ->{
			encryptor.cryptWordToNumbers("Hola Mundo");
		});
		
		
	}
	
	
	@Test
	void encrypt_word_With_Chars_Replace_test() {
	
	Encryptor encryptor = new Encryptor();
	
	String result = encryptor.cryptWord("fooasdasdasdasdgrtrtgo","fo");
	
	assertThat(result, is("hqqasdasdasdasdgrtrtgq"));
	
    }
	
	
	@Test
	void encrypt_sentence_test() {
	
	Encryptor encryptor = new Encryptor();
	
	String result = encryptor.cryptSentence("foo oof");
	
	assertThat(result, is("hqq\"qqh"));
	
	}
	
	
	@Test
	void separa_palabras_de_una_frase() {
	
	Encryptor encryptor = new Encryptor();
	
	String sentence = new String("foo oof");
	
	String[] result = encryptor.getWords(sentence);	
	String[] expected = sentence.split(" ");
	
	assertThat(result, is(expected));
	
	}
	
	
	@Test
	void print_words_in_system_output_between_major_and_minor() {
		
    System.setOut(new PrintStream(outContent));
	Encryptor encryptor = new Encryptor();
	
	  encryptor.printWords("foo");
	
	  assertEquals("<foo>", outContent.toString());
	
}
	
	

}
