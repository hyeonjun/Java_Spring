package polymorphism;

public class SamsungTV implements TV{

	public SamsungTV() {
		System.out.println("==> �ＺTV ��ü ���� <==");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV ���� ����");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV ���� ����");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV �Ҹ� �ø�");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("�ＺTV �Ҹ� ����");
	}
}
