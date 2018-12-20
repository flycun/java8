package cn.imusic.example.java8;

import java.math.BigDecimal;

public class Developer {

	private String name;
	private BigDecimal salary;
	private int age;

	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
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
		builder.append("Developer:{\"name\":\"");
		builder.append(name);
		builder.append("\",\"salary\":\"");
		builder.append(salary);
		builder.append("\",\"age\":\"");
		builder.append(age);
		builder.append("\"}");
		return builder.toString();
	}
	
	
}
