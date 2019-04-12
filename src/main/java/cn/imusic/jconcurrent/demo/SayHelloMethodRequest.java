package cn.imusic.jconcurrent.demo;
class SayHelloMethodRequest implements MethodRequest
{
    public SayHelloMethodRequest(Service s) {
        _service = s;
    }
    public void call() {
        _service.sayHello();
    }
    private Service _service;
}