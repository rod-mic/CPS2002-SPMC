package Objects;

/**
 * Created by thoma on 12/05/2017.
 */
public class SafeMapCreator extends MapCreator{

    public SafeMapCreator(){}

    public MapInterface create(){
        return SafeMap.getInstance();
    }
}
