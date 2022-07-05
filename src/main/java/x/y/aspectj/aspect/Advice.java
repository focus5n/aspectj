package x.y.aspectj.aspect;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {

    private final String target = "execution(public * x.y.aspectj.model.Person.*(..))";

    @Before(target)
    public void logBefore(JoinPoint joinPoint) {
        var signature = joinPoint.getSignature().toLongString();

        System.out.println("### => 공통코드 실행중");
        System.out.println("### STEP1 : <aop:before> = 메서드 실행 직전에 적용되는 어드바이스");
        System.out.println("### STEP1 : " + signature + " 시작 전");
    }

    @Around(target)
    public Object logAround(ProceedingJoinPoint proceedingJoingPoint) throws Throwable {
        var signature = proceedingJoingPoint.getSignature().toLongString();
        var time = new Date().getTime();

        System.out.println("### STEP2 : <aop:around> = 메서드 호출 이전, 이후, 예외 발생 등 모든 시점에 적용 가능한 어드바이스 정의");
        System.out.println("### STEP2 : " + signature + " around 시작.");

        try {
            return proceedingJoingPoint.proceed();
        } finally {
            System.out.printf("실행시간: %dms %n", new Date().getTime() - time);
        }
    }

    @AfterReturning(pointcut = target, returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        var signature = joinPoint.getSignature().toLongString();

        System.out.println("### STEP3 : <aop:after-returning> = 메서드가 정상적으로 실행된 후에 적용되는 어드바이스 정의");
        System.out.println("### STEP3 : " + signature + "\n ### : 실행 결과 [" + returnValue + "]");
    }

    @AfterThrowing(pointcut = target, throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException exception) {

        var signature = joinPoint.getSignature().toLongString();
        System.out.printf("%s", signature);

        System.out.println("### STEP4 : <aop:after-throwing> = 메서드가 예외를 발생시킬 때 적용되는 어드바이스를 정의");
        System.out.println("### STEP4 : 예외발생  => " + exception.toString());
    }

    @After(target)
    public void logAfter(JoinPoint joinPoint) {

        var signature = joinPoint.getSignature().toLongString();

        System.out.println("### STEP5 : <aop:after> = 메서드가 정상적으로 실행되는지 또는 에외를 발생시키는지 여부에 상관없이 실행하는어드바이스를 정의");
        System.out.println("### STEP5 : " + signature + " 종료.");
    }

}
