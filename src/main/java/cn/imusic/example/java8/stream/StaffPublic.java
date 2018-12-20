package cn.imusic.example.java8.stream;
public class StaffPublic {

    private String name;
    private int age;
    private String extra;
    //...
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StaffPublic:{\"name\":\"");
		builder.append(name);
		builder.append("\",\"age\":\"");
		builder.append(age);
		builder.append("\",\"extra\":\"");
		builder.append(extra);
		builder.append("\"}");
		return builder.toString();
	}
	
}