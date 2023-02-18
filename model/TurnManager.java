package model;
public class TurnManager {

    private final CircularlyDoubleLinkedList list = new CircularlyDoubleLinkedList();
    private Node currentNode = list.getHead();

    public boolean isListEmpty() {
        return list.getHead() == null;
    }

    public boolean isNextTurnNull() {
        if(list.isHeadEqualTail()){
            return true;
        } else {
            return currentNode == null;
        }
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

    public void deleteTurn() {
        list.deleteNode(currentNode);
    }

    public void skipTurn() {
        currentNode.setTimesSkipped();
        if(list.isSkippedTwice(currentNode)) {
            deleteTurn();
        } else {
            list.exchangeNodePositions(currentNode, currentNode.getNext());
        }
    }

    public int displayTurn() {
        return currentNode.getData();
    }

}
