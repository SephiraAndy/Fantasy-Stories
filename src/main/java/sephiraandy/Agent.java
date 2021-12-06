package sephiraandy;

public class Agent<AgentState> {
    private Behaviour<AgentState> behaviour;
    private final AgentState state;

    public Agent(AgentState state) {
        this.state = state;
    }

    public void update() {
        behaviour.conduct(state);
    }

    public void setBehaviour(Behaviour<AgentState> behaviour) {
        this.behaviour = behaviour;
        behaviour.setup(state);
    }

    public interface Behaviour<AgentState> {
        void setup(AgentState state);
        void conduct(AgentState state);
    }
}
