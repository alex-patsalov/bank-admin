package application.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BeforeAspect {

  @Pointcut("execution(* application.controllers.*.* (..))")
  private void beforeAllMethods() {
  }

  @Pointcut("execution(* application.controllers.*.* (..))")
  private void afterAllMethods() {
  }

  @Pointcut("execution(* application.controllers.*.* (..))")
  private void afterAllExceptions() {
  }

  @Before("beforeAllMethods()")
  public void beforeMethod(JoinPoint j) {
    System.out.printf("Method Signature: %s\n", j.getSignature());
    System.out.printf("Arguments: %s \n", Arrays.toString(j.getArgs()));
  }

  @AfterReturning(value = "afterAllMethods()", returning = "retVal")
  public void afterSuccess(JoinPoint j, Object retVal) {
    System.out.printf("Method Signature: %s\n", j.getSignature());
    System.out.printf("Returning: %s\n", retVal.toString());
  }

  @AfterThrowing(value = "afterAllExceptions()", throwing = "error")
  public void afterException(JoinPoint j, Throwable error) {
    System.out.println("---Exception detected---");
    System.out.println("Method Signature: " + j.getSignature());
    System.out.println("Exception: " + error);
  }

}
