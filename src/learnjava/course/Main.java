package learnjava.course;

import java.awt.event.WindowFocusListener;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Modern Escapism", "blanket");
        album.addSong("White Noise", 4.37);
        album.addSong("Romance", 5.22);
        album.addSong("Last days of the Blue Blood Harvest", 5.27);
        album.addSong("Firmament", 3.45);
        album.addSong("Mighty Deep", 2.39);
        album.addSong("In Awe", 4.00);
        album.addSong("Where the Light Takes Us", 3.51);
        album.addSong("Burial", 4.40);
        album.addSong("Violence", 5.05);
        album.addSong("Silent Ground", 1.35);
        album.addSong("Last Light", 5.22);

        albums.add(album);

        album = new Album("Bon Iver", "Bon Iver");
        album.addSong("Perth", 4.22);
        album.addSong("Minnesota, WI", 3.52);
        album.addSong("Holocene", 5.37);
        album.addSong("Towers", 3.08);
        album.addSong("Mitchcant", 3.46);
        album.addSong("Hinnom, TX", 2.45);
        album.addSong("Wash", 4.59);
        album.addSong("Calgary", 4.10);
        album.addSong("Lisbon, OH", 1.33);
        album.addSong("Beth/Rest", 5.17);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Where the Light Takes Us", playList);
        albums.get(0).addToPlaylist("In Awe", playList);
        albums.get(0).addToPlaylist("Acacia", playList); //does not exist
        albums.get(1).addToPlaylist(4, playList);
        albums.get(1).addToPlaylist(10, playList);

        play(playList);


    }


    private static void play (LinkedList<Song> playList){

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
           int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                            if(listIterator.hasNext()){
                                System.out.println("Now replaying " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached the end of the list");
                            }
                        }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress:");
        System.out.println("0 - to quit\n" +
                    "1 - to play next song\n" +
                    "2 - play previous song\n" +
                    "3 - replay current song\n" +
                    "4 - list songs in the playlist\n" +
                    "5 - print a list of available actions\n" +
                    "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==============================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }

}
