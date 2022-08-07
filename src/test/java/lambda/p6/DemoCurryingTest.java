package lambda.p6;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class DemoCurryingTest {

    @Test
    public void testSimpleStockModelACreation() {
        BiFunction<String, String, StockModelA> stockModelCreator = StockModelA::new;
        StockModelA stockModelA = stockModelCreator.apply("s1", "name1");
        log.info(stockModelA.toString());

        Function<String, Function<String, StockModelA>> curryStockModelCreator = symbol -> (Function<String, StockModelA>) name -> new StockModelA(symbol, name);
        StockModelA curryStockModel = curryStockModelCreator.apply("symbol").apply("name");
        log.info(curryStockModel.toString());
    }

    @Test
    public void testSimpleStockModelBCreation() {

        Function<String, Function<String, Function<String, Function<BigDecimal, Function<BigDecimal, StockModelB>>>>> curryStockModelBCreator =
                symbol -> name -> desc -> currentPrice -> prevPrice -> new StockModelB(symbol, name, desc, currentPrice, prevPrice);

        StockModelB stockModelB = curryStockModelBCreator.apply("symbol")
                .apply("name1")
                .apply("desc1")
                .apply(new BigDecimal("100"))
                .apply(new BigDecimal("50"));
        log.info(stockModelB.toString());
    }
}
