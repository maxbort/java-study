package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song = new Song("좋은날", "Real", "이민수", "아이유","2010",3);
		
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setTrack(3);
//		song.setYear("2010");
		
		Song song01 = new Song("Ditto", "New Jeans");
		song01.show();
		song.show();

	}

}
