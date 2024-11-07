package com.swetzell.audio;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class YouTubeService {
    private static final String APPLICATION_NAME = "EspongeBot";
    private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String API_KEY = "TokenApi";

    private final YouTube youtube;

    public YouTubeService() throws GeneralSecurityException, IOException {
        this.youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public List<SearchResult> searchVideos(String query) throws IOException {
        YouTube.Search.List search = youtube.search().list("id,snippet");
        search.setQ(query);
        search.setType("video");
        search.setMaxResults(5L);
        search.setKey(API_KEY);

        SearchListResponse response = search.execute();
        return response.getItems();
    }
}
