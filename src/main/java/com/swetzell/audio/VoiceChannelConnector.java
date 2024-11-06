package com.swetzell.audio;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import com.swetzell.audio.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.managers.AudioManager;

public class VoiceChannelConnector {

    public void connectToVoiceChannel(Guild guild, Member member) {
        AudioChannelUnion voiceChannel = member.getVoiceState().getChannel();
        if (voiceChannel != null) {
            AudioManager audioManager = guild.getAudioManager();
            audioManager.openAudioConnection(voiceChannel);
            System.out.println("Conectado al canal de voz: " + voiceChannel.getName());
        } else {
            System.out.println("El miembro no está en un canal de voz.");
        }
    }
}
