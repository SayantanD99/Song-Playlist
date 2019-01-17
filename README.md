# Song Playlist

A simple menu-driven Java Program, used to implement LinkedList in Java. Creating a Song Playlist and going through it.

#1 

        The main Job was to -

         * Create a program that implements a playlist for songs
         * Create a Song class having Title and Duration for a song.
         * The program will have an Album class containing a list of songs.
         * The albums will be stored in an ArrayList
         * Songs from different albums can be added to the playlist and will appear in the list in the order they are added.
         * Once the songs have been added to the playlist, create a menu of options to:-
         * Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
         * List the songs in the playlist
         * A song must exist in an album before it can be added to the playlist (so you can only play songs that you own).
         * Hint:  To replay a song, consider what happened when we went back and forth from a city before we started tracking the       
                  direction we were going.
         * As an optional extra, provide an option to remove the current song from the playlist
         * (hint: listiterator.remove()
         
#2

Few modifications are made since I created this repository. 

Few small changes have been made to the program code implementing inner classes.

        * The Modifications -
        
                * the Album class uses an inner class.
                * Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
                * The inner SongList class will use an ArrayList and will provide a method to add a song.
                * It will also provide findSong() methods which will be used by the containing Album class to add songs to the playlist.
                * Neither the Song class or the Main class should be changed.
         


Yes, this program still needs a lot of improvement. Hope you all will help. 

Feedbacks are highly appreciated.

Thank You !
    
