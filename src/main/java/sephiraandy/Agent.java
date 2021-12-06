package sephiraandy;

public class Agent<AgentState> {
    private final Behaviour<AgentState> behaviour;
    private final AgentState state;

    public Agent(AgentState state, Behaviour<AgentState> behaviour) {
        this.state = state;
        this.behaviour = behaviour;
        behaviour.setup(state);
    }

    public void update() {
        behaviour.conduct(state);
    }

    public interface Behaviour<AgentState> {
        void setup(AgentState state);
        void conduct(AgentState state);
    }
}
