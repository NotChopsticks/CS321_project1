import java.util.ArrayList;


// class for manipulating library status of a song
public class Library {

    // array list that contains all songs currently in the music library
    ArrayList<song> MusicLibrary;

    // array list containing all liked songs
    ArrayList<song> liked;

    // constructor method
    public Library (){
        MusicLibrary = new ArrayList<>();

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


}
