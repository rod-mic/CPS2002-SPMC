package Objects;

/**
 * Created by thoma on 12/05/2017.
 */
public class HazardousMapCreator extends MapCreator {

    public HazardousMapCreator(){}

    public MapInterface create(){
        return HazardousMap.getInstance();
    }

}
