package cn.imusic.jconcurrent.demo;
class ServiceProxy implements Service {
	public ServiceProxy() {
		_service = new ServiceImp();
		_active_object = new ActiveObject();
	}

	public void sayHello() {
		MethodRequest mr = new SayHelloMethodRequest(_service);
		_active_object.enqueue(mr);
	}

	private Service _service;
	private ActiveObject _active_object;
	
	
	public static void main(String[] args) {
		Service s = new  ServiceProxy();
 	    Client c = new Client(s);
        c.requestService();
	}
}