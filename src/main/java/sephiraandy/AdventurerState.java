package sephiraandy;

import java.util.function.Consumer;

public class AdventurerState {
    private final Consumer<String> output;
    private final String name;
    private int loot = 0;
    private int fatigue = 0;

    public AdventurerState(Consumer<String> output, String name) {
        this.output = output;
        this.name = name;
    }

    public void setLocation(String nextLocation) {
        output.accept(name + " is now at " + nextLocation + ".");
    }

    public void collectLoot() {
        ++loot;
        final var collective = loot == 1 ? "piece" : "pieces";
        output.accept(name + " collected some loot. Now they have " + loot + " " +  collective + " of loot.");
    }

    public void tire() {
        ++fatigue;
        output.accept(name + " gained fatigue. Their tiredness level is at " + fatigue + ".");
    }
}