package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("==> SonySpeaker ��ü ����");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SonySpeaker �Ҹ� �ø�");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SonySpeaker �Ҹ� ����");
	}

}
