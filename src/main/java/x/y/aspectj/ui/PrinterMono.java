package x.y.aspectj.ui;

import org.springframework.stereotype.Component;

@Component
public class PrinterMono implements Printer {

    @Override
    public void print(String message) {
        System.out.println("--- Start Color Printer ---");
        System.out.println("컬러 프린터로 출력합니다: " + message);
        System.out.println("--- End Color Printer ---");    }

}
