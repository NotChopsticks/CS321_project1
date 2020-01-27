import java.util.ArrayList;

public class Playlist<T> extends ArrayList<T> {
    String playlistName;
    String description;

    public Playlist() {

    }

    public void setPlaylistName(String name) {
        playlistName = name;
    }


}
