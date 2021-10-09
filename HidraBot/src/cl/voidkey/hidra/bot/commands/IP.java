package cl.voidkey.hidra.bot.commands;

import java.net.InetAddress;

import cl.voidkey.hidra.bot.parameter.Parameters;

public class IP extends Parameters{

	public String execute() {
		try {
			InetAddress[] machines = InetAddress.getAllByName(getDns());
			for (InetAddress address : machines) {
				return address.getHostAddress();
			}
		} catch (Exception e) {
			return "Error al obtener la ip, consulta a la administracion";
		}
		return "error";

	}
}
