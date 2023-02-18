package model;
public class TurnManager {

    private CircularlyDoubleLinkedList list = new CircularlyDoubleLinkedList();
    private Node currentNode;

    public TurnManager() {
        currentNode = list.getHead();
    }

    public void addTurn() {
        if (list.getHead() == null) {
            list.addNode();
            currentNode = list.getHead();
        } else
            list.addNode();
    }

    public void nextTurn() {
        currentNode = currentNode.getNext();
    }

    public void skipTurn() {
        currentNode.setTimesSkipped();
        list.exchangeNodePositions(currentNode, currentNode.getNext());
    }

    public int displayTurn() {
        return currentNode.getData();
    }

}
