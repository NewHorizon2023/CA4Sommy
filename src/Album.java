public class Album implements Comparable<Album> {

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
        if (loudness != other.getLoudness()) {
            return Float.compare(loudness, other.getLoudness());
        }
        return Integer.compare(albumID, other.getAlbumID());
    }

    @Override
    public String toString() {
        return "Album [albumID= " + albumID + ", artist= " + artist + ", speech = "
                + speech + ", popular = " + popular + ", loudness = "
                + loudness + ", duration = " + duration + "]";
    }
}
