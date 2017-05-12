package Objects.MapTypes;

/**
 * Created by thoma on 12/05/2017.
 */
public class HazardousMapCreator extends MapCreator {

    public HazardousMapCreator(){}

    public MapInterface create(int size, int numOfPlayer){
        HazardousMap hm = HazardousMap.getInstance();
        hm.setMapSize(size);
        hm.setNumOfPlayers(numOfPlayer);
        hm.generate();
        return hm;
    }

}
