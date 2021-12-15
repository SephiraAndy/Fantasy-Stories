package sephiraandy;

import java.util.function.Predicate;

public record Transition<T>(
        Behaviour<T> from,
        Behaviour<T> to,
        Predicate<T> condition) {
}
