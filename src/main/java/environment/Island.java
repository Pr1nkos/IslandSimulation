package environment;

import lombok.Data;

@Data
public class Island {
    private int width;
    private int height;
    private Location[][] locations;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        initializeLocations();
    }

    private void initializeLocations() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return locations[x][y];
        } else {
            throw new IllegalArgumentException("Invalid coordinates");
        }
    }

}


