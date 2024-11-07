package com.swetzell.audio;

import com.google.api.services.youtube.model.SearchResult;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import net.dv8tion.jda.api.entities.Guild;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManger {
    private static PlayerManger INSTANCE;
    private final AudioPlayerManager playerManager;
    private final Map<Long, GuildMusicManager> musicManagers;
    private final YouTubeService youTubeService;

    private PlayerManger() throws GeneralSecurityException, IOException {
        this.playerManager = new DefaultAudioPlayerManager();
        this.musicManagers = new HashMap<>();
        this.youTubeService = new YouTubeService();
        AudioSourceManagers.registerRemoteSources(playerManager);
    }

    public synchronized GuildMusicManager getGuildMusicManager(Guild guild) {
        return musicManagers.computeIfAbsent(guild.getIdLong(), guildId -> {
            GuildMusicManager guildMusicManager = new GuildMusicManager(playerManager);
            guild.getAudioManager().setSendingHandler(guildMusicManager.getSendHandler());
            guildMusicManager.player.addListener(guildMusicManager.scheduler);
            return guildMusicManager;
        });
    }

    public void loadAndPlay(Guild guild, String query) {
        GuildMusicManager musicManager = getGuildMusicManager(guild);

        try {
            List<SearchResult> results = youTubeService.searchVideos(query);
            if (!results.isEmpty()) {
                String videoId = results.get(0).getId().getVideoId();
                String trackUrl = "https://www.youtube.com/watch?v=" + videoId;

                playerManager.loadItemOrdered(musicManager, trackUrl, new AudioLoadResultHandler() {
                    @Override
                    public void trackLoaded(AudioTrack track) {
                        musicManager.scheduler.queue(track);
                    }

                    @Override
                    public void playlistLoaded(AudioPlaylist playlist) {
                        for (AudioTrack track : playlist.getTracks()) {
                            musicManager.scheduler.queue(track);
                        }
                    }

                    @Override
                    public void noMatches() {
                        // Notificar al usuario que no se encontraron coincidencias
                    }

                    @Override
                    public void loadFailed(FriendlyException exception) {
                        // Notificar al usuario que la carga falló
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar errores de búsqueda
        }
    }

    public static synchronized PlayerManger getInstance() throws GeneralSecurityException, IOException {
        if (INSTANCE == null) {
            INSTANCE = new PlayerManger();
        }
        return INSTANCE;
    }
}