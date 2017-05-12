package Objects;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by thoma on 12/05/2017.
 */
public class SafeMap extends Map{
    private static SafeMap ourInstance = new SafeMap();

    public static SafeMap getInstance() {
        return ourInstance;
    }

    private SafeMap() {
        generate();
    }

    public boolean generate(){
        //Setting Treasure Tile
        int xrand = ThreadLocalRandom.current().nextInt(0, size);
        int yrand = ThreadLocalRandom.current().nextInt(0, size);
        map[xrand][yrand] = 'T';
        treasurePos = new Position(xrand, yrand);

        //Setting Grass Tiles
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] != 'T') map[i][j] = 'G';
            }
        }

        //Setting Water Tiles
        int minWaterTiles = (size * size * 0)/100;
        int maxWaterTiles = (size * size * 10)/100;
        int currentWaterTiles = 0;
        for(int i = 0; i < maxWaterTiles; i++){
            if(currentWaterTiles < minWaterTiles) {
                do{
                    xrand = ThreadLocalRandom.current().nextInt(0, size);
                    yrand = ThreadLocalRandom.current().nextInt(0, size);
                }while(map[xrand][yrand] != 'G');
                map[xrand][yrand] = 'W';
                currentWaterTiles++;
            }
            else{
                int randomValue = ThreadLocalRandom.current().nextInt(0,2);
                if(randomValue == 1){
                    do{
                        xrand = ThreadLocalRandom.current().nextInt(0, size);
                        yrand = ThreadLocalRandom.current().nextInt(0, size);
                    } while(map[xrand][yrand] != 'G');
                    map[xrand][yrand] = 'W';
                }
            }
        }


        return true;
    }
}
