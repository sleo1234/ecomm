package ecommerce.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(ecommerce.controllers..*)")
	public void definePackagePointcuts () {
		//empty method to name the location specified in the pointcut
		
	}
   
    @Around("definePackagePointcuts()")
	public Object logAround (ProceedingJoinPoint jp) {
    	// jp - get method signature while running (possibility to access different points of code
    	
		log.debug("\n \n \n");
		log.debug("****** Before Method Execution ***********  \n {}.{} with arguments[s] = {}",jp.getSignature().getDeclaringTypeName(), 
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("______________________\n \n \n");
		
        Object o = null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		log.debug("\n \n \n");
		log.debug("****** After Method Execution ***********  \n {}.{} with arguments[s] = {}",jp.getSignature().getDeclaringTypeName(), 
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("______________________\n \n \n");
		
		return o;
	}
    
    
}
