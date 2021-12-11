package sephiraandy.adventurer;

public interface Adventurer {
    boolean isTired();

    boolean areBagsFull();

    boolean isFullyRested();

    void setLocation(String location);

    void collectLoot();

    void tire();

    void setUpCamp();

    void rest();

    void packUpCamp();
}
