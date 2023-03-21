package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        NetflixService netflix = new NetflixService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add TV Show");
            System.out.println("2. Add Movie");
            System.out.println("3. Create Account");
            System.out.println("4. Login");
            System.out.println("5. Logout");
            System.out.println("6. Search TV Shows by Title");
            System.out.println("7. Search TV Shows by Genre");
            System.out.println("8. Search TV Shows by Release Year");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter TV show title: ");
                    String tvShowTitle = scanner.next();
                    System.out.print("Enter TV show genre: ");
                    String tvShowGenre = scanner.next();
                    System.out.print("Enter TV show release year: ");
                    int tvShowReleaseYear = scanner.nextInt();
                    System.out.print("Enter TV show number of episodes: ");
                    int tvShowNumEpisodes = scanner.nextInt();
                    TVShow tvShow = new TVShow(tvShowTitle, tvShowGenre, tvShowReleaseYear, tvShowNumEpisodes);
                    netflix.addTVShow(tvShow);
                    System.out.println("TV show added successfully.");
                    break;
                case 2:
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.next();
                    System.out.print("Enter movie genre: ");
                    String movieGenre = scanner.next();
                    System.out.print("Enter movie release year: ");
                    int movieReleaseYear = scanner.nextInt();
                    System.out.print("Enter movie number of episodes: ");
                    int movieNumEpisodes = scanner.nextInt();
                    System.out.print("Enter movie duration: ");
                    int movieDuration = scanner.nextInt();
                    Movie movie = new Movie(movieTitle, movieGenre, movieReleaseYear, movieNumEpisodes, movieDuration);
                    netflix.addMovie(movie);
                    System.out.println("Movie added successfully.");
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    netflix.createAccount(username, password);
                    System.out.println("Account created successfully.");
                    break;
                case 4:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();
                    boolean loginSuccess = netflix.login(loginUsername, loginPassword);
                    if (loginSuccess) {
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Login failed.");
                    }
                    break;
                case 5:
                    netflix.logout();
                    System.out.println("Logout successful.");
                    break;
                case 6:
                    System.out.print("Enter TV show title: ");
                    String searchTitle = scanner.next();
                    ArrayList<TVShow> searchTitleResults = netflix.searchByTitle(searchTitle);
                    for (TVShow result : searchTitleResults) {
                        System.out.println(result.getTitle() + " (" + result.getReleaseYear() + ")");
                    }
                    break;
            }
        }
    }


    public static void runMenu () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Search TV Shows by Title");
            System.out.println("4. Search TV Shows by Genre");
            System.out.println("5. Search TV Shows by Release Year");
            System.out.println("6. View Favorites");
            System.out.println("7. Get Recommendations");
            System.out.println("8. Logout");
            System.out.println("9. Quit");

            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (NetflixService.login(username, password)) {
                        User currentUser = NetflixService.getCurrentUser();
                        System.out.println("Login successful");
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.next();
                    NetflixService.createAccount(newUsername, newPassword);
                    System.out.println("Account created successfully");
                    break;
                case 3:
                    System.out.print("Enter a title: ");
                    String title = scanner.next();
                    ArrayList<TVShow> resultsByTitle = NetflixService.searchByTitle(title);
                    System.out.println("Results:");
                    for (TVShow tvShow : resultsByTitle) {
                        System.out.println(tvShow.getTitle() + " (" + tvShow.getReleaseYear() + ")");
                    }
                    break;
                case 4:
                    System.out.print("Enter a genre: ");
                    String genre = scanner.next();
                    ArrayList<TVShow> resultsByGenre = NetflixService.searchByGenre(genre);
                    System.out.println("Results:");
                    for (TVShow tvShow : resultsByGenre) {
                        System.out.println(tvShow.getTitle() + " (" + tvShow.getReleaseYear() + ")");
                    }
                    break;

            }
        }
    }
}