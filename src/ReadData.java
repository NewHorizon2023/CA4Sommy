import java.io.File;
import java.util.Scanner;

public class ReadData {
    public static Album[] readAllData() throws Exception {
        File directory = new File("");
        String name = directory.getAbsolutePath() + "/src/album.csv";
        System.out.println("directory = " + name);
        Scanner sc = new Scanner(new File(name));
        Album[] albums = new Album[10000];
        sc.nextLine();
        int i = 0;
        String st = "";

        while (sc.hasNextLine()) {
            st = sc.nextLine();
            String[] data = st.split(",");
            albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
                    Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));
        }
        sc.close();

        return albums;
    }

    public static void main(String[] args) throws Exception {
        Album[] albums = readAllData();
        System.out.println(albums.length);
    }
}
