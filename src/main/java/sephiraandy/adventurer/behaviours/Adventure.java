package sephiraandy.adventurer.behaviours;

import sephiraandy.Behaviour;
import sephiraandy.adventurer.Adventurer;

public class Adventure implements Behaviour<Adventurer> {
    @Override
    public void start(Adventurer adventurerState) {
        adventurerState.setLocation("The Goblin Cave");
    }

    @Override
    public void conduct(Adventurer adventurerState) {
        adventurerState.collectLoot();
        adventurerState.tire();
    }

    @Override
    public void end(Adventurer adventurerState) {
    }
}
