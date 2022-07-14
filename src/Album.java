package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album extends Song{
  private String name;
  private String artist;
  private ArrayList<Song> songs;

  public Album(String name,String artist){
                    //why did we not add ArrayList<Song> in the parameters of this constructor
    this.name = name;
    this.artist = artist;
    this.songs = new ArrayList<Song>();         //this will be made without the parameter.
  }

  public Album(){

  }

  //fnctionality to add songs in the album, returns true if song successfully added
  public boolean addSong(String title,double duration){
    if(findSong(title) == null){
      //song not present
      songs.add(new Song(title,duration));
      // System.out.println(title + "successfully added to the list");
      return true;
    } else{
      // System.out.println("Song with title " + title + "already exist");
      return false;
    }
  }

  public Song findSong(String title) {
    for(Song checksog : songs){
      if(checksog.getTitle().equals(title)){
        return checksog;
      }
      return null;
    }
    return null;
  }

  //two functions - same name - different param

  public boolean addToPlaylist(int trackNumnber, LinkedList<Song> Playlist){
    //convert tracknumber to index
    //index starts from 0 but track starts from 1

    //tracknumber of the album...
    int index = trackNumnber - 1;
    if(index > 0 && index <=this.songs.size()){            //this cause we are in the album class aur uski class ko acces karna ha
      Playlist.add(this.songs.get(index));               //this.songs - gives access to the arraylist
      return true;
    }
    // System.out.println("This album does not have song with track number " + trackNumnber);
    return false;
  }


  //takes title of the song and adds to the playlist
  public boolean addToPlaylist(String title,LinkedList<Song> PlayList){
    for(Song checkedsong : this.songs){
      if(title.equals(checkedsong.getTitle()) == true){
        PlayList.add(checkedsong);
        return true;
      }
    }

    // System.out.println(title + " there is no such song in album");
    return false;
  }

  
}
