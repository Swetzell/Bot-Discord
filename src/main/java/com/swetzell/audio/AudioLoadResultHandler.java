package com.swetzell.audio;

import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public interface AudioLoadResultHandler {
    void trackLoaded(AudioTrack track);

    void playlistLoaded(AudioPlaylist playlist);

    void noMatches();

    void loadFailed(FriendlyException exception);
}