package com.swetzell.comandos;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import com.swetzell.audio.PlayerManger;

public class CommandHandler {

    public static void handleCommand(MessageReceivedEvent event, String message) {
        if (message.equalsIgnoreCase("!hola")) {
            event.getChannel().sendMessage("¡Hola! Soy tu bot de Discord en Java.").queue();
        } else if (message.startsWith("!play ")) {
            String url = message.substring(6);
            PlayerManger.getInstance().loadAndPlay(event.getGuild(), url);
        }
    }
}
