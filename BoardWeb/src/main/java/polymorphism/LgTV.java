package polymorphism;

public class LgTV implements TV{

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
		System.out.println("엘지TV 소리 올림");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("엘지TV 소리 내림");
	}
	

}
