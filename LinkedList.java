import java.util.Scanner;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}

class LL {
	Node head;
	
	void add(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node node = new Node(data);
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = null;
	}
	
	void add(int index, int data) {
		Node node =  new Node(data);
		if(index == 0) {
			node.next = head;
			head = node;
		}
		
		else {
			Node temp = head;
			for(int i=0; i<index-1; i++) {
				temp = temp.next;
			}
				node.next = temp.next;
				temp.next = node;
			}
		}
	
	void delete(int index) {
		
		if(index == 0)
			head = head.next;
		else {
			Node prev = head;
			Node temp = head.next;
			for(int i=0; i<index-1; i++) {
				prev = prev.next;
				temp = temp.next;
			}
			if(temp.next == null)
				prev.next = null;
			else
				prev.next = temp.next;	
		}
	}
	void show() {
		Node temp = head;
		System.out.print("Linked List : " );
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}


public class LinkedList {

	public static void main(String[] args) {
		Scanner  in =new Scanner(System.in);
		LL list = new LL();
		list.show();
		int size = 0;
		char ch;
		
		do {
			System.out.print("\n--------------------------------" );
			System.out.print("\n1. Add Element in the List : ");
			System.out.print("\n2. Add Element at a index in the List : ");
			System.out.print("\n3. Remove Element from the List : ");
			System.out.print("\n4. Print Linked List : ");
			System.out.print("\n--------------------------------\n" );
			int option = in.nextInt();
			
			switch(option) {
			case 1:
				System.out.print("\nEnter element to enter : ");
				list.add(in.nextInt());
				list.show();
				size++;
				break;
				
			case 2:
				System.out.print("\nEnter index : ");
				int indx = in.nextInt();
				if(indx<0 || indx > size-1)
					System.out.println("Please enter a valid index.");
				else {
					System.out.print("Enter element : ");
					list.add(indx, in.nextInt());
					list.show();
					size++;
				}
				break;
				
			case 3:
				System.out.print("\nEnter index : ");
				int ind = in.nextInt();
				if(ind<0 || ind > size-1)
					System.out.println("Can't remove element ! Enter valid index.");
				else {
					list.delete(ind);
					list.show();
					size--;
				}
				break;
				
			case 4:
				list.show();
				break;

			default:
				System.out.print("\nPlease enter a valid option. ");
				break;
			}
			System.out.print("\nDo you want to continue? (Type 'y' for yes and 'n' for no) : ");
			ch = in.next().charAt(0);
		} while(ch == 'y');
	}
}
