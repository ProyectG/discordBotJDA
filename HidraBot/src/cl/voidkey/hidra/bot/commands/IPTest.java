package cl.voidkey.hidra.bot.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.voidkey.hidra.bot.parameter.Parameters;

class IPTest extends Parameters{
	
	String[] dominiosprueba = {"google.cl", "www.google.cl", "", null};
	String dominioserror = "prueba";
	IP clase;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		clase = new IP();
	}

	@Test
	void test() {
		for(String domain : dominiosprueba) {
			setDns(domain);
			String resultado = clase.execute();
			System.out.println("Resultado "+ resultado);
			assertNotEquals("error", resultado);
		}
		
	}
	
	@Test
	void testError() {
		setDns(dominioserror);
		String resultado = clase.execute();
		System.out.println("Resultado "+ resultado);
		assertEquals("error", resultado);
	}

}
