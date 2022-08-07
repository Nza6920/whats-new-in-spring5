package com.niu.reactor.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class StreamCreateTest {

    @Test
    void fluxJust() {
        Flux<String> stockSeq1 = Flux.just("APPL", "AMZN", "TSLA");
    }

    @Test
    void fluxFromIterable() {
        Flux<String> stockSeq2 = Flux.fromIterable(Arrays.asList("APPL", "AMZN", "TSLA"));
    }

    @Test
    void fluxFromArray() {
        Flux<String> stockSeq3 = Flux.fromArray(new String[]{"APPL", "AMZN", "TSLA"});
    }

    @Test
    void fluxFromStream() {
        Flux<String> stockSeq4 = Flux.fromStream(Stream.of(new String[]{"APPL", "AMZN", "TSLA"}));
        stockSeq4.subscribe();
    }

    @Test
    void fluxEmpty() {
        Flux<String> stockSeq5 = Flux.empty();
    }
}
