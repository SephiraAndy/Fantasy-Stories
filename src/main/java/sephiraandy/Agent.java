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
        if (this.behaviour != null) {
            this.behaviour.end(state);
        }
        this.behaviour = behaviour;
        behaviour.start(state);
    }

    public interface Behaviour<AgentState> {
        void start(AgentState state);
        void conduct(AgentState state);
        void end(AgentState state);
    }
}
