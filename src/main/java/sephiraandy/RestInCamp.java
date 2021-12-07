package sephiraandy;

public class RestInCamp implements Behaviour<AdventurerState> {
    @Override
    public void start(AdventurerState adventurerState) {
        adventurerState.setUpCamp();
    }

    @Override
    public void conduct(AdventurerState adventurerState) {

    }

    @Override
    public void end(AdventurerState adventurerState) {

    }
}
