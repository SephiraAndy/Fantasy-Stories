package sephiraandy;

public class Agent<AgentState> {
    private final Behaviour<AgentState> behaviour;
    private final AgentState state;

    public Agent(AgentState t, Behaviour<AgentState> behaviour) {
        this.state = t;
        this.behaviour = behaviour;
    }

    public void update() {
        behaviour.conduct(state);
    }

    public interface Behaviour<T> {
        void conduct(T t);
    }
}
