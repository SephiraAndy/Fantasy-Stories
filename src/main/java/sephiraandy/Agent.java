package sephiraandy;

import java.util.*;
import java.util.function.Predicate;

public class Agent<AgentState> {
    private Behaviour<AgentState> behaviour;
    private final AgentState state;
    private final Map<Behaviour<AgentState>, List<Transition<AgentState>>> transitions = new HashMap<>();

    public Agent(AgentState state) {
        this.state = state;
    }

    public void update() {
        behaviour.conduct(state);
        if (transitions.containsKey(behaviour)) {
            var transitionList = transitions.get(behaviour);
            for (var transition : transitionList) {
                if (transition.condition.test(state)) {
                    setBehaviour(transition.to);
                    break;
                }
            }
        }
    }

    public void setBehaviour(Behaviour<AgentState> behaviour) {
        if (this.behaviour != null) {
            this.behaviour.end(state);
        }
        this.behaviour = behaviour;
        behaviour.start(state);
    }

    public void setTransition(Transition<AgentState> stateTransition) {
        if (transitions.containsKey(stateTransition.from)) {
            final var transitionList = transitions.get(stateTransition.from);
            transitionList.add(stateTransition);
        } else {
            final var transitionList = new ArrayList<Transition<AgentState>>();
            transitionList.add(stateTransition);
            transitions.put(stateTransition.from, transitionList);
        }
    }

    public static class Transition<AgentState> {
        private final Behaviour<AgentState> from;
        private final Behaviour<AgentState> to;
        private final Predicate<AgentState> condition;

        public Transition(Behaviour<AgentState> from, Behaviour<AgentState> to, Predicate<AgentState> condition) {
            this.from = from;
            this.to = to;
            this.condition = condition;
        }
    }
}
