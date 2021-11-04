package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("==> �ＺTV ��ü ���� (default) <==");
	}
	
/*	// DI �� Constructor Injection
	public SamsungTV(Speaker speaker) {
		System.out.println("==> �ＺTV ��ü ���� (overloading) <==");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("==> �ＺTV ��ü ���� (overloading2 ���� �Ű� ����) <==");
		this.speaker = speaker;
		this.price = price;
	}*/
	
	public Speaker getSpeaker() {
		return speaker;
	}

	// DI �� Setter Injection(�⺻ ������ �ʿ�)
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() ȣ��");
		this.price = price;
	}	

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV ���� ���� (���� : "+ price + ")");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV ���� ����");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		System.out.println("�ＺTV �Ҹ� �ø�");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		System.out.println("�ＺTV �Ҹ� ����");
//		speaker = new SonySpeaker();
	    speaker.volumeDown();
	}
}
