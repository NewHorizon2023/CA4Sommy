import java.util.Arrays;

public class Experiment {
    public static void main(String[] args) throws Exception {
        Album[] albums = ReadData.readAllData();

        Album[] albums1 = Arrays.copyOf(albums, 10);
        Album[] albums2 = Arrays.copyOf(albums, 100);
        Album[] albums3 = Arrays.copyOf(albums, 1000);
        Album[] albums4 = Arrays.copyOf(albums, 5000);
        Album[] albums5 = Arrays.copyOf(albums, 10000);

        long start1 = System.nanoTime();
        Sort.bubbleSort(albums1, albums1.length);
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);

        long start2 = System.nanoTime();
        Sort.bubbleSort(albums2, albums2.length);
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);

        long start3 = System.nanoTime();
        Sort.bubbleSort(albums3, albums3.length);
        long end3 = System.nanoTime();
        System.out.println(end3 - start3);

        long start4 = System.nanoTime();
        Sort.bubbleSort(albums4, albums4.length);
        long end4 = System.nanoTime();
        System.out.println(end4 - start4);

        long start5 = System.nanoTime();
        Sort.bubbleSort(albums5, albums5.length);
        long end5 = System.nanoTime();
        System.out.println(end5 - start5);

    }
}
