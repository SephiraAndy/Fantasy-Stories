package sephiraandy;

import sephiraandy.adventurer.Adventurer;
import sephiraandy.adventurer.AdventurerState;

public class FantasyStories implements Behaviour<Application> {

    private int ticks = 0;
    private Agent<Adventurer> adventurer;

    public static void main(String[] args) {
        final var fantasyStories = new FantasyStories();
        final var application = new Application(fantasyStories);
        new Thread(application::run).start();
    }

    @Override
    public void start(Application application) {
        final var adventurerBehaviours = new Adventurer.Conductor();

        adventurer = new Agent<>(
                new AdventurerState(
                        System.out::println,
                        "Alice",
                        10),
                adventurerBehaviours,
                adventurerBehaviours.startBehaviour());
    }

    @Override
    public void conduct(Application application) {
        ++ticks;
        adventurer.update();
        if (ticks >= 1) {
            application.stop();
        }
    }

    @Override
    public void end(Application application) {
        System.out.println("Simulation ended");
    }
}
