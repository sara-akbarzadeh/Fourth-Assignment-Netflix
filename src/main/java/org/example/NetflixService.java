package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NetflixService {
    private List<Movie> movies;
    private static List<TVShow> tvShows;
    private static List<User> users;
    private static User currentUser;

    public NetflixService() {
        movies = new ArrayList<>();
        tvShows = new ArrayList<>();
        users = new ArrayList<>();
        currentUser = null;
    }

    public void addTVShow(TVShow tvShow){
        Movie movie = null;
        movies.add(movie);
    }

    public void addMovie(Movie movie){
        TVShow tvShow = null;
        tvShows.add(tvShow);
    }

    public static void createAccount(String username, String password) {
        User user = new User(username, password);
        users.add(user);
    }

    public static boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public static ArrayList<TVShow> searchByTitle(String title) {
        List<TVShow> results = new ArrayList<>();
        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(tvShow);
            }
        }
        return (ArrayList<TVShow>) results;
    }

    public static ArrayList<TVShow> searchByGenre(String genre) {
        List<TVShow> results = new ArrayList<>();
        for (TVShow tvShow : tvShows) {
            if (tvShow.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                results.add(tvShow);
            }
        }
        return (ArrayList<TVShow>) results;
    }


    public ArrayList<TVShow> searchByReleaseYear(int year) {
        List<TVShow> results = new ArrayList<>();
        for (TVShow tvShow : tvShows) {
            if (tvShow.getReleaseYear() == year) {
                results.add(tvShow);
            }
        }
        return (ArrayList<TVShow>) results;

    }

    public static User getCurrentUser() {
        return currentUser;
    }
}

