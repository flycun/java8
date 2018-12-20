package cn.imusic.example.java8.stream.groupby;
import java.math.BigDecimal;

public class Item {

    private String name;
    private int qty;
    private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item:{\"name\":\"");
		builder.append(name);
		builder.append("\",\"qty\":\"");
		builder.append(qty);
		builder.append("\",\"price\":\"");
		builder.append(price);
		builder.append("\"}");
		return builder.toString();
	}

}