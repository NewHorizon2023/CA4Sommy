import old.ReadAlbumData;

import java.util.Arrays;

public class Experiment {
    public static void main(String[] args) throws Exception {
        Album[] albums = ReadData.readAllData();

        Album[] albums1 = Arrays.copyOf(albums, 10);
        Album[] albums2 = Arrays.copyOf(albums, 100);
        Album[] albums3 = Arrays.copyOf(albums, 1000);
        Album[] albums4 = Arrays.copyOf(albums, 5000);
        Album[] albums5 = Arrays.copyOf(albums, 10000);


    }
}
