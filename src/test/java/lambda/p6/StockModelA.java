package lambda.p6;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StockModelA {

    private final String symbol;

    private final String name;

    public StockModelA(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}
