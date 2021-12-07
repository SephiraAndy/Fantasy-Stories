package sephiraandy;

public class FantasyStories implements Behaviour<Application> {

    public static void main(String[] args) {
        final var fantasyStories = new FantasyStories();
        final var application = new Application(fantasyStories);
        new Thread(application::run).start();
    }

    @Override
    public void start(Application application) {
        System.out.println("simulation started");
    }

    @Override
    public void conduct(Application application) {
        System.out.println("Simulation step");
        application.stop();
    }

    @Override
    public void end(Application application) {
        System.out.println("Simulation ended");
    }
}
