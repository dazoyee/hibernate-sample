package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

public class SizeBean {

    @Size(max = 16)
    private String foo;
    private String bar;

    /*
    @Size(min = 3, max = 6)
    List<Integer> list;

    @Size
    Map<String, Integer> map;

    @Size(max = 100)
    int[] array;
     */

    public String getBar() {
        return bar;
    }

    public void setBar(final String bar) {
        this.bar = bar;
    }

    @Size(max = 10)
    public String getFoo() {
        return foo;
    }

    //    @Size(max = 20)
    public void setFoo(final String foo) {
        this.foo = foo;
    }
}
