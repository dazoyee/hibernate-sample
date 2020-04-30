package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ValidBean {

    @AssertTrue
    private boolean mustTrue;

    @DecimalMin("3.00")
    @DecimalMax("4.00")
    private BigDecimal decimal;

    @Digits(integer = 4, fraction = 0)
    private int digit;

    @Size(min = 10, max = 16)
//    @Size(min = 10, max = 16, message = "サイズが{min}と{max}の間ではないよ")
    private String size;

    @Pattern(regexp = "hoge")
    private String pattern;

    public int getDigit() {
        return digit;
    }

    public void setDigit(final int digit) {
        this.digit = digit;
    }

    public boolean isMustTrue() {
        return mustTrue;
    }

    public void setMustTrue(final boolean mustTrue) {
        this.mustTrue = mustTrue;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(final BigDecimal decimal) {
        this.decimal = decimal;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }
}
