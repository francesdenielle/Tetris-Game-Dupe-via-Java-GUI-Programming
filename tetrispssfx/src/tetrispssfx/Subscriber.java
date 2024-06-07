package tetrispssfx;

public interface Subscriber {
	String getSubscriberName();
	void receive(Message message);
	void receive(String[] topics);
}
