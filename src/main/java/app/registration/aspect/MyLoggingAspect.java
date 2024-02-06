package app.registration.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class MyLoggingAspect {


    @Around("execution(* app.registration.dao.*.*(..))")
    public Object aroundAllRepositoryAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);

        return targetMethodResult;
    }
}

