import java.util.ArrayList;
import java.util.Scanner;


// class for manipulating library status of a song
public class Library {

    // array list that contains all songs currently in the music library
    ArrayList<song> MusicLibrary;

    // array list containing all playlists
    ArrayList<Playlist<song>> playlists;
      
    // array list containing all liked songs
    ArrayList<song> liked;
    String input;
    String[] token;
    Scanner in = new Scanner(System.in);

    // constructor method
    public Library (){
        MusicLibrary = new ArrayList<>();
        playlists = new ArrayList<>();
        //recommended = new ArrayList<>();

        liked = new ArrayList<>();

    }

    // method for adding a song to the user's personal music library
    // also used by main to populate Spotify with dummy songs on startup 
    public void addSong (song newSong){
        MusicLibrary.add(newSong);
    }

    // method for removing a song from the user's personal music library
    // simply removes the target song in the parameter from the MusicLibrary array list
    public void removeSong (song targetSong){
        MusicLibrary.remove(targetSong);
    }

    // method for liking a song
    // sets a song's status to liked, and adds it to the list of liked songs
    public void addToLiked (song newSong){
        liked.add(newSong);

    }

    public void printPlaylist() {
        System.out.println("Select a playlist");
        Playlist<song> selected;
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + ": " + playlists.get(i).playlistName);
        }
        input = in.nextLine();
        token = input.split(" ");
        int x = Integer.parseInt(token[0]);
        if (x > 0 && x <= playlists.size()) {
            selected = playlists.get(x-1);
            for (int i = 0; i < selected.size(); i++) {
                System.out.println((i + 1) + ": " + selected.get(i).songName + " - " + selected.get(i).songArtist);
            }
        }
    }

    public void addToPlaylist(){
        System.out.println("Select a playlist");
        int selectedIndex = 0;
        Playlist<song> selected;
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + ": " + playlists.get(i).playlistName);
        }
        input = in.nextLine();
        token = input.split(" ");
        int x = Integer.parseInt(token[0]);
        if (x > 0 && x <= playlists.size()) {
            selectedIndex = x-1;
            //selected = playlists.get(selectedIndex);

            System.out.println("Choose a source: ");
            System.out.println("1. Library");
            System.out.println("2. Playlist");
            System.out.println("3. New Song");
            input = in.nextLine();
            token = input.split(" ");
            int y = Integer.parseInt(token[0]);
            switch(y){
                case 1:
                    while(true) {
                        System.out.println("Please select a track with the 'add #' command");
                        for (int i = 0; i < MusicLibrary.size(); i++) {
                            System.out.println((i + 1) + ": " + MusicLibrary.get(i).songName + " - " + MusicLibrary.get(i).songArtist);
                        }

                        input = in.nextLine();
                        token = input.split(" ");
                        if (token[0].toUpperCase().equals("ADD")) {
                            int z = Integer.parseInt(token[1]);
                            if (z > 0 && z <= MusicLibrary.size()) {
                                playlists.get(selectedIndex).add(MusicLibrary.get(z-1));
                            }
                        }

                        System.out.println("Add more songs? (Y/N)");
                        input = in.nextLine();
                        token = input.split(" ");
                        if (!token[0].equals("Y")){
                            break;
                        }

                    }
                    break;

                case 2:
                    System.out.println("Select a playlist");

                    for (int i = 0; i < playlists.size(); i++) {
                        if (i != selectedIndex) {
                            System.out.println((i + 1) + ": " + playlists.get(i).playlistName);
                        }
                    }
                    input = in.nextLine();
                    token = input.split(" ");
                    int a = Integer.parseInt(token[0]);
                    if (a > 0 && a <= playlists.size()) {
                        playlists.get(selectedIndex).addAll(playlists.get(a-1));
                    }
                    break;

                case 3:
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
                    System.out.println("Add to Playlist? (Y/N)");
                    input = in.nextLine();
                    input = input.toUpperCase();
                    if (input.equals("Y")) {
                        playlists.get(selectedIndex).add(newSong);
                        System.out.println(newSong.songName + " - " + newSong.songAlbum + " by " + newSong.songArtist + " added to Music Library");
                    } else {
                        System.out.println("Operation Canceled");
                    }

                    break;
            }

        }




    }

    public void makeNewPlaylist(String name) {
        Playlist<song> temp = new Playlist<>();
        temp.playlistName = name;
        playlists.add(temp);
    }


}
