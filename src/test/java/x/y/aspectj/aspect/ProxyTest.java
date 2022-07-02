package x.y.aspectj.aspect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import x.y.aspectj.ui.PrinterColor;
import x.y.aspectj.ui.PrinterProxy;

class ProxyTest {

    @Test
    @DisplayName("ProxyPattern 수동으로 만들기")
    void ProxyPatternTest() {
        var printer = new PrinterProxy(new PrinterColor());
        printer.print("Hello, my printer!!");
    }

}
