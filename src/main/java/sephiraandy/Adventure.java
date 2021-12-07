package sephiraandy;

public class Adventure implements Behaviour<AdventurerState> {
    @Override
    public void start(AdventurerState adventurerState) {
        adventurerState.setLocation("The Goblin Cave");
    }

    @Override
    public void conduct(AdventurerState adventurerState) {
        adventurerState.collectLoot();
    }

    @Override
    public void end(AdventurerState adventurerState) {

    }
}
