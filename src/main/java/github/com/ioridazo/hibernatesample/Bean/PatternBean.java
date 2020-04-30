package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.Pattern;

public class PatternBean {

    @Pattern(regexp = "hoge")
    String hoge;
    @Pattern(regexp = "bar")
    String bar;

    public String getHoge() {
        return hoge;
    }

    public void setHoge(final String hoge) {
        this.hoge = hoge;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(final String bar) {
        this.bar = bar;
    }
}
