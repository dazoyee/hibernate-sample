package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

public class AssertTrueAndFalse {

    @AssertTrue
    boolean mustTrue;
    @AssertFalse
    boolean mustFalse;

    public boolean isMustTrue() {
        return mustTrue;
    }

    public void setMustTrue(final boolean mustTrue) {
        this.mustTrue = mustTrue;
    }

    public boolean isMustFalse() {
        return mustFalse;
    }

    public void setMustFalse(final boolean mustFalse) {
        this.mustFalse = mustFalse;
    }
}
