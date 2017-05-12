package Objects.MapTypes;

/**
 * Created by thoma on 12/05/2017.
 */
public class MapCreator {

    public MapInterface createMap(int mapSize, int numOfPlayers, int choice){
        switch(choice){
            case 1: SafeMapCreator creator = new SafeMapCreator();
                    return creator.create(mapSize, numOfPlayers);
            case 2: HazardousMapCreator creator2 = new HazardousMapCreator();
                    return creator2.create(mapSize, numOfPlayers);
        }
        return null;
    }

    public MapInterface createMap(int mapSize, int numOfPlayers){
        return createMap(mapSize, numOfPlayers,1);
    }
}
