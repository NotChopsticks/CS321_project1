
// class that performs the download method
public class Downloader {

    // constructor method
    public Downloader() {

    }

    // method for downloading a song
    // simply outputs the status of a song being downloaded to the terminal
    public void downloadSong(song newSong){
        if (newSong != null) {
        System.out.println("Downloading "+ newSong.songName);
        }
        else {
            System.out.println("There is no song currently selected to download");
        }
    }

}
