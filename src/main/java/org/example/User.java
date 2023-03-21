package org.example;
import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String password;
    private List<TVShow> favoriteTVShows;
    private List<TVShow> watchedTVShows;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.favoriteTVShows = new ArrayList<>();
        this.watchedTVShows = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void watchTVShow(TVShow tvShow) {
        watchedTVShows.add(tvShow);
        System.out.println(username + " is watching " + tvShow.getTitle());
    }

    public void addToFavorites(TVShow tvShow) {
        favoriteTVShows.add(tvShow);
        System.out.println(tvShow.getTitle() + " added to favorites for " + username);
    }

    public void viewFavorites() {
        System.out.println(username + "'s favorite TV shows:");
        for (TVShow tvShow : favoriteTVShows) {
            System.out.println(tvShow.getTitle());
        }
    }

    public List<TVShow> getRecommendations() {
        List<TVShow> recommendations = new ArrayList<>();
        for (TVShow tvShow : favoriteTVShows) {
            recommendations.addAll(tvShow.getSimilarTVShows());
        }
        return recommendations;
    }

    public List<TVShow> searchByTitle(String query) {
        List<TVShow> searchResults = new ArrayList<>();
        for (TVShow tvShow : favoriteTVShows) {
            if (tvShow.getTitle().contains(query)) {
                searchResults.add(tvShow);
            }
        }
        return searchResults;
    }

    public List<TVShow> searchByGenre(String query) {
        List<TVShow> searchResults = new ArrayList<>();
        for (TVShow tvShow : favoriteTVShows) {
            if (tvShow.getGenres().contains(query)) {
                searchResults.add(tvShow);
            }
        }
        return searchResults;
    }


    public List<TVShow> searchByReleaseYear(int year) {
        List<TVShow> searchResults = new ArrayList<>();
        for (TVShow tvShow : favoriteTVShows) {
            if (tvShow.getReleaseYear() == year) {
                searchResults.add(tvShow);
            }
        }
        return searchResults;
    }
}
