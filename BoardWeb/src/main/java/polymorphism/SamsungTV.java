package polymorphism;

public class SamsungTV implements TV{

	public SamsungTV() {
		System.out.println("==> 伙己TV 按眉 积己 <==");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("伙己TV 傈盔 难咙");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("伙己TV 傈盔 波咙");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("伙己TV 家府 棵覆");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("伙己TV 家府 郴覆");
	}
}
