import org.cmc.music.metadata.*;
import org.cmc.music.myid3.*; 
import org.cmc.music.common.*;
import java.io.*;

public class Test{
	public static void main(String ar[]) 
	{
		try{
		File src = new File("C:\\Documents and Settings\\bappa.sarkar.GEGDC\\Desktop\\mp3\\MP3MetaData\\Harano Padak.mp3");

		MyID3 m = new MyID3();

		MusicMetadataSet src_set = m.read(src); // read metadata


		IMusicMetadata metadata = src_set.getSimplified();
		String artist = metadata.getArtist();  
		String album = metadata.getAlbum();  
		String song_title = metadata.getSongTitle(); 
		Number year = metadata.getYear(); 
		
		System.out.println("Artist : "+artist);	
		System.out.println("Album : "+album);	
		System.out.println("Song Title : "+song_title);	
		System.out.println("year : "+year);	
		}
		catch(IOException i)
		{
			System.out.println("IO err......");
		}
		catch(ID3ReadException ide)
		{
			System.out.println("MetaDate Read Err..");
		}
	}
}
