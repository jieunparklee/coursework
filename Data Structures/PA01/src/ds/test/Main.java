package ds.test;

import java.util.Scanner;

import ds.queue.Queue;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<String> queue = new ds.queue.LinkedQueue<String>();

		while (sc.hasNext()) {
			String command = sc.next();

			if ("enqueue".equals(command)) {
				String item = sc.next();
				System.out.println("ENQUEUE: " + item);
				queue.enqueue(item);
			} else if ("dequeue".equals(command)) {
				String removedItem = queue.dequeue();
				if (removedItem == (String) null) {
					System.out.println("DEQUEUE: the queue is empty!");
				} else System.out.println("DEQUEUE: " + removedItem);
			} else if ("length".equals(command)) {
				System.out.println("LENGTH: " + queue.length());
			} else if ("isEmpty".equals(command)) {
				System.out.println("ISEMPTY: " + queue.isEmpty());
			} else if ("clear".equals(command)) {
				System.out.println("CLEAR: COMPLETE");
				queue.clear();
			} else if ("reverse".equals(command)) {
				System.out.println("REVERSE: COMPLETE");
				queue.reverse();
			}
		}

		sc.close();
	}
}
