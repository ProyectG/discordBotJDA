package cl.voidkey.hidra.bot;

import java.util.Iterator;

import javax.security.auth.login.LoginException;

import cl.voidkey.hidra.bot.parameter.Parameters;

public class CoreBot extends Parameters {

	/**
	 * Clase para iniciar el bot.
	 * @param args, argumento 1 = ip la cual se consultara la ip en forma de dominio, argumento 2 = el token con el cual se conectara a tu bot.
	 * @throws LoginException
	 */
	public static void main(String[] args) throws LoginException {
		MessageListener hidraBot = new MessageListener();
		
		if(args.length == 2)
		{
			setToken(args[1]);
			setDns(args[0]);
			hidraBot.iniciar(args);
		}else
		{
			System.out.println("No se han agregado los argumentos minimos para iniciar.");
			System.exit(0);
		}
		
		
	}

}
