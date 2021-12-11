package sephiraandy;

import org.junit.jupiter.api.Test;
import sephiraandy.adventurer.behaviours.SellLoot;

class SellLootTest {

    @Test
    void shouldFoo() {
        final var mockAdventurerState = new MockAdventurerState(null, null);

        final var sellLoot = new SellLoot();

        sellLoot.start(mockAdventurerState);


    }

}