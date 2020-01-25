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
    ArrayList<song> shuffledQueue;
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
        System.out.println("Songs added to queue");
    }

    public void addToQueue(ArrayList<song> playlist) {
        queue.addAll(playlist);
        System.out.println("Songs added to queue");
    }

    public void playSong(song newSong) {
        currentSong = newSong;
        System.out.println("Now Playing "+ currentSong.songName + ".");
    }

    public void likeOrDislikeSong() {
       currentSong.liked = !currentSong.liked;
       System.out.println("Song Liked");
    }

    public void nextSong() {
        playedSongs.add(currentSong);
        currentSong = queue.get(0);
        queue.remove(0);
        System.out.println("Now Playing "+ currentSong.songName + ".");
    }

    public void prevSong() {
        queue.add(0, playedSongs.get(playedSongs.size()));
        currentSong = playedSongs.get(playedSongs.size());
        playedSongs.remove(currentSong);
        System.out.println("Now Playing "+ currentSong.songName + ".");
    }

    public void shuffleQueue() {
        ArrayList<song> originalQueue = queue;
        
        int index;

        for (int i = 0; i < queue.size(); i++) {
            index = shuffler.nextInt(originalQueue.size());
            shuffledQueue.add(originalQueue.get(index));
            originalQueue.remove(index);
        }
        
        queue = shuffledQueue;
        System.out.println("Queue Shuffled");
        
    }





}