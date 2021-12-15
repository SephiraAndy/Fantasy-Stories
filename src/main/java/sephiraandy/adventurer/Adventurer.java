package sephiraandy.adventurer;

import sephiraandy.Behaviour;
import sephiraandy.BehaviourConductor;
import sephiraandy.Transition;

import java.util.function.Predicate;

public interface Adventurer {
    void setLocation(String location);
    void collectLoot();
    void tire();
    void setUpCamp();
    void rest();
    void packUpCamp();
    void sellLoot();
    void buyAle();
    void drinkAle();
    boolean isTired();
    boolean bagsAreFull();
    boolean isFullyRested();
    boolean bagsAreEmpty();
    boolean hasNoMoreGold();

    class Conductor extends BehaviourConductor<Adventurer> {
        public Conductor() {

            final var start = new Behaviour<Adventurer>() {
                @Override
                public void start(Adventurer adventurer) { }
                @Override
                public void conduct(Adventurer adventurer) { }
                @Override
                public void end(Adventurer adventurer) { }
            };

            setStartBehaviour(start);

            final var adventure = new Behaviour<Adventurer>() {
                @Override
                public void start(Adventurer adventurer) {
                    adventurer.setLocation("The Goblin Cave");
                }

                @Override
                public void conduct(Adventurer adventurer) {
                    adventurer.collectLoot();
                    adventurer.tire();
                }

                @Override
                public void end(Adventurer adventurer) {

                }
            };

            final var restInCamp = new Behaviour<Adventurer>() {
                @Override
                public void start(Adventurer adventurer) {
                    adventurer.setUpCamp();
                }

                @Override
                public void conduct(Adventurer adventurer) {
                    adventurer.rest();
                }

                @Override
                public void end(Adventurer adventurer) {
                    adventurer.packUpCamp();
                }
            };

            final var sellLoot = new Behaviour<Adventurer>() {
                @Override
                public void start(Adventurer adventurer) {
                    adventurer.setLocation("Pawn Aplenty");
                }

                @Override
                public void conduct(Adventurer adventurer) {
                    adventurer.sellLoot();
                }

                @Override
                public void end(Adventurer adventurer) {

                }
            };

            final var drinkAtInn = new Behaviour<Adventurer>() {
                @Override
                public void start(Adventurer adventurer) {
                    adventurer.setLocation("The Golden Goblin");
                }

                @Override
                public void conduct(Adventurer adventurer) {
                    adventurer.buyAle();
                    adventurer.drinkAle();
                }

                @Override
                public void end(Adventurer adventurer) {

                }
            };

            final var isTired = new Predicate<Adventurer>() {
                @Override
                public boolean test(Adventurer adventurer) {
                    return adventurer.isTired();
                }
            };

            final var isFullyRested = new Predicate<Adventurer>() {
                @Override
                public boolean test(Adventurer adventurer) {
                    return adventurer.isFullyRested();
                }
            };

            final var bagsAreFull = new Predicate<Adventurer>() {
                @Override
                public boolean test(Adventurer adventurer) {
                    return adventurer.bagsAreFull();
                }
            };

            final var bagsAreEmpty = new Predicate<Adventurer>() {
                @Override
                public boolean test(Adventurer adventurer) {
                    return adventurer.bagsAreEmpty();
                }
            };

            final var hasNoMoreGold = new Predicate<Adventurer>() {
                @Override
                public boolean test(Adventurer adventurer) {
                    return adventurer.hasNoMoreGold();
                }
            };

            setTransition(new Transition<>(start, adventure, adventurer -> true));
            setTransition(new Transition<>(adventure, restInCamp, isTired));
            setTransition(new Transition<>(restInCamp, adventure, isFullyRested));
            setTransition(new Transition<>(adventure, sellLoot, bagsAreFull));
            setTransition(new Transition<>(sellLoot, drinkAtInn, bagsAreEmpty));
            setTransition(new Transition<>(drinkAtInn, adventure, hasNoMoreGold));
        }
    }

}


