package lambda.p6;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class StockModelB {

    private final String symbol;

    private final String name;

    private final String desc;

    private final BigDecimal currentPrice;

    private final BigDecimal prevPrice;

    public StockModelB(String symbol, String name, String desc, BigDecimal currentPrice, BigDecimal prevPrice) {
        this.symbol = symbol;
        this.name = name;
        this.desc = desc;
        this.currentPrice = currentPrice;
        this.prevPrice = prevPrice;
    }
}
