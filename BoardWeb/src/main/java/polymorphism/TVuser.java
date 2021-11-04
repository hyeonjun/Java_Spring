package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체 요청(Lookup)
		TV tv = (TV)factory.getBean("lg");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv"); 
		// singtone으면 3개를 생성해도 객체 생성은 하나밖에 안댐
		// prototype으로 하면 다 생성됨
		
		/*BeansFactory bean = new BeansFactory();
		TV tv = (TV) bean.getBean(args[0]); */
		
		
	    tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너 종료(자원 해제)
		factory.close();
		
		
		/*TV tv = (TV) bean.getBean("samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		TV tv2 = (TV) bean.getBean("lg");
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();*/
		
		
		
/*		TV stv = new SamsungTV();
		stv.powerOn();
		stv.volumeUp();
		stv.volumeDown();
		stv.powerOff();
		
		TV ltv = new LgTV();
		ltv.powerOn();
		ltv.volumeUp();
		ltv.volumeDown();
		ltv.powerOff();*/
	}

}
