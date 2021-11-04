package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("==> SonySpeaker 按眉 积己");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SonySpeaker 家府 棵覆");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SonySpeaker 家府 郴覆");
	}

}
