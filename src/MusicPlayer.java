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
<<<<<<< Updated upstream
=======
    ArrayList<song> MusicLibrary;
    ArrayList<song> queue;
    ArrayList<song> recommended;
    ArrayList<song> liked;
    ArrayList<song> disliked;
    ArrayList<song> shuffledQueue;
    Random shuffler = null;
    song currentSong;


>>>>>>> Stashed changes

    public MusicPlayer (){
        ArrayList<song> MusicLibrary;
        ArrayList<song> queue;
        ArrayList<song> recommended;
        ArrayList<song> liked;
        ArrayList<song> disliked;
        Random shuffler = new Random();

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
        
    }





}