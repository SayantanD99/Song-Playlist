package com.sayantandas;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        /**
         * Create a program that implements a playlist for songs
         * Create a Song class having Title and Duration for a song.
         * The program will have an Album class containing a list of songs.
         * The albums will be stored in an ArrayList
         * Songs from different albums can be added to the playlist and will appear in the list in the order they are added.
         * Once the songs have been added to the playlist, create a menu of options to:-
         * Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
         * List the songs in the playlist
         * A song must exist in an album before it can be added to the playlist (so you can only play songs that you own).
         * Hint:  To replay a song, consider what happened when we went back and forth from a city before we started tracking the direction we were going.
         * As an optional extra, provide an option to remove the current song from the playlist
         * (hint: listiterator.remove()
         *
         * Modification -
         *
         * the Album class uses an inner class.
         * Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
         * The inner SongList class will use an ArrayList and will provide a method to add a song.
         * It will also provide findSong() methods which will be used by the containing Album class to add songs to the playlist.
         * Neither the Song class or the Main class should be changed.
         */

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Love Don't Mean a thing",4.22);
        album.addSong("Stormbringer",4.6);
        album.addSong("Hold on",5.6);
        album.addSong("The Gypsy",3.6);
        albums.add(album);

        album = new Album("Numb","Linkin Park");
        album.addSong("Castle of Glass",4.3);
        album.addSong("Numb",4.67);
        album.addSong("New Divide",5.6);

        albums.add(album);

        LinkedList<Song>playList = new LinkedList<Song>();

        albums.get(0).addToPlaylist("Stormbringer",playList);
        albums.get(0).addToPlaylist("Hold on",playList);
        albums.get(0).addToPlaylist(0,playList);
        albums.get(0).addToPlaylist(1,playList);
        albums.get(0).addToPlaylist(2,playList);
        albums.get(0).addToPlaylist(3,playList);

        albums.get(1).addToPlaylist(1,playList);
        albums.get(1).addToPlaylist(2,playList);
        albums.get(1).addToPlaylist(3,playList);


        play(playList);

    }

    private static void play(LinkedList<Song>playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in the Playlist");
        }
        else{
            System.out.println("Now Playing - "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0 :
                    System.out.println("Playlist Complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing "+listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing "+listIterator.previous().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = true;
                    }
                    break;
                case 3 :
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    }
                        else{
                            if(listIterator.hasNext()){
                            System.out.println("Now Replaying "+listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We are at the start of the playlist");
                        }
                        }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next());
                        }
                        else if(listIterator.hasPrevious()){
                            System.out.println("Now Playing "+listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available Actions : \n Press ");
        System.out.println("0. To Quit \n1. To Play the next Song.\n"+
                "2. To Play the Previous Song\n3.To replay the Current Song\n"+
                "4. To list the songs in the playlist\n5. To print the available actions."+
                "\n6.To Remove the current Song from the playlist");
    }

    private static void printList(LinkedList<Song>playlist){
        Iterator<Song>iterator = playlist.iterator();
        System.out.println("=================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============");
    }
}
