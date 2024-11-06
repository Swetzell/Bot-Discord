package com.swetzell.audio;

import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public interface VoiceChannel extends GuildChannel, AudioChannel {

    AudioManager getAudioManager();
}
