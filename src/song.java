public class song {
    String songName;
    String lyrics;
    boolean liked;
    boolean disliked;
    boolean inLibrary;


    public song(){
        songName = "";
        lyrics = "";
        liked = false;
        disliked = false;
        inLibrary = false;
    }

    public song(String name){
        songName = name;
        lyrics = "";
        liked = false;
        disliked = false;
        inLibrary = false;
    }

    public void addLyrics(String newLyrics) {
        lyrics = newLyrics;
    }





}
