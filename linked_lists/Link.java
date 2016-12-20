//attrs: bookName, millionsSold
//funcs: insertFirstLink, removeFirst, find, remove

public class Link {

  // data stored in each link
  public String bookName;
  public int millionsSold;

  //pointer
  public Link next;
  
  //initializer
  public Link(String bookName, int millionsSold){
    this.bookName = bookName;
    this.millionsSold = millionsSold;
  }
  
  //convenient print func for each link
  public void display() {
    System.out.println(bookName + ": " + millionsSold + ",000,000");
  }

  //gives bookname
  public String toString() {
    return bookName;
  }

  //runner
  public static void main(String[] args) {
    LinkList theLinkedList = new LinkList();

    theLinkedList.insertFirstLink("Don Quixote", 500);
    theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
    theLinkedList.insertFirstLink("The Lord of the Rings", 150);
    theLinkedList.insertFirstLink("Harry Potter", 107);

    theLinkedList.display();

    theLinkedList.removeFirst();
    
    theLinkedList.display();

    System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");

    theLinkedList.removeLink("The Lord of the Rings");
    
    theLinkedList.display();
  }
}

//actual list

class LinkList {
  //attribute for pointer to firstlink (not quite sentinel);
  public Link firstLink;


  //initilizer;
  LinkList() {
    firstLink = null;
  }

  //func to check if list is empty
  public boolean isEmpty() {
    return(firstLink == null);
  }

  // insert new link into first position
  public void insertFirstLink(String bookName, int millionsSold) {
    Link newLink = new Link(bookName, millionsSold);

    //assign previous link as the next for the new first link
    newLink.next = firstLink;

    firstLink = newLink;
  }

  // remove first link
  public Link removeFirst() {
    Link linkReference = firstLink;

    if(!isEmpty()) {
      firstLink = firstLink.next;
    } else {
      System.out.println("Empty LinkedList");
    }
    return linkReference;
  }

  //show all the links
  public void display() {
    Link theLink = firstLink;

    while (theLink != null) {
      theLink.display();
      System.out.println("Next Link: " + theLink.next);
      theLink = theLink.next;
      System.out.println();
    }
  }

  //find a specific link by book name
  public Link find(String bookName) {
    Link theLink = firstLink;

    if(!isEmpty()) {
      while (theLink.bookName != bookName) {
        if (theLink.next == null) {
          return null;
        } else {
          theLink = theLink.next;
        }
      }
    } else {
      System.out.println("Empty LinkedList");
    }
    return theLink;
  }

  //remove a specific link by book name
  public Link removeLink(String bookName) {
    Link currentLink = firstLink;
    Link previousLink = firstLink;

    while(currentLink.bookName != bookName) {
      if(currentLink.next == null) {
        return null;
      } else {
        previousLink = currentLink;
        currentLink = currentLink.next;
      }
    }
    if (currentLink == firstLink) {
      firstLink = firstLink.next;
    } else {
      previousLink.next = currentLink.next;
    }
    return currentLink;
  }
}