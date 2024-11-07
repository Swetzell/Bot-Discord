package com.swetzell.comandos;

import com.swetzell.audio.VoiceChannelConnector;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import com.swetzell.audio.PlayerManger;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CommandHandler {

    public static void handleCommand(MessageReceivedEvent event, String message) throws GeneralSecurityException, IOException {
        if (message.equalsIgnoreCase("!hola")) {
            event.getChannel().sendMessage("¡Hola! Soy tu bot de Discord en Java.").queue();
        } else if (message.startsWith("!play ")) {
            String url = message.substring(6);
            PlayerManger.getInstance().loadAndPlay(event.getGuild(), url);

            // Conectar al canal de voz
            VoiceChannelConnector connector = new VoiceChannelConnector();
            connector.connectToVoiceChannel(event.getGuild(), event.getMember());
        }
    }
}
