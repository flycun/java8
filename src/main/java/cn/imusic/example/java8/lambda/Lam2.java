package cn.imusic.example.java8.lambda;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lam2 {
	public static void main(String[] args) {
		Lam2.Test ui = new Lam2().new Test();
		Button bt = new Button();
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ui.showSomething();
			}
		});

		/*
		 * actionPerformed()方法的返回类型是void，所以需要特殊处理，即在ui.showSomething();左右加上花括号。<br>（想象下不加会怎么样？如果不加的话，若showSomething()
		 * 方法返回值是整数类型 ，那么就意味着actionPerformed()返回整数类型，显然不是，所以必须加花括号用来标记）
		 */
		Button bt2 = new Button();
		bt2.addActionListener(event -> {
			ui.showSomething();
		});
	}

	class Test {
		int showSomething() {
			return 0;
		}
	}
}
