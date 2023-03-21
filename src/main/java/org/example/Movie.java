package org.example;

class Movie extends TVShow {
    private int duration;

    public Movie(String title, String genre, int releaseYear, int numEpisodes, int duration) {
        super(title, genre, releaseYear, numEpisodes);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
