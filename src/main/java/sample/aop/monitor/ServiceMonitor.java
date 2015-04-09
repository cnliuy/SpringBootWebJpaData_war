package sample.aop.monitor;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {
	//
	//参考 http://my.oschina.net/itblog/blog/211693
	//		Spring中的AOP（五）——在Advice方法中获取目标方法的参数
	//
	@AfterReturning(pointcut = "execution(* sample..*Service.*(..))" ,returning = "returnVal")
	public Date logServiceAccess(JoinPoint joinPoint) {
		Date returnVal = new  Date();
		Object[] o =joinPoint.getArgs();
		o[0] = "1111" ;
		joinPoint.getTarget();
		System.out.println("已经执行了 Completed: " + joinPoint+" "+ returnVal);
		return  returnVal;
	}
	
	


    //@Around("execution(* sample..*Service.*(..))")
    @Around("execution(* sample.jpa.web.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around：执行目标方法之前...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "改变后的参数1";
            args[1] = "5551";
        }
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        
        System.out.println("@Around：执行目标方法之后...");
        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }
	
    //@Before("execution(* sample..*Service.*(..))")

//    public void permissionCheck(ProceedingJoinPoint  point) throws Throwable {
//        System.out.println("@Before：模拟权限检查...");
//        System.out.println("@Before：目标方法为：" + 
//                point.getSignature().getDeclaringTypeName() + 
//                "." + point.getSignature().getName());
//        
//        Object[] args =point.getArgs() ;
//        System.out.println("@Before：参数为：" + Arrays.toString(args));       
//        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
//            args[0] = "改变后的参数1";
//        }
//        //用改变后的参数执行目标方法
//        Object returnValue = point.proceed(args);
//        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
//    }
}