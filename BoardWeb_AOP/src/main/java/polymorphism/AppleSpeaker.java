package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("==> AppleSpeaker 按眉 积己");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker 家府 棵覆");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker 家府 郴覆");
	}

}
