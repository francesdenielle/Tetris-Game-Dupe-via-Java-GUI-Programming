package tetrispssfx;

public interface Messenger {
	void publish(Message message) throws Exception;
	void subscribe(Subscriber subscriber, String topic) throws Exception;
}
