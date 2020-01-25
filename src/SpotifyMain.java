import java.util.Scanner;

public class SpotifyMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        String[] token;
        String firstWord;
        String secondWord;
        String thirdWord;
        MusicPlayer aPlayer = new MusicPlayer();
        //Library myLibrary = new Library();
        song Deja_Vu = new song("Deja Vu", "Dave Rodgers", "Super Eurobeat Presents Euromach 2");
        song Eye_of_The_Tiger = new song("Eye of The Tiger", "Survivor", "Eye of The Tiger");
        song Hotel_California = new song("Hotel California", "The Eagles", "Hotel California");
        song Chandelier = new song("Chandelier", "Sia", "1000 Forms of Fear");
        song Mooo = new song("Mooo!", "Doja Cat", "Amala");

        aPlayer.addToLibrary(Deja_Vu);
        aPlayer.addToLibrary(Eye_of_The_Tiger);
        aPlayer.addToLibrary(Hotel_California);
        aPlayer.addToLibrary(Chandelier);
        aPlayer.addToLibrary(Mooo);

        while(true) {
            input = in.nextLine();
            token = input.split(" ");
            firstWord = token[0];
            switch (firstWord){
                case "AddToQueue":

                    break;

                case "AddToLibrary":

                    break;

                case "play":

                    break;

                case "skip":

                    break;

                case "previous":

                    break;

                case "pause":

                    break;

                case "like":
                    aPlayer.likeOrDislikeSong();
                    break;
            }





        }



        //Code stuff
    }
}
