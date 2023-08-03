import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static Album[] binarySearch(Album[] albums, float loudness) {
        ArrayList<Album> result = new ArrayList<>();

        int left = 0;
        int right = albums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (albums[mid].getLoudness() == loudness) {
                result.add(albums[mid]);
                int leftIndex = mid - 1;
                int rightIndex = mid + 1;

                // Check left side for additional matches
                while (leftIndex >= 0 && albums[leftIndex].getLoudness() == loudness) {
                    result.add(albums[leftIndex]);
                    leftIndex--;
                }

                // Check right side for additional matches
                while (rightIndex < albums.length && albums[rightIndex].getLoudness() == loudness) {
                    result.add(albums[rightIndex]);
                    rightIndex++;
                }

                break;
            } else if (albums[mid].getLoudness() < loudness) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result.toArray(new Album[result.size()]);
    }

    public static void main(String[] args) throws Exception {
        Album[] albums = ReadData.readAllData();
        Sort.quickSort(albums, 0, albums.length - 1);
        Album[] arr = binarySearch(albums, 0.88f);
        System.out.println(Arrays.toString(arr));
    }
}
