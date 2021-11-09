package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		// 1. Spring �����̳� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü ��û(Lookup)
		TV tv = (TV)factory.getBean("lg");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv"); 
		// singtone���� 3���� �����ص� ��ü ������ �ϳ��ۿ� �ȴ�
		// prototype���� �ϸ� �� ������
		
		/*BeansFactory bean = new BeansFactory();
		TV tv = (TV) bean.getBean(args[0]); */
		
		
	    tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳� ����(�ڿ� ����)
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
