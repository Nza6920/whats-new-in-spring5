package com.niu.reactor.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class StreamOpsTest {

    @Test
    void subscribeMethod() {
        Flux<String> stockSeq1 = Flux.just("APPL", "AMZN", "TSLA");
        stockSeq1.log()
                .subscribe();
    }

    @Test
    void subscribeWithErrorConsumer() {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    // 发送流的逻辑
                    if (i <= 3) {
                        return i;
                    }
                    throw new RuntimeException("i > 3");
                });
        ints.subscribe(i -> log.info(String.valueOf(i)),
                err -> log.error("error: {}", err.getMessage()));
    }

    @Test
    void subscribeWithErrorAndCompleteConsumer() {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    // 发送流的逻辑
                    return i;
                });

        // onError 和 onComplete 无法同时触发
        ints.subscribe(i -> log.info(String.valueOf(i)),
                err -> log.error("error: {}", err.getMessage()),
                () -> log.info("subscribe complete.."));
    }

    @Test
    void streamBuffer() {
        Flux<Integer> ints = Flux.range(1, 400);
        Flux<List<Integer>> buffered =
                ints.buffer(3);
        buffered.log().subscribe();
    }

    @Test
    void streamRetry() {
        Mono<String> mono = Mono.fromSupplier(() -> {
            double random = Math.random();
            if (random > 0.01) {
                throw new Error("error");
            }
            return "ok";
        });
        mono.log().retry(3).subscribe();
    }
}
