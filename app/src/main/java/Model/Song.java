package Model;

public class Song {
    private int imageResId;
    private String title;
    private String artist;
    private int audioResId;

    public Song(int imageResId, String title, String artist, int audioResId) {
        this.imageResId = imageResId;
        this.title = title;
        this.artist = artist;
        this.audioResId = audioResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getAudioResId() {
        return audioResId;
    }
}
