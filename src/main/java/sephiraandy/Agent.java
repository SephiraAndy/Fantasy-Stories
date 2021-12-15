package sephiraandy;

public class Agent<AgentState> {
    private Behaviour<AgentState> behaviour;
    private final AgentState state;
    private final BehaviourConductor<AgentState> conductor;

    public Agent(AgentState state, BehaviourConductor<AgentState> conductor, Behaviour<AgentState> initialBehaviour) {
        this.state = state;
        this.conductor = conductor;
        this.behaviour = initialBehaviour;
    }

    public void update() {
        conductor.conduct(this, state, behaviour);
    }

    public void setBehaviour(Behaviour<AgentState> behaviour) {
        this.behaviour = behaviour;
    }
}
