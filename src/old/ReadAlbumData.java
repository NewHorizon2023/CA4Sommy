package old;

import java.io.File;
import java.util.*;

public class ReadAlbumData {

    public static class Album implements Comparable<Album> {

        private int albumID;
        private String artist;
        private int popular;
        private float loudness;
        private float speech;
        private float duration;

        public Album(int albumID, String artist, int popular, float loudness, float speech, float duration) {
            super();
            this.albumID = albumID;
            this.artist = artist;
            this.popular = popular;
            this.loudness = loudness;
            this.speech = speech;
            this.duration = duration;
        }

        public int getAlbumID() {
            return albumID;
        }

        public void setAlbumID(int albumID) {
            this.albumID = albumID;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public int getPopular() {
            return popular;
        }

        public void setPopular(int popular) {
            this.popular = popular;
        }

        public float getLoudness() {
            return loudness;
        }

        public void setLoudness(float loudness) {
            this.loudness = loudness;
        }

        public float getSpeech() {
            return speech;
        }

        public void setSpeech(float speech) {
            this.speech = speech;
        }

        public float getDuration() {
            return duration;
        }

        public void setDuration(float duration) {
            this.duration = duration;
        }

        @Override
        public int compareTo(Album other) {
			if(loudness!= other.getLoudness()){
				return Float.compare(loudness, other.getLoudness());
			}
            return Integer.compare(albumID, other.getAlbumID());
        }

        @Override
        public String toString() {
            return "newPackage.Album [albumID= " + albumID + ", artist= " + artist + ", speech = "
                    + speech + ", popular = " + popular + ", loudness = "
                    + loudness + ", duration = " + duration + "]";
        }
    }

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

    public static int partition(Album[] albums, int low, int high) {
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

    public static void quickSort(Album[] albums, int low, int high) {
        if (low < high) {
            int pi = partition(albums, low, high);

            quickSort(albums, low, pi - 1);
            quickSort(albums, pi + 1, high);
        }
    }

    public static Album[] binarySearch(Album[] albums, float loudness) {
        ArrayList<Album> result = new ArrayList<>();

        int left = 0;
        int right = albums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

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
    

    public static Album[] addNewAlbumRecord(Album[] albums, String artist, int popular, float loudness, float speech, float duration) throws EmptyOrDigitsOnlyException {
    	if(artist==null||artist.isEmpty()||artist.matches("\\d+")) {
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
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//album.csv";
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

        System.out.println("Unsorted Albums:");
        for (int k = 0; k < i; k++) {
            System.out.println(albums[k]);
        }

        Album[] albums1 = albums.clone();
        bubbleSort(albums1, i);

        System.out.println("\nSorted Albums Based on Popularity (Bubble Sort):");
        for (int k = 0; k < i; k++) {
            System.out.println(albums1[k]);
        }

        Album[] albums2 = albums.clone();
        quickSort(albums2, 0, i - 1);

        System.out.println("\nSorted Albums Based on Popularity (Quick Sort):");
        for (int k = 0; k < i; k++) {
            System.out.println(albums2[k]);
        }

        int[] recordCounts = {10, 100, 1000, 5000, 10000};
        for (int count : recordCounts) {
            long totalQuickSortTime = 0;
            long totalBubbleSortTime = 0;
            int numIterations = 10; // Number of iterations for each record count

            for (int iter = 0; iter < numIterations; iter++) {
                sc = new Scanner(new File(name));
                albums = new Album[count];
                sc.nextLine();
                i = 0;
                st = "";

                while (sc.hasNextLine() && i < count) {
                    st = sc.nextLine();
                    String[] data = st.split(",");
                    albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
                            Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));
                }
                sc.close();

                long quickSortStart = System.nanoTime();
                quickSort(albums, 0, i - 1);
                long quickSortEnd = System.nanoTime();
                totalQuickSortTime += quickSortEnd - quickSortStart;

                sc = new Scanner(new File(name));
                albums = new Album[count];
                sc.nextLine();
                i = 0;
                st = "";

                while (sc.hasNextLine() && i < count) {
                    st = sc.nextLine();
                    String[] data = st.split(",");
                    albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
                            Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));
                }
                sc.close();

                long bubbleSortStart = System.nanoTime();
                bubbleSort(albums, i);
                long bubbleSortEnd = System.nanoTime();
                totalBubbleSortTime += bubbleSortEnd - bubbleSortStart;
            }

            double avgQuickSortTime = totalQuickSortTime / (numIterations * 1e3); // Convert to microseconds
            double avgBubbleSortTime = totalBubbleSortTime / (numIterations * 1e3); // Convert to microseconds

            System.out.println("\nRecords: " + count);
            System.out.println("Average Quick Sort Time: " + avgQuickSortTime + " microseconds");
            System.out.println("Average Bubble Sort Time: " + avgBubbleSortTime + " microseconds\n");
            
       
            // Test for my binary search
//            newPackage.Album[] arr = binarySearch(albums1, 0.88f);
//            System.out.println(Arrays.toString(arr));
            
//            newPackage.Album[] arr1 = addNewAlbumRecord(albums1, "", 2, 0.11f, 1.11f, 2.11f);
            Album[] arr1 = addNewAlbumRecord(albums1, "qer", 2, 0.11f, 1.11f, 2.11f);
           
            
            
        }
    }
}
