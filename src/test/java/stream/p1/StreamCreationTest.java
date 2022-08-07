package stream.p1;

import com.niu.mvc.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

@Slf4j
public class StreamCreationTest {

    @Test
    void streamGenerate() {
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);
    }

    @Test
    void streamBuilder() {
        Stream.Builder<Stock> builder = Stream.builder();
        builder.accept(Stock.builder().build());
        Stream<Stock> stockStream = builder.build();
        stockStream.forEach(System.out::println);
    }
}
