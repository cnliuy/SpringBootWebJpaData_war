package sample.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.aop.service.HelloWorldService;

//测试类
//
@SpringBootApplication
public class SampleAopApplication implements CommandLineRunner {

	// Simple example shows how an application can spy on itself with AOP

	@Autowired
	private HelloWorldService helloWorldService;

	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getHelloMessage("333","222"));
	}

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SampleAopApplication.class, args);
		SpringApplication.run(SampleAopApplication.class, "lll");
	}
}