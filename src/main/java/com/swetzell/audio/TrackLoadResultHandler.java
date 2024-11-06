package com.swetzell.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public class TrackLoadResultHandler implements com.swetzell.audio.AudioLoadResultHandler {
    private final AudioPlayer player;
    private final TrackScheduler scheduler;

    public TrackLoadResultHandler(AudioPlayer player, TrackScheduler scheduler) {
        this.player = player;
        this.scheduler = scheduler;
    }

    @Override
    public void trackLoaded(AudioTrack track) {
        scheduler.queue(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist playlist) {
        for (AudioTrack track : playlist.getTracks()) {
            scheduler.queue(track);
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
}