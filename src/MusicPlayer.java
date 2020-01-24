import java.util.ArrayList;
import java.util.Random;

//- Music Player
//- Queue/Playlist
//- Music Library
// - Recommendeds
// - Liking and disliking songs
// - Downloading
// - Shuffle and skip


public class MusicPlayer {
    ArrayList<song> MusicLibrary;
    ArrayList<song> queue;
    ArrayList<song> recommended;
    ArrayList<song> liked;
    ArrayList<song> disliked;
    Random shuffler = null;
    song currentSong;



    public MusicPlayer (){
        MusicLibrary = new ArrayList<>();
        queue = new ArrayList<>();
        recommended = new ArrayList<>();
        liked = new ArrayList<>();
        disliked = new ArrayList<>();
        shuffler = new Random();
        currentSong = new song();

    }

    public void likeSong() {

    }







}