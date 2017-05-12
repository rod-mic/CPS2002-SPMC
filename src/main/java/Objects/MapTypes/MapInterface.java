package Objects.MapTypes;

import Objects.Position;

/**
 * Created by thoma on 12/05/2017.
 */
public interface MapInterface {
    boolean generate();
    int getMapSize();
    Position getTreasurePos();
    char getTileType(Position position);
    boolean initMap(int size);
    char[][] getMap();
    boolean checkAnyPaths(int player);
    boolean checkPath(Position position);

}
