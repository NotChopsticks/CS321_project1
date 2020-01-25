import java.lang.reflect.Array;
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
    ArrayList<song> queue;
    Random shuffler = null;
    song currentSong;
    ArrayList<song> playedSongs;



    public MusicPlayer (){
        queue = new ArrayList<>();
        playedSongs = new ArrayList<>();
        shuffler = new Random();
        currentSong = null;
    }

    public void addToQueue(song newSong) {
        queue.add(newSong);
    }

    public void addToQueue(ArrayList<song> playlist) {
        queue.addAll(playlist);
    }

    public void playSong(String name) {

    }

    public void likeOrDislikeSong() {
       currentSong.liked = !currentSong.liked;
    }

    public void nextSong() {
        playedSongs.add(currentSong);
        currentSong = queue.get(0);
        queue.remove(0);
    }

    public void prevSong() {
        queue.add(0, playedSongs.get(playedSongs.size()));
        currentSong = playedSongs.get(playedSongs.size());
        playedSongs.remove(currentSong);

    }







}