package sephiraandy;

import sephiraandy.adventurer.AdventurerState;

import java.util.function.Consumer;

class MockAdventurerState extends AdventurerState {
    public String location;
    public int loot;
    public int fatigue;

    public MockAdventurerState(Consumer<String> output, String name) {
        super(output, name, 10);
    }

    @Override
    public void setLocation(String nextLocation) {
        location = nextLocation;
    }

    @Override
    public void collectLoot() {
        ++loot;
    }

    @Override
    public void tire() {
        ++fatigue;
    }
}
