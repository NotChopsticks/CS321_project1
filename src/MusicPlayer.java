import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Class containing the methods by which songs can be played, queued, shuffled, skipped,
// liked, disliked, and other Spotify-related functions
// Calls methods from other classes to perform some tasks
public class MusicPlayer {

    // array list that will hold queued songs
    ArrayList<song> queue;

    // array list that stores the queue after it has been shuffled
    ArrayList<song> shuffledQueue;

    // Random class for generating a shuffled playlist
    Random shuffler = null;

    // The song object that the music player is currently playing
    song currentSong;

    // array list that stores songs that have been played
    ArrayList<song> playedSongs;

    // Library class for adding songs to the user's personal library
    Library myLibrary;



    //Constructor method
    public MusicPlayer()  {
        queue = new ArrayList<>();
        playedSongs = new ArrayList<>();
        shuffler = new Random();
        shuffledQueue = new ArrayList<>();
        currentSong = null;
        myLibrary = new Library();


    }

    // method for adding a new song to your music library
    // calls the method addSong from the Library class
    public void addToLibrary(song newSong){
        myLibrary.addSong(newSong);
        //System.out.println(newSong.songName + " added to Library");
    }

   // method for adding multiple songs to the library
   // despite the parameter being playlist, there is no relation to
   // the playlist feature.
    public void addToLibrary(ArrayList<song> playlist){
        for (int i = 0; i < playlist.size(); i++) {
            myLibrary.addSong(playlist.get(i));
            System.out.println(playlist.get(i).songName + " added to Library");
        }

    }

    // method for queueing songs to be played
    // takes a song name as a parameter
    // necessary for playing songs at all
    public void addToQueue(song newSong) {
        queue.add(newSong);
        System.out.println(newSong.songName + " - " + newSong.songAlbum + " by " + newSong.songArtist + " added to Queue");
    }


    // method for adding a playlist of songs to the queue
    // takes a playlist array list as a parameter
    public void addPlaylistToQueue() {
        Scanner in = new Scanner(System.in);
        String input;
        String[] token;
        System.out.println("Select a playlist");
        Playlist<song> selected;
        for (int i = 0; i < myLibrary.playlists.size(); i++) {
            System.out.println((i+1) + ": " + myLibrary.playlists.get(i).playlistName);
        }
        input = in.nextLine();
        token = input.split(" ");
        int x = Integer.parseInt(token[0]);
        if (x > 0 && x <= myLibrary.playlists.size()) {
            selected = myLibrary.playlists.get(x-1);
            queue.addAll(selected);
            System.out.println("Playlist Added");
        }

    }


    // method for adding multiple songs to queue
    // despite the parameter being "playlist" this has nothing
    // to do with playlists
    public void addToQueue(ArrayList<song> playlist) {
        queue.addAll(playlist);
        System.out.println("Songs added to queue");
    }

    // method for playing a song
    // takes a song as a parameter
    public void playSong(song newSong) {
        currentSong = newSong;
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    // method for liking or disliking a song
    // takes a song's liked status and inverts it, or responds with a message
    // if there is no song playing
    public void likeOrDislikeSong() {
        if (currentSong != null) {
            currentSong.liked = !currentSong.liked;
            if (currentSong.liked){
                myLibrary.addToLiked(currentSong);
            } else {
                myLibrary.liked.remove(currentSong);
            }
            System.out.println(currentSong.songName + " Liked");
        }else {
            System.out.println("There is no song currently selected to like");
        }

    }

    // method for skipping to the next song in the queue
    // takes the next song in the queue and sets it to the current song playing
    // responds with a message if there are no queued songs
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

    // method for skipping back to a previous song in the queue
    // takes the last song played from playedSongs and sets that equal to currentSong
    // if there have been no songs played, responds with a message
    public void prevSong() {
        if (playedSongs.isEmpty()){
            System.out.println("No Songs have been played");
            return;
        }
        queue.add(0, currentSong);
        currentSong = playedSongs.get(playedSongs.size()-1);
        playedSongs.remove(currentSong);
        System.out.println("Now Playing "+ currentSong.songName + " - " + currentSong.songAlbum + " - " + currentSong.songArtist);
    }

    // method for shuffling queue into a randomly organized new queue
    // relies on the Random class to generate a random index number for
    // each song in the queue and assigning them to a new queue arraylist
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

    // method that functions only to display if there are no songs playing.
    // since the current song playing is always displayed, this method
    // only functions to tell the user there is no song playing if they
    // request the info of the song when nothing is playing.
    public void showSongInfo(){
        if (currentSong != null){

        } else {
            System.out.println("No Song Currently Playing");
        }
    }

    // method for displaying songs currently in the queue
    // prints list of queued songs to the screen in order of their queueing
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