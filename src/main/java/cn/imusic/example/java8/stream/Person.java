package cn.imusic.example.java8.stream;
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person:{\"name\":\"");
		builder.append(name);
		builder.append("\",\"age\":\"");
		builder.append(age);
		builder.append("\"}");
		return builder.toString();
	}

}