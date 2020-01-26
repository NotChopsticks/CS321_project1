import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



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




    public MusicPlayer()  {
        queue = new ArrayList<>();
        playedSongs = new ArrayList<>();
        shuffler = new Random();
        shuffledQueue = new ArrayList<>();
        currentSong = null;
        myLibrary = new Library();


    }

    public void addToLibrary(song newSong){
        myLibrary.addSong(newSong);
        //System.out.println(newSong.songName + " added to Library");
    }

    public void addToLibrary(ArrayList<song> playlist){
        for (int i = 0; i < playlist.size(); i++) {
            myLibrary.addSong(playlist.get(i));
            System.out.println(playlist.get(i).songName + " added to Library");
        }

    }

    public void addToQueue(song newSong) {
        queue.add(newSong);
        System.out.println(newSong.songName + " - " + newSong.songAlbum + " by " + newSong.songArtist + " added to Queue");
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
        if (currentSong != null) {
            currentSong.liked = !currentSong.liked;
            System.out.println(currentSong.songName + " Liked");
        }else {
            System.out.println("There is no song currently selected to like");
        }

    }

    public void nextSong() {
        if (queue.isEmpty()){
            System.out.println("No songs in queue");
            return;
        }
        if (currentSong != null) {
            playedSongs.add(currentSong);
        }
        if (currentSong != null) {
            System.out.println("Song Skipped");
        }
        currentSong = queue.get(0);
        queue.remove(0);

        //System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    public void prevSong() {
        if (playedSongs.isEmpty()){
            System.out.println("No Songs have been played");
            return;
        }
        queue.add(0, playedSongs.get(playedSongs.size()));
        currentSong = playedSongs.get(playedSongs.size());
        playedSongs.remove(currentSong);
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    public void shuffleQueue() {
        if (queue.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        ArrayList<song> originalQueue = queue;
        
        int index;
        int numberOfSongs = queue.size();
        for (int i = 0; i < numberOfSongs; i++) {

            index = shuffler.nextInt(originalQueue.size());
            shuffledQueue.add(originalQueue.get(index));
            originalQueue.remove(index);

        }
        
        queue = shuffledQueue;
        System.out.println("Queue Shuffled");
        
    }

    public void showSongInfo(){
        if (currentSong != null){

        } else {
            System.out.println("No Song Currently Playing");
        }
    }

    public void showQueue() {
        if (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++){
                System.out.println((i+1) + ". " + queue.get(i).songName + " - " + queue.get(i).songArtist);
            }
        }else{
            System.out.println("Queue is empty");
        }

    }


}