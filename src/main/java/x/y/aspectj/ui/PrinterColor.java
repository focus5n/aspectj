package x.y.aspectj.ui;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PrinterColor implements Printer {

    @Override
    public void print(String message) {
        System.out.println("--- Start Mono Printer ---");
        System.out.println("컬러 프린터로 출력합니다: " + message);
        System.out.println("--- End Mono Printer ---");
    }
}
