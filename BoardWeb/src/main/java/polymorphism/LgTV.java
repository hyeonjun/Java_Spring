package polymorphism;

public class LgTV implements TV{

	public LgTV() {
		System.out.println("==> LgTV ��ü ����");
	}
	
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �޼��� ȣ��");
	}
	
	public void destroyMethod() {
		System.out.println("��ü �Ҹ� �޼��� ȣ��");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("����TV ���� ����");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("����TV ���� ����");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("����TV �Ҹ� �ø�");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("����TV �Ҹ� ����");
	}
	

}
