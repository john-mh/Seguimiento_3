package model;
public class Node {

    private Node previous;
    private Node next;
    private int data = 0;
    private int timesSkipped = 0;

    public Node getPrev() {
        return previous;
    }

    public int getTimesSkipped() {
        return timesSkipped;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
    public void setNext(Node node) {
        this.next = node;
    }

    public void setPrev(Node node) {
        this.previous = node;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setTimesSkipped() {
        timesSkipped++;
    }
    
}
