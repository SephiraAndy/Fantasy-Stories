package sephiraandy;

public class FantasyStories implements Behaviour<Application> {

    private int ticks = 0;

    public static void main(String[] args) {
        final var fantasyStories = new FantasyStories();
        final var application = new Application(fantasyStories);
        new Thread(application::run).start();
    }

    @Override
    public void start(Application application) {
        System.out.println("simulation started");

    }

    // Adventurer
    //  - adventure
    //      - bags full -> sell loot
    //      - tired -> rest in camp
    //  - rest in camp
    //      - fully recovered -> adventure
    //  - sell loot
    //      - bags are empty -> drink at inn
    //  - drink at inn
    //      - no more gold -> adventure


    @Override
    public void conduct(Application application) {
        System.out.println("Simulation step");
        ++ticks;
        if (ticks >= 100) {
            application.stop();
        }
    }

    @Override
    public void end(Application application) {
        System.out.println("Simulation ended");
    }
}
