package cn.imusic.example.algo;

public class LinkedListAlgo {
	
	public static void printAll(Node list) {
		Node p=list;
		while(p!=null) {
			System.out.print(p.data+" ");
			p=p.next;
		}
		System.out.println();
	}
	
	public static Node createNode(int value) {
		return new Node(value,null);
	}
	
	public static class Node{
		private int data;
		private Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		public int getData() {
			return data;
		}
		
		
	}

}
