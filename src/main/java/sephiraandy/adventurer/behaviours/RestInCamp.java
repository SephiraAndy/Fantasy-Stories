package sephiraandy.adventurer.behaviours;

import sephiraandy.adventurer.Adventurer;
import sephiraandy.adventurer.AdventurerState;
import sephiraandy.Behaviour;

public class RestInCamp implements Behaviour<Adventurer> {
    @Override
    public void start(Adventurer adventurerState) {
        adventurerState.setUpCamp();
    }

    @Override
    public void conduct(Adventurer adventurerState) {
        adventurerState.rest();
    }

    @Override
    public void end(Adventurer adventurerState) {
        adventurerState.packUpCamp();
    }
}
