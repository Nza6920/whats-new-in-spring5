package com.niu.reactor.hotstream;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class HotStreamTest {

    @Test
    void simpleHotStreamCreation() {
        Sinks.Many<Integer> hotSource = Sinks.unsafe().many().multicast().directAllOrNothing();
        Flux<Integer> hotFlux = hotSource.asFlux();
        hotFlux.subscribe(d -> System.out.println("Subscriber 1 get" + d));
        hotSource.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        hotSource.tryEmitNext(2).orThrow();

        hotFlux.subscribe(d -> System.out.println("Subscriber 2 get" + d));
        hotSource.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);
        hotSource.emitNext(4, Sinks.EmitFailureHandler.FAIL_FAST);
        hotSource.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
