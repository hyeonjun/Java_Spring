package com.collect.mapping;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		/*List<String> addressList = bean.getAddressList();
		for (String i : addressList){
			System.out.println(i.toString());
		}*/
		
		/*Set<String> entrySet = bean.getAddressList();
		System.out.println(entrySet);*/
		
		/*Map<String, String> map = bean.getAddressList();
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = map.get(key);
			System.out.println("ket : "+key+" value : "+value);
		}*/
		
		Properties p = bean.getAddressList();
		System.out.println(p.getProperty("ȫ�浿"));
		
		factory.close();
		
		
	}

}
