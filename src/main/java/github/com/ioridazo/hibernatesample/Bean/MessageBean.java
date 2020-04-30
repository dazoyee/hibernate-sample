package github.com.ioridazo.hibernatesample.Bean;

import javax.validation.constraints.Size;

public class MessageBean {

    // 全部10桁以下でNG
    @Size(min = 10)
    String defaultMessage = "hoge";

    @Size(min = 10, message = "サイズが{min}と{max}の間ではないよ")
    String directMessage = "hoge";

    @Size(min = 10, message = "{mykey}")
    String fromPropMessage = "hoge";

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(final String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDirectMessage() {
        return directMessage;
    }

    public void setDirectMessage(final String directMessage) {
        this.directMessage = directMessage;
    }

    public String getFromPropMessage() {
        return fromPropMessage;
    }

    public void setFromPropMessage(final String fromPropMessage) {
        this.fromPropMessage = fromPropMessage;
    }
}
