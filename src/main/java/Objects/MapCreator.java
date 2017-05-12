package Objects;

/**
 * Created by thoma on 12/05/2017.
 */
public class MapCreator {

    public MapInterface createMap(int choice){
        switch(choice){
            case 1: SafeMapCreator creator = new SafeMapCreator();
                    return creator.create();
            case 2: HazardousMapCreator creator2 = new HazardousMapCreator();
                    return creator2.create();
        }
        return null;
    }

    public MapInterface createMap(){
        return createMap(1);
    }
}
