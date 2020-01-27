// class that is used to create song objects
public class song {
    // string containing the name of the song
    String songName;

    // String containing the artist of the song
    String songArtist;

    // string containing the album the song is on
    String songAlbum;
    
    // boolean that indicates a songs status of liked or disliked
    boolean liked;

    // constructor method
    public song(){
        songName = "";
        //songlyrics = "";
        songArtist = "";
        songAlbum = "";
    }

    // parameterized constructor method
    public song(String name, String artist, String album){
        songName = name;
        //songlyrics = lyrics;
        songArtist = artist;
        songAlbum = album;

    }







}
