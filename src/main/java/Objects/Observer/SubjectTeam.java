package Objects.Observer;

import java.util.ArrayList;

/**
 * Created by rodemic on 11/05/2017.
 */
class SubjectTeam {
    private ArrayList<PlayerObserver> players = new ArrayList<>();

    public void Attach(Player p){
        players.add(p);
    }

    public void Detach(Player p){
        players.remove(p);
    }

    public void Notify(){
        for(PlayerObserver p:players){
            p.Update();
        }
    }
}
