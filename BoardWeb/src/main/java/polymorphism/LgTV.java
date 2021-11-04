package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV{
	@Autowired // setter를 굳이 만들지 않아도 사용할 수 있음
	@Qualifier("apple")
	private Speaker speaker;

	public LgTV() {
		System.out.println("==> LgTV 객체 생성");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 메서드 호출");
	}
	
	public void destroyMethod() {
		System.out.println("객체 소멸 메서드 호출");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("엘지TV 전원 켜짐");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("엘지TV 전원 꺼짐");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		System.out.println("엘지TV 소리 올림");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		System.out.println("엘지TV 소리 내림");
		speaker.volumeDown();
	}
	

}
