package org.example;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
class TVShow {

    private String title;
    private String genre;
    private int releaseYear;
    private int numEpisodes;
    private Collection<? extends TVShow> similarTVShows;
    private Movie[] movies;

    public TVShow(String title, String genre, int releaseYear, int numEpisodes) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.numEpisodes = numEpisodes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public void setSimilarTVShows(Collection<? extends TVShow> similarTVShows) {
        this.similarTVShows = similarTVShows;
    }


    public List<String> getGenres() {
        Set<String> genres = new HashSet<>();
        Iterable<? extends TVShow> tvShows = null;
        for (TVShow tvShow : tvShows) {
            genres.add(tvShow.getGenre());
        }
        for (Movie movie : movies) {
            genres.add(movie.getGenre());
        }
        return new ArrayList<>(genres);
    }

    public Collection<? extends TVShow> getSimilarTVShows() {
        return similarTVShows;
    }
}
