package model;
public class CircularlyDoubleLinkedList {

    private Node head;
    private Node tail;

    public void addNode() {
        Node node = new Node();
        if (head == null) {
            head = node;
            head.setData(1);
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            node.setData(tail.getData() + 1);
        }
        tail = node;
        tail.setNext(head);
    }

    public void exchangeNodePositions(Node node1, Node node2) {
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    public void isSkippedTwice(Node node) {
        if (node.getTimesSkipped() == 2) 
            deleteNode(node);
    }

    public void deleteNode(Node node) {
        if (node == head) {
            head = head.getNext();
            tail.setNext(head);
        } else if (node == tail) {
            tail = tail.getPrev();
            tail.setNext(head);
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
