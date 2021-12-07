package sephiraandy;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest {
    @Test
    void shouldConductBehaviour() {
        final var agentState = new State();
        final var behaviour = new LoggingBehaviour("");
        final var agent = new Agent<>(agentState);
        agent.setBehaviour(behaviour);

        agent.update();

        assertEquals("start conduct ", agentState.log);
    }

    @Test
    void shouldSwapBehaviours() {
        final var agentState = new State();
        final var agent = new Agent<>(agentState);
        final var a = new LoggingBehaviour("A");
        final var b = new LoggingBehaviour("B");

        agent.setBehaviour(a);
        agent.update();
        agent.setBehaviour(b);
        agent.update();

        assertEquals("startA conductA endA startB conductB ", agentState.log);
    }

    @Test
    void shouldTransitionBetweenStates() {
        final var agentState = new State();
        final var agent = new Agent<>(agentState);
        final var a = new LoggingBehaviour("A");
        final var b = new LoggingBehaviour("B");
        final var condition = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return state.log.length() > 10;
            }
        };

        agent.setBehaviour(a);
        agent.setTransition(new Agent.Transition<>(a, b, condition));
        agent.update();

        assertEquals("startA conductA endA startB ", agentState.log);
    }

    @Test
    void shouldTransitionBetweenValidStates() {
        final var agentState = new State();
        final var agent = new Agent<>(agentState);
        final var a = new LoggingBehaviour("A");
        final var b = new LoggingBehaviour("B");
        final var condition = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return state.log.length() > 10;
            }
        };
        final var otherCondition = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return state.log.length() > 100;
            }
        };

        agent.setBehaviour(a);
        agent.setTransition(new Agent.Transition<>(a, b, condition));
        agent.setTransition(new Agent.Transition<>(b, a, otherCondition));
        agent.update();

        assertEquals("startA conductA endA startB ", agentState.log);
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
