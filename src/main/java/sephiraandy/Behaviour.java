package sephiraandy;

public interface Behaviour<AgentState> {
    void start(AgentState state);
    void conduct(AgentState state);
    void end(AgentState state);
}
