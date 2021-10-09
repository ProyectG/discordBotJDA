package cl.voidkey.hidra.bot;

import java.awt.Color;

import javax.security.auth.login.LoginException;

import cl.voidkey.hidra.bot.commands.IP;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter
{
	IP ipCommand = new IP();
	
    public void iniciar(String[] args)
            throws LoginException
    {
        JDA jda = JDABuilder.createLight(args[1])
        		.addEventListeners(new MessageListener())
        		.setActivity(Activity.playing("ejecutandome desde Java"))
        		.build();
        
        jda.upsertCommand("ping", "Calcular ping desde el bot").queue();
        jda.upsertCommand("ip", "Obtener ip desde el host, informacion para servidores").queue();
        jda.upsertCommand("help", "Informacion relevante de los servicios.").queue();
        
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event)
    {
    	switch (event.getName()) {
    	case "ping" :
    		long time = System.currentTimeMillis();
    		event.reply("Pong!").setEphemeral(false).flatMap(v -> event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time )).queue();
    		break;
    	case "ip" :
    		event.reply("IP!").setEphemeral(true).flatMap(v -> event.getHook().editOriginalFormat("IP: %s", this.ipCommand.execute() )).queue();
    		break;
    	case "help" :
    		EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Menu Ayuda");
            eb.setDescription("Descripcion de los comandos dis \n"
            		+ "/ping , te entrega el tiempo de respuesta entre tu peticion y el bot. \n"
            		+ "/ip , te entrega la ip publica disponible ante un cambio. \n"
            		+ "/help , te entrega un detalle entre los comandos disponibles.");
            eb.setColor(Color.red);
            MessageEmbed mensaje = eb.build();
            event.reply("Help!").addEmbeds(mensaje).queue();
    	default :
    		break;
    	}
    }
    
    
}
