package sephiraandy;

import java.util.function.Predicate;

public class FantasyStories implements Behaviour<Application> {

    private int ticks = 0;
    private Agent<AdventurerState> adventurer;

    public static void main(String[] args) {
        final var fantasyStories = new FantasyStories();
        final var application = new Application(fantasyStories);
        new Thread(application::run).start();
    }

    // Adventurer
    //  - adventure
    //      - bags are full -> sell loot
    //      - tired -> rest in camp
    //  - rest in camp
    //      - fully recovered -> adventure
    //  - sell loot
    //      - bags are empty -> drink at inn
    //  - drink at inn
    //      - no more gold -> adventure

    @Override
    public void start(Application application) {
        adventurer = new Agent<>(new AdventurerState(System.out::println, "Alice"));
        final var adventure = new Adventure();
        final var restInCamp = new RestInCamp();
        adventurer.setBehaviour(adventure);
        final var tired = new Tired();
        adventurer.setTransition(new Agent.Transition<>(adventure, restInCamp, tired));
    }

    @Override
    public void conduct(Application application) {
        ++ticks;
        adventurer.update();
        if (ticks >= 100) {
            application.stop();
        }
    }

    @Override
    public void end(Application application) {
        System.out.println("Simulation ended");
    }
}
