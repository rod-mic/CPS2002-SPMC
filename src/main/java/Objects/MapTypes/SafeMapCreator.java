package Objects.MapTypes;

import Exceptions.PlayerException;
import Exceptions.SizeException;

/**
 * Created by thoma on 12/05/2017.
 */
public class SafeMapCreator extends MapCreator{

    public SafeMapCreator(){}

    public MapInterface create(int size, int numOfPlayer){
        SafeMap sm = SafeMap.getInstance();
        try{
            sm.setMapProps(size, numOfPlayer);
        }catch(PlayerException pe){
            System.out.println(pe.errorMessage);
            System.exit(0);
        }catch(SizeException se){
            System.out.println(se.getMessage());
            System.exit(0);
        }
        sm.generate();
        return sm;
    }
}
