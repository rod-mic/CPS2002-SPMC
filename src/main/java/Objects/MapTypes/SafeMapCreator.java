package Objects.MapTypes;

/**
 * Created by thoma on 12/05/2017.
 */
public class SafeMapCreator extends MapCreator{

    public SafeMapCreator(){}

    public MapInterface create(int size, int numOfPlayer){
        SafeMap sm = SafeMap.getInstance();
        sm.setMapSize(size);
        sm.setNumOfPlayers(numOfPlayer);
        sm.generate();
        return sm;
    }
}
