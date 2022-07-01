package x.y.aspectj.aspect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import x.y.aspectj.config.ConfigJava;
import x.y.aspectj.model.Person;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigJava.class)
class AdviceTest {

    @Autowired
    private ApplicationContext applicationContext;
    private Person person;

    @BeforeEach
    void setUp() {
        person = applicationContext.getBean(Person.class);
    }

    @Test
    @DisplayName("JavaConfig 정상 작동")
    void logBefore() {
        System.out.println("\n### STEP0 : 클라이언트 person.print() 호출");
        person.print();
    }

    @Test
    void logAround() {
    }

    @Test
    void logAfterReturning() {
    }

    @Test
    void logAfterThrowing() {
    }

    @Test
    void logAfter() {
    }
}