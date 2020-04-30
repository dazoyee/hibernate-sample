package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class DigitsBean {

    @Digits(integer = 3, fraction = 1)
    String stringValue;

    @Digits(integer = 4, fraction = 0)
    int intValue;

    @Digits(integer = 4, fraction = 3)
    BigDecimal bigDecimalValue;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(final String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(final int intValue) {
        this.intValue = intValue;
    }

    public BigDecimal getBigDecimalValue() {
        return bigDecimalValue;
    }

    public void setBigDecimalValue(final BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
    }
}
