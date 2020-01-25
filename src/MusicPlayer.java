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
    Library myLibrary;


    public MusicPlayer (){
        queue = new ArrayList<>();
        playedSongs = new ArrayList<>();
        shuffler = new Random();
        currentSong = null;
        myLibrary = new Library();
    }

    public void addToLibrary(song newSong){
        myLibrary.addSong(newSong);
        System.out.println(newSong.songName + " added to Library");
    }

    public void addToLibrary(ArrayList<song> playlist){
        for (int i = 0; i < playlist.size(); i++) {
            myLibrary.addSong(playlist.get(i));
            System.out.println(playlist.get(i).songName + " added to Library");
        }

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
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    public void likeOrDislikeSong() {
       currentSong.liked = !currentSong.liked;
       System.out.println(currentSong.songName + " Liked");
    }

    public void nextSong() {
        playedSongs.add(currentSong);
        currentSong = queue.get(0);
        queue.remove(0);
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    public void prevSong() {
        queue.add(0, playedSongs.get(playedSongs.size()));
        currentSong = playedSongs.get(playedSongs.size());
        playedSongs.remove(currentSong);
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
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