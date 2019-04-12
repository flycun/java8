package cn.imusic.jconcurrent.demo;
class Client {
	public Client(Service s) {
		_service = s;
	}

	public void requestService() {
		_service.sayHello();
	}

	private Service _service;

	public static void main(String[] args) {
		Service s = new ServiceImp();
		Client c = new Client(s);
		c.requestService();
	}
}