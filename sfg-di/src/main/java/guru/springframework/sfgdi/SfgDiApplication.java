package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.ConstructorInjectionController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PetController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		// 1. Context를 정의한다.
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		// Context를 통해서 Bean을 받는다 (Controller Bean), 이런식으로 스프링빈은 아무데서나 호출이 가능하다.
		System.out.println("------------- Primary Bean");
		MyController myController2 = (MyController) ctx.getBean("myController");
		String greeting = myController2.sayHello();
		System.out.println(greeting);

		System.out.println("------------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------- setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreetingService());

		System.out.println("------------- Constructor");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) ctx
				.getBean("constructorInjectionController");

		System.out.println(constructorInjectionController.getGreeting());
	}
}
