package Objects.MapTypes;

/**
 * Created by thoma on 12/05/2017.
 */
public class MapCreator {

    public MapInterface createMap(int mapSize, int numOfPlayers, int choice){
        if(choice == 1){
            SafeMapCreator creator = new SafeMapCreator();
            return creator.create(mapSize, numOfPlayers);
        }
        else{
            HazardousMapCreator creator2 = new HazardousMapCreator();
            return creator2.create(mapSize, numOfPlayers);
        }
    }

    public MapInterface createMap(int mapSize, int numOfPlayers){
        return createMap(mapSize, numOfPlayers,1);
    }
}
