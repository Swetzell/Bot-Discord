package com.swetzell.bot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        String token = "MTEzNzE2ODU0NDMxNzA1MDkyMA.Gx-WFo.8h2P0cl55nvgq9JaQralA2TZR2HxAdrGBAHJzg";

        JDABuilder builder = JDABuilder.createDefault(token);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(new DiscordBot());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!hola")) {
            event.getChannel().sendMessage("¡Hola! Soy tu bot de Discord en Java.").queue();
        }
    }
}
