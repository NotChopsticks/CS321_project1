import java.util.ArrayList;

public class Library {

    ArrayList<song> MusicLibrary;
    //ArrayList<song> recommended;
    ArrayList<song> liked;
    //ArrayList<song> disliked;
    public Library (){
        MusicLibrary = new ArrayList<>();
        //recommended = new ArrayList<>();
        liked = new ArrayList<>();
        //disliked = new ArrayList<>();

    }

    public void addSong (song newSong){
        MusicLibrary.add(newSong);
    }

    public void removeSong (song targetSong){
        MusicLibrary.remove(targetSong);
    }

    public void addToLiked (song newSong){
        liked.add(newSong);

    }


}
