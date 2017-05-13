package Objects.MapTypes;

import Exceptions.*;

/**
 * Created by thoma on 12/05/2017.
 */

public class HazardousMapCreator extends MapCreator {

    public HazardousMapCreator(){}

    public MapInterface create(int size, int numOfPlayer){
        HazardousMap hm = HazardousMap.getInstance();
        try{
            hm.setMapProps(size, numOfPlayer);
        }catch(PlayerException pe){
            System.out.println(pe.errorMessage);
            System.exit(0);
        }catch(SizeException se){
            System.out.println(se.getMessage());
            System.exit(0);
        }
        hm.generate();
        return hm;
    }
}
