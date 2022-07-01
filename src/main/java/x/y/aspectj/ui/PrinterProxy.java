package x.y.aspectj.ui;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PrinterProxy implements Printer {

    public PrinterProxy(Printer printer) {}

    @Override
    public void print(String message) {
        System.out.println("before 핵심 코드보다 먼저 실행됩니다.");
        System.out.println("프록시 프린트로 출력합니다: " + message);
        System.out.println("after 핵심 코드보다 나중에 실행됩니다.");
    }

}
