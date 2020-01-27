
import java.util.Scanner;

// main class that runs the user interface
public class SpotifyMain {
    public static void main(String[] args) {
        // instance of Scanner class that takes user input
        Scanner in = new Scanner(System.in);

        // string that stores user input
        String input;

        // string for separating inputs into commands via cases
        String[] token;

        // string for holding the first word inputted by the user
        String firstWord;

        // string for holding the second word inputted by the user
        String secondWord;
        
        // string for holding the third word inputted by the user
        String thirdWord;

        // boolean for the status of whether or not a song is playing initialized to false
        boolean playing = false;

        // boolean for the status of whether or not a song is paused initialized to true
        boolean paused = true;

        // boolean for the status of whether or not a song has been selected initialized to false
        boolean songSelected = false;

        // MusicPlayer class instance that will be used by main to play music
        MusicPlayer aPlayer = new MusicPlayer();

        // Downloader class instance that will be used by main to download music
        Downloader downloader = new Downloader();

        // Creating a few song objects as stand-ins for the actual Spotify catalog
        song Deja_Vu = new song("Deja Vu", "Dave Rodgers", "Super Eurobeat Presents Euromach 2");
        song Eye_of_The_Tiger = new song("Eye of The Tiger", "Survivor", "Eye of The Tiger");
        song Hotel_California = new song("Hotel California", "The Eagles", "Hotel California");
        song Chandelier = new song("Chandelier", "Sia", "1000 Forms of Fear");
        song Mooo = new song("Mooo!", "Doja Cat", "Amala");

        aPlayer.addToLibrary(Deja_Vu);
        aPlayer.addToLibrary(Eye_of_The_Tiger);
        aPlayer.addToLibrary(Hotel_California);
        aPlayer.addToLibrary(Chandelier);
        aPlayer.addToLibrary(Mooo);




        // while loop that perpetually functions as the music player until the program
        // is terminated. Takes text inputs as user commands and uses various use cases
        // as individual command executions
        while(true) {
            if (aPlayer.currentSong == null){
                songSelected = false;
            }
            if (songSelected) {
                if (playing) {
                    System.out.println("Now Playing: ");
                    System.out.println("Title: " + aPlayer.currentSong.songName);
                    System.out.println("Artist: " + aPlayer.currentSong.songArtist);
                    System.out.println("Album: " + aPlayer.currentSong.songAlbum);
                } else if (paused) {
                    System.out.println("Player Paused");
                    System.out.println("Current Song: ");
                    System.out.println("Title: " + aPlayer.currentSong.songName);
                    System.out.println("Artist: " + aPlayer.currentSong.songArtist);
                    System.out.println("Album: " + aPlayer.currentSong.songAlbum);
                }
            }

            System.out.println("Enter a Command:");
            input = in.nextLine();
            token = input.split(" ");
            firstWord = token[0].toUpperCase();
            switch (firstWord) {
                case "ADDTOQUEUE":
                    while (true) {

                        System.out.println("Please select a track with the 'add #' command");
                        for (int i = 0; i < aPlayer.myLibrary.MusicLibrary.size(); i++) {
                            System.out.println((i + 1) + ": " + aPlayer.myLibrary.MusicLibrary.get(i).songName + " - " + aPlayer.myLibrary.MusicLibrary.get(i).songArtist);
                        }

                        input = in.nextLine();
                        token = input.split(" ");
                        if (token[0].toUpperCase().equals("ADD")) {
                            int x = Integer.parseInt(token[1]);
                            if (x > 0 && x <= aPlayer.myLibrary.MusicLibrary.size()) {
                                aPlayer.addToQueue(aPlayer.myLibrary.MusicLibrary.get(x - 1));

                                //aPlayer.queue.add(aPlayer.myLibrary.MusicLibrary.get(x-1));
                                //System.out.println(aPlayer.myLibrary.MusicLibrary.get(x-1).songName + " by " + aPlayer.myLibrary.MusicLibrary.get(x-1).songArtist + " added to queue");
                                break;
                            }
                        } else if (token[0].toUpperCase().equals("CANCEL") || token[0].toUpperCase().equals("QUIT")) {
                            break;
                        } else {
                            System.out.println("Invalid Command");
                        }
                    }
                    break;

                case "ADDTOLIBRARY":
                    String name = "";
                    String album = "";
                    String artist = "";
                    System.out.println("Please enter the song name");
                    input = in.nextLine();
                    name = input;
                    System.out.println("Please enter the song artist");
                    input = in.nextLine();
                    artist = input;
                    System.out.println("Please enter the song album");
                    input = in.nextLine();
                    album = input;

                    song newSong = new song(name, artist, album);
                    System.out.println(newSong.songName + " - " + newSong.songAlbum + " by " + newSong.songArtist);
                    System.out.println("Add to Library? (Y/N)");
                    input = in.nextLine();
                    input = input.toUpperCase();
                    if (input.equals("Y")) {
                        aPlayer.addToLibrary(newSong);
                        System.out.println(newSong.songName + " - " + newSong.songAlbum + " by " + newSong.songArtist + " added to Music Library");
                    } else {
                        System.out.println("Operation Canceled");
                    }
                    break;

                case "PLAY":
                    if (aPlayer.queue.isEmpty() && aPlayer.currentSong == null) {
                        System.out.println("Queue is empty. Please add songs to the queue before using the play command");
                        break;
                    }
                    if (!songSelected && aPlayer.queue.get(0) != null) {
                        aPlayer.nextSong();
                        songSelected = true;
                    }
                    if (playing) {
                        System.out.println("Player already playing");
                    } else {
                        playing = true;
                        paused = false;
                    }

                    break;

                case "SKIP":
                    aPlayer.nextSong();
                    break;

                case "PREVIOUS":
                    aPlayer.prevSong();
                    break;

                case "PAUSE":
                    if (aPlayer.currentSong == null) {
                        System.out.println("No song to pause");
                        break;
                    }
                    if (paused) {
                        System.out.println("Player already paused");
                    } else {
                        paused = true;
                        playing = false;
                    }

                    break;

                case "LIKE":
                    aPlayer.likeOrDislikeSong();
                    break;

                case "PRINTQUEUE":
                    aPlayer.showQueue();
                    break;

                case "SHUFFLE":
                    aPlayer.shuffleQueue();

                    break;

                case "DOWNLOAD":
                    downloader.downloadSong(aPlayer.currentSong);
                    break;

                case "PRINTPLAYLIST":
                    aPlayer.myLibrary.printPlaylist();
                    break;

                case "NEWPLAYLIST":
                    System.out.println("Please Enter a Name:");
                    input = in.nextLine();
                    aPlayer.myLibrary.makeNewPlaylist(input);
                    break;

                case "ADDTOPLAYLIST":
                    aPlayer.myLibrary.addToPlaylist();
                    break;

                case "PLAYPLAYLIST":
                    aPlayer.addPlaylistToQueue();
                    break;

                default:
                    System.out.println("Invalid Command");
                    break;

            }




        }



        //Code stuff
    }
}
