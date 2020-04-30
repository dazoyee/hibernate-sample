package github.com.ioridazo.hibernatesample.web;

import github.com.ioridazo.hibernatesample.Bean.AssertTrueAndFalse;
import github.com.ioridazo.hibernatesample.Bean.DecimalMaxAndMin;
import github.com.ioridazo.hibernatesample.Bean.DigitsBean;
import github.com.ioridazo.hibernatesample.Bean.FuturePastBean;
import github.com.ioridazo.hibernatesample.Bean.MessageBean;
import github.com.ioridazo.hibernatesample.Bean.PatternBean;
import github.com.ioridazo.hibernatesample.Bean.SizeBean;
import github.com.ioridazo.hibernatesample.Bean.ValidBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HibernateController {

    @GetMapping("/")
    public String get(@RequestParam Map<String, Object> params) {
        return params.get("foo") + params.get("bar").toString();
    }

    // curl -X POST localhost:8080 -H "Content-Type: application/json" -d '{"mustTrue":true,"decimal":3.14,"digit":1000,"size":"0123456789","pattern":"hoge"}'
    // curl -X POST localhost:8080 -H "Content-Type: application/json" -d '{"mustTrue":false,"decimal":31.4,"digit":10000,"size":"123456789","pattern":"HOGE"}'
    @PostMapping("/")
    public String post(@RequestBody @Validated ValidBean validBean, BindingResult bindingResult) {

        StringBuilder stringBuilder = new StringBuilder();

        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> {
                stringBuilder.append(fieldError.getField()).append(" : ");
                stringBuilder.append(fieldError.getRejectedValue()).append("\t");
                stringBuilder.append(fieldError.getDefaultMessage()).append("\n");
            });
        } else {
            stringBuilder.append("no problem!").append("\n");
        }

        return stringBuilder.toString();
    }

    // curl -X POST localhost:8080/size -H "Content-Type: application/json" -d '{"foo":"11112222333344445","bar":"123"}'
    @PostMapping("/size")
    public String size(@RequestBody @Validated SizeBean sizeBean) {
        String fooBar = sizeBean.getFoo() + sizeBean.getBar();
        System.out.println(fooBar);
        return fooBar;
    }

    // curl -X POST localhost:8080/assert-true-false -H "Content-Type: application/json" -d '{"mustTrue":true,"mustFalse":false}'
    @PostMapping("/assert-true-false")
    public Boolean assertTrueFalse(@RequestBody @Validated AssertTrueAndFalse assertTrueAndFalse) {
        if (assertTrueAndFalse.isMustTrue() && !assertTrueAndFalse.isMustFalse()) {
            return true;
        } else {
            return false;
        }
    }

    // curl -X POST localhost:8080/decimal-max-min -H "Content-Type: application/json" -d '{"stringValue":"10","intValue":-10,"bigDecimalValue":3.5}'
    @PostMapping("/decimal-max-min")
    public String decimalMaxMin(@RequestBody @Validated DecimalMaxAndMin decimalMaxAndMin) {
        String decimalMaxMin = decimalMaxAndMin.getStringValue() + decimalMaxAndMin.getIntValue() + decimalMaxAndMin.getBigDecimalValue();
        System.out.println(decimalMaxMin);
        return decimalMaxMin;
    }

    // curl -X POST localhost:8080/digits -H "Content-Type: application/json" -d '{"stringValue":"100.1","intValue":-1000,"bigDecimalValue":3000.005}'
    @PostMapping("digits")
    public String digits(@RequestBody @Validated DigitsBean digitsBean) {
        String digits = digitsBean.getStringValue() + digitsBean.getIntValue() + digitsBean.getBigDecimalValue();
        System.out.println(digits);
        return digits;
    }

    @PostMapping("future-past")
    public String futurePast(@RequestBody @Validated FuturePastBean futurePastBean) {
        String futurePast = futurePastBean.getLocalDate().toString() + futurePastBean.getLocalDateTime().toString();
        System.out.println(futurePast);
        return futurePast;
    }

    // curl -X POST localhost:8080/pattern -H "Content-Type: application/json" -d '{"hoge":"hoge","bar":"bar"}'
    @PostMapping("pattern")
    public String pattern(@RequestBody @Validated PatternBean patternBean) {
        String pattern = patternBean.getHoge() + patternBean.getBar();
        System.out.println(pattern);
        return pattern;
    }

    // curl -X POST localhost:8080/message -H "Content-Type: application/json" -d '{"defaultMessage":"hogeeeeeeee","directMessage":"barrrrrrrrrrrrr","fromPropMessage":"hogeeeeeeeeeeeeee"}
    @PostMapping("message")
    public String message(@RequestBody @Validated MessageBean messageBean) {
        String message = messageBean.getDefaultMessage() + messageBean.getDirectMessage() + messageBean.getFromPropMessage();
        System.out.println(message);
        return message;
    }

    // RequestParam     リクエストパラメータに値を持つことを明示する
    // RequestBody      リクエストボディに値を持つことを明示する
}
