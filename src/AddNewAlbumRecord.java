import java.util.Arrays;

public class AddNewAlbumRecord {

    public static Album[] addNewAlbumRecord(Album[] albums, String artist, int popular, float loudness, float speech, float duration) throws EmptyOrDigitsOnlyException {
        if (artist == null || artist.isEmpty() || artist.matches("\\d+")) {
            throw new EmptyOrDigitsOnlyException("artist");
        }

        int ID = albums.length;
        Album newAlbum = new Album(ID, artist, popular, loudness, speech, duration);
        Album[] newAlbums = Arrays.copyOf(albums, albums.length + 1);
        newAlbum.setAlbumID(albums.length + 1); // Set new consecutive ID
        newAlbums[albums.length] = newAlbum;
        return newAlbums;
    }

    public static void main(String[] args) throws Exception {
        Album[] albums = ReadData.readAllData();
        Album[] arr = addNewAlbumRecord(albums, "a", 2, 0.11f, 1.11f, 2.11f);
        System.out.println(arr.length);
    }
}
