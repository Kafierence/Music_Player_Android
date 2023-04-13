package hcmute.edu.vn.music_player;

import java.io.Serializable;

public class Song implements Serializable {
    private String tile;
    private String single;
    private int image;
    private int resource;

    public Song(String tile, String single, int image, int resource) {
        this.tile = tile;
        this.single = single;
        this.image = image;
        this.resource = resource;
    }

    public String getTile() {
        return tile;
    }

    public String getSingle() {
        return single;
    }

    public int getImage() {
        return image;
    }

    public int getResource() {
        return resource;
    }
}
