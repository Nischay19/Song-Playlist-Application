package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
 
public class Main extends Album {

  //we made it as part of Main class,cause here only static can be added to arraylist
  private static ArrayList<Album> albums = new ArrayList<>();

  public static void main(String[] args) {
    
    //create object of album class;
    Album album = new Album("Album1","RadioHead");   //we also initialised a songs arraylist

    album.addSong("No Suprises",4.0);
    album.addSong("High and Dry",3.5);
    album.addSong("Reckoner",3.0);
    albums.add(album);

    album = new Album("Album2","50Cent");

    album.addSong("PIMP",3.6);
    album.addSong("In Da Club",3.5);
    album.addSong("Its yo Birthday",4.0);
    albums.add(album);
  
    //two album added to arraylist of album called -- albums

    //ll playlst which contain songs from these two album's
    LinkedList<Song> playlist_1 = new LinkedList<>();
    albums.get(0).addToPlaylist("No Suprises", playlist_1);              //yahape this is-albums.get(0);
    albums.get(1).addToPlaylist(2, playlist_1);        // add - IN Da Club
    albums.get(0).addToPlaylist("Reckoner", playlist_1);
    albums.get(1).addToPlaylist("PIMP", playlist_1);

    //play this album//
    play(playlist_1);
    
  }

  //plays the playlist  //user interaction
  private static void play(LinkedList<Song> playlist_1) {
    //we implement printMenu() amd printList() in this method

    //take input
    Scanner scn = new Scanner(System.in);
    boolean quit = false;  // will tell whether system has quit or not
    boolean forward = true;
    ListIterator<Song> listIterator = playlist_1.listIterator();   //methods - hasNext() - next() - hasPrevious() - previous() 

    /* There is no current element in ListIterator.
     Its cursor always lies between the previous and next elements. 
     The previous() will return to the previous elements and the next() will return to the next element. 
     Therefore, for a list of n length, there are n+1 possible cursors.

      // for-each loop creates Internal Iterator here.  // we could use this instead of listiterator
        for (String s : names) {
          System.out.println(s);
        }
    */

    if(playlist_1.size() == 0){
      System.out.println("this playlist has no songs");
    } else{
      //play the current song
      System.out.println("now playing " + listIterator.next().toString());  
      printMenu();
    }

    //now after print menu take input
    while(!quit){
      int action = scn.nextInt();
      scn.nextLine();             //breaking the line

        switch(action){
          case 0:
            System.out.println("PlayList complete");
            quit = true;
            break;
          case 1:
            if(!forward){  //wtf
              if(listIterator.hasNext()){      //checks next song if exist or not
                listIterator.next();          //advances to the next song
              }
              forward = true;
            }
            if(listIterator.hasNext()){
              System.out.println("Now Playing " + listIterator.next().toString());
            } else{
              System.out.println("No song available, reached to the end of the string");
              forward = false;
            }
            break;
          case 2:
            if(forward){                      //checks agar ham first song pe toh nhi hai..
              if(listIterator.hasPrevious()){
                listIterator.previous();
              }
              forward = false;
            }
            if(listIterator.hasPrevious()){
              System.out.println("Now PLaying " + listIterator.previous().toString());
            } else {
              System.out.println("We are at the first song");
              forward = false;
            }
            break;
          case 3:
            if(forward){   //checks agar next element hai ya nhi
              if(listIterator.hasPrevious()){
                System.out.println("Now playing " +listIterator.previous().toString());
                forward = false;
              }else{
                System.out.println("we are at the start of the list");
              }
            } else {
              if(listIterator.hasNext()){
                  System.out.println("now playing "+listIterator.next().toString());
                  forward = true;
              }else {
                  System.out.println("we have reached to the end of list");
              }
            }
            break;
          case 4:
              printList(playlist_1);
              break;
          case 5:
              printMenu();
              break;
          case 6:
              if(playlist_1.size() >0){
                listIterator.remove();  // will deletethe song on whicb the song we are one
                if(listIterator.hasNext()){
                    System.out.println("Now playing " + listIterator.next().toString());
                } else {
                  if(listIterator.hasPrevious()){
                    System.out.println("Now Playing " + listIterator.previous().toString());
                  }
                }
              }
        }
    
    }
  }

  private static void printMenu(){
    System.out.println("Available Options\n press");
    System.out.println("0 - to quit\n" + 
                "1- to play next song\n" +
                "2 - to play previous song\n" + 
                "3 - replay the current song\n " +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song" );
  }

  private static void printList(LinkedList<Song> playlList){
    //creaet a iterator
    Iterator<Song> iterator = playlList.iterator();
    System.out.println("-----------");

    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
    System.out.println("------------");
  }


}
