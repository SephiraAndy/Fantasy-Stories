import org.junit.jupiter.api.Test;
import sephiraandy.Agent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest {
    @Test
    void shouldConductBehaviour() {
        final var agentState = new State();
        final var behaviour = new Agent.Behaviour<State>() {

            @Override
            public void conduct(State a) {
                a.log("conduct");
            }
        };
        final var agent = new Agent<>(agentState, behaviour);

        agent.update();

        assertEquals("conduct", agentState.log);
    }

    private static class State {
        private String log = "";

        public void log(String log) {
            this.log += log;
        }
    }

}
