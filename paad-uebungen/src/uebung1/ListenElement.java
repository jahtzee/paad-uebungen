package uebung1;

public class ListenElement {
	private int info;
	private ListenElement next; // Referenz auf Nachfolger
	
	// 1. Konstruktor
	public ListenElement() {
	info = 0;
	next = null;
	}
	
	// 2. Konstruktor
	public ListenElement(int input, ListenElement toBeConnected){
	info = input;
	next = toBeConnected;
	}
	
	//liste bis zum zweitletzten Element traversieren
	public void getButLastInfo() {
		if (this.getNext() != null) {
			System.out.println(this.getInfo());
			this.getNext().getButLastInfo();
		}
	}
	
	//letztes listenelement löschen
	public void deleteLastElement() {
		if (this.getNext().getNext() != null) { //wenn das nächste Element nicht das letzte ist
			this.getNext().deleteLastElement(); //rekursion
		} else {								//wenn das nächste element das letzte ist, dann
			this.setNext(null);
		}
	}
	
	//an letztes listenelement anhängen
	public void addElement(ListenElement e) {
		if (this.getNext() == null) {
			this.setNext(e);
		} else {
			this.getNext().addElement(e);
		}
	}
	
	// ab hier getter und setter Methoden fuer die Attribute info und next
	public int getInfo(){
	return info;
	}
	public void setInfo(int input){
	info = input;
	}
	public ListenElement getNext(){
	return next;
	}
	public void setNext(ListenElement toBeConnected){
	next = toBeConnected;
	}
	
	public static void main(String[] args) {
//		ListenElement elem1 = new ListenElement();
//		ListenElement elem2 = new ListenElement();
//		ListenElement elem3 = new ListenElement();
//		ListenElement elem4 = new ListenElement();
		
		ListenElement elem4 = new ListenElement(4, null);
		ListenElement elem3 = new ListenElement(3, elem4);
		ListenElement elem2 = new ListenElement(2, elem3);
		ListenElement elem1 = new ListenElement(1, elem2);
		
//		elem1.setInfo(1);
//		elem2.setInfo(2);
//		elem3.setInfo(3);
//		elem4.setInfo(4);
//		
//		elem1.setNext(elem2);
//		elem2.setNext(elem3);
//		elem3.setNext(elem4);
		
		System.out.println("Die Liste ist folgendermaßen aufgebaut:");
		System.out.println("["+elem1.getInfo()+"]"
				+ "["+elem1.getNext().getInfo()+"]"
				+ "["+elem1.getNext().getNext().getInfo()+"]"
				+ "["+elem1.getNext().getNext().getNext().getInfo()+"]");
		
		System.out.println("Die Elemente der Liste (bis auf das letzte Element):");
		elem1.getButLastInfo();
		elem1.deleteLastElement();
		System.out.println("Das letzte Element wurde jetzt gelöscht:");
		elem1.getButLastInfo();
		System.out.println("Das letzte Element wurde wieder hinzugefügt:");
		elem1.addElement(elem4);
		elem1.getButLastInfo();
	}
	
}
