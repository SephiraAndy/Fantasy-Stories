package sephiraandy;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest {
    @Test
    void shouldConductBehaviour() {
        final var agentState = new State();
        final var behaviour = new LoggingBehaviour("");
        final var conductor = new BehaviourConductor<State>();
        final var agent = new Agent<>(agentState, conductor, behaviour);

        agent.update();

        assertEquals("start conduct ", agentState.log);
    }

    private static class State {
        private String log = "";

        public void log(String log) {
            this.log += log;
        }
    }

    private static class LoggingBehaviour implements Behaviour<State> {
        private final String name;

        public LoggingBehaviour(String name) {
            this.name = name;
        }

        @Override
        public void start(State state) {
            state.log("start" + name + " ");
        }

        @Override
        public void conduct(State state) {
            state.log("conduct" + name + " ");
        }

        @Override
        public void end(State state) {
            state.log("end" + name + " ");
        }
    }
}
