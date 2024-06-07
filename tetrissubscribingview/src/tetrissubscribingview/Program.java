package tetrissubscribingview;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import tetrisshapeimpl.*;

public class Program {

	public static void main(String[] args) {
		
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource); 
		
	    MyBlock block = (MyBlock) factory.getBean("block");
	    
	    SubscriberView subscriberView  = new SubscriberView(); 
		subscriberView.init(block);
		subscriberView.initUI();
	}

}
