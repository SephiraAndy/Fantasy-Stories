package sephiraandy.adventurer;

import java.util.function.Consumer;

public class AdventurerState implements Adventurer {
    private final Consumer<String> output;
    private final String name;
    private final int bagCapacity;
    private int loot = 0;
    private int fatigue = 0;
    private String location;
    private int gold;

    public AdventurerState(Consumer<String> output, String name, int bagCapacity) {
        this.output = output;
        this.name = name;
        this.bagCapacity = bagCapacity;
    }

    public void setLocation(String nextLocation) {
        location = nextLocation;
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

    public boolean isTired() {
        return fatigue >= 7;
    }

    public void setUpCamp() {
        output.accept(name + " is setting up camp.");
    }

    public void rest() {
        fatigue = Math.max(0, fatigue - 2);
        output.accept(name + " is resting.");
    }

    public void packUpCamp() {
        output.accept(name + " is packing up their camp.");
    }

    @Override
    public void sellLoot() {
        final var exchange = loot;
        output.accept(name + " is selling " + loot + " loot at " + location + " for " + exchange + "gp.");
        gold += exchange;
        loot = 0;
    }

    @Override
    public void buyAle() {
        output.accept(name + " is buying ale at " + location + ".");
        --gold;
    }

    @Override
    public void drinkAle() {
        output.accept(name + " is drinking ale.");
    }

    @Override
    public boolean bagsAreEmpty() {
        return loot == 0;
    }

    @Override
    public boolean hasNoMoreGold() {
        return gold == 0;
    }

    public boolean isFullyRested() {
        return fatigue == 0;
    }

    public boolean bagsAreFull() {
        return loot == bagCapacity;
    }
}
