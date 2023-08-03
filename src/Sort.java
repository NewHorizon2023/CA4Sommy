public class Sort {
    public static void bubbleSort(Album[] albums, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (albums[j].compareTo(albums[j + 1]) > 0) {
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Album[] albums, int low, int high) {
        if (low < high) {
            int pi = partition(albums, low, high);

            quickSort(albums, low, pi - 1);
            quickSort(albums, pi + 1, high);
        }
    }

    private static int partition(Album[] albums, int low, int high) {
        Album pivot = albums[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (albums[j].compareTo(pivot) < 0) {
                i++;

                Album temp = albums[i];
                albums[i] = albums[j];
                albums[j] = temp;
            }
        }

        Album temp = albums[i + 1];
        albums[i + 1] = albums[high];
        albums[high] = temp;

        return i + 1;
    }
}
