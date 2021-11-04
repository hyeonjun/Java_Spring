package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("==> 삼성TV 객체 생성 (default) <==");
	}
	
/*	// DI 중 Constructor Injection
	public SamsungTV(Speaker speaker) {
		System.out.println("==> 삼성TV 객체 생성 (overloading) <==");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("==> 삼성TV 객체 생성 (overloading2 다중 매개 변수) <==");
		this.speaker = speaker;
		this.price = price;
	}*/
	
	public Speaker getSpeaker() {
		return speaker;
	}

	// DI 중 Setter Injection(기본 생성자 필요)
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() 호출");
		this.price = price;
	}	

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV 전원 켜짐 (가격 : "+ price + ")");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("삼성TV 전원 꺼짐");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		System.out.println("삼성TV 소리 올림");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		System.out.println("삼성TV 소리 내림");
//		speaker = new SonySpeaker();
	    speaker.volumeDown();
	}
}
