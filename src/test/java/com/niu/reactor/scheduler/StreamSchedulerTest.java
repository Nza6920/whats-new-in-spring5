package com.niu.reactor.scheduler;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class StreamSchedulerTest {

    @Test
    void noThreadDefined() {
        Mono<String> jojo = Mono.just("jojo");
        jojo.map(str -> str + " with no thread define")
                .subscribe(str -> System.out.println(str + Thread.currentThread().getName()));
    }

    @Test
    void runInNewThread() throws InterruptedException {
        Thread t = new Thread(() -> {
            Mono<String> foo = Mono.just("foo");
            foo.map(str -> str + " in new thread define")
                    .subscribe(str -> System.out.println(str + Thread.currentThread().getName()));
        });
        t.start();
        t.join();
    }

    @Test
    void schedulerImmediate() {
        Mono<String> foo = Mono.just("foo");
        foo.map(str -> str + " in new thread define")
                .subscribeOn(Schedulers.immediate())
                .subscribe(str -> System.out.println(str + Thread.currentThread().getName()));
    }

    @Test
    void schedulerSingle() {
        Mono<String> foo = Mono.just("foo");
        foo.map(str -> str + " in new thread define")
                .subscribeOn(Schedulers.single())
                .subscribe(str -> System.out.println(str + Thread.currentThread().getName()));
    }

    @Test
    void schedulerElastic() {
        Mono<String> foo = Mono.just("foo");
        foo.map(str -> str + " in new thread define")
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(str -> System.out.println(str + Thread.currentThread().getName()));
    }
}
