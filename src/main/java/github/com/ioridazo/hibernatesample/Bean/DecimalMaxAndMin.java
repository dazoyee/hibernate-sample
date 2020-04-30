package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class DecimalMaxAndMin {

    @DecimalMax("10")
    String stringValue;

    @DecimalMin("-10.0")
    int intValue;

    @DecimalMin("3.00")
    @DecimalMax("4.00")
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
