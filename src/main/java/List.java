import java.util.NoSuchElementException;

public class List <E> {
    private int size;
    private Node<E> head;
    public List(){
        this.size = 0;
        this.head = null;
    }
    public int getSize(){// returns the size of the list
        return this.size;
    }
    public void clear(){//clears the list
        this.size = 0;
        this.head = null;
    }
    public void push(E data){//Adds items
        Node<E> current = getTail();
        if(current == null){
            this.head = new Node<E>(data , null);
        }
        else{
            current.setNext(new Node<E>(data , null));
        }
        this.size++;
    }
    public boolean has(E data){//checks if the item exists
        Node<E> current = this.head;
        if(current != null){
            do{
                if (current.getData().equals(data)){
                    return true;
                }
            } while((current = current.getNext()) != null);
        }
        return false;
    }
    public E elementAt(int index){//Get element by index
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node <E> current= this.head;
            for(int i=0; i<index;i++){
                current=current.getNext();
            }
            return current.getData();
        }
    }
    public int indexOf(E data){//returns the index of the object
        Node <E> current = this.head;
        if(current == null){
            throw new NoSuchElementException("The list is Empty");
        }
        int counter=0;
        do{

            if(current.getData().equals(data)){
                return counter;
            }
            else{
                counter++;
            }
        }while((current = current.getNext()) != null);
        throw new NoSuchElementException("The list does not contain the element");
    }
    public void removeAt(int index){//removes an element by its index

        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        else{
            if(index == 0){
                this.head=this.head.getNext();
            }
            else{
                Node <E> current= this.head;
                for(int i=0; i<index-1;i++){
                    current=current.getNext();
                }
                if(current.getNext()!=null)
                    current.setNext((current.getNext()).getNext());
                else
                    current.setNext(null);
            }
            this.size--;
        }
    }
    private Node<E> getTail(){
        if(size == 0){
            return null;
        }
        Node<E> current = this.head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current;
    }
    public String toString(){
        String result="[";
        Node <E> current=head;
        for(int i=0; i < this.size; i++){
            if(i==this.size-1){
                result+=current.getData().toString();
            }
            else{
                result+=current.getData().toString()+", ";
            }
            current=current.getNext();
        }
        result+="]";
        return result;
    }




}

class Node <E> {
    private E data;
    private Node next;
    public Node(E data, Node next){
        this.data = data;
        this.next = next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
