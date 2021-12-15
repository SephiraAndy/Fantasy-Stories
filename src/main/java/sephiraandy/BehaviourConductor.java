package sephiraandy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BehaviourConductor<T> {

    private final Map<Behaviour<T>, List<Transition<T>>> transitions = new HashMap<>();
    private Behaviour<T> startBehaviour;

    public void conduct(Agent<T> agent, T state,  Behaviour<T> behaviour) {
        behaviour.conduct(state);
        if (transitions.containsKey(behaviour)) {
            var transitionList = transitions.get(behaviour);
            for (var transition : transitionList) {
                if (transition.condition().test(state)) {
                    setBehaviour(transition, agent, state);
                    break;
                }
            }
        }
    }

    public void setStartBehaviour(Behaviour<T> startBehaviour) {
        this.startBehaviour = startBehaviour;
    }

    private void setBehaviour(Transition<T> transition, Agent<T> agent, T state) {
        transition.from().end(state);
        transition.to().start(state);
        agent.setBehaviour(transition.to());
    }

    public void setTransition(Transition<T> stateTransition) {
        if (transitions.containsKey(stateTransition.from())) {
            final var transitionList = transitions.get(stateTransition.from());
            transitionList.add(stateTransition);
        } else {
            final var transitionList = new ArrayList<Transition<T>>();
            transitionList.add(stateTransition);
            transitions.put(stateTransition.from(), transitionList);
        }
    }

    public Behaviour<T> startBehaviour() {
        return startBehaviour;
    }
}
