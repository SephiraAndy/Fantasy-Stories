package sephiraandy;

public class Application {

    private final Behaviour<Application> behaviour;
    private boolean simulating;

    public Application(Behaviour<Application> behaviour) {
        this.behaviour = behaviour;
    }

    public void run() {
        behaviour.start(this);
        play();
        behaviour.end(this);
    }

    private void play() {
        start();
        try {
            while (isSimulating()) {
                behaviour.conduct(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            stop();
        }
    }

    private boolean isSimulating() {
        return simulating;
    }

    private void start() {
        simulating = true;
    }

    public void stop() {
        simulating = false;
    }
}
