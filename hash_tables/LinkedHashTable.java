class LinkedHashTable {
  public static void main(String[] args) {
    LinkedList firstLinkedList = new LinkedList();
    firstLinkedList.addFirst("NOPE");
    firstLinkedList.addFirst("bottom");
    firstLinkedList.addFirst("apple");
    firstLinkedList.display();
    System.out.println(firstLinkedList.findNode("apple").word);
    firstLinkedList.removeNode("bottom");
    firstLinkedList.display();

    HashTable testHashTable = new HashTable(30);
    String[] array = {"harris", "Ponco", "dinner", "patsy", "django"};
    testHashTable.hashFunction(array, testHashTable.table);
    testHashTable.display();

  }
}

class Node {
  public String word;
  public Node next;

  public Node(String word) {
    this.word = word;
  }
} 

class LinkedList {

  public Node firstNode;
  public int size;

  LinkedList() {
    firstNode = null;
  }

  public void display() {
    Node node = firstNode;
    while (node != null) {
      System.out.print(node.word + " ");
      node = node.next;
    }
  }

  public Node addFirst(String word) {
    Node newNode = new Node(word);

    newNode.next = firstNode;

    firstNode = newNode;

    size ++;

    return newNode;
  }

  public Node removeFirst() {
    Node referenceNode = firstNode;

    if (firstNode != null) {
      firstNode = firstNode.next;
    } else {
      System.out.println("Empty Linked List");
    }
    size --;
    return referenceNode;
  }

  public Node findNode(String word) {
    Node node = firstNode;

    if (firstNode != null) {
      while (node.word != word) {
        if (node.next == null) {
          System.out.println("Could not find word");
          return null;
        } else {
          node = node.next;
        }
      }
      return node;
    } else {
      System.out.println("Empty Linked List");
      return null;
    }
  }

  public Node removeNode(String word) {
    Node node = firstNode;
    Node prevNode = firstNode;
    while (node.word != word) {
      if (node.next != null) {
        prevNode = node;
        node = node.next;
      } else {
        return null;
      }
    }
    if (node == firstNode) {
      firstNode = firstNode.next;
    } else {
      prevNode.next = node.next;
    }
    size --;
    return node;
  }
}

class HashTable {
  public LinkedList[] table;
  public int arraySize;
  public int itemCount;

  public HashTable(int size) {
    arraySize = size;
    table = new LinkedList[size];
  }

  public void displayOld() {
    for (int i = 0; i < arraySize; i ++) {
      System.out.println("(" + table[i] + ", " + i + ")");
    }
  }

  public void display() {
    for (int i = 0; i < arraySize; i ++) {
      if (table[i] != null) {
        System.out.println("(" + i + ", " + table[i].size + ")");
        System.out.print("{");
        table[i].display();
        System.out.print("}");
      } else {
        System.out.println("(" + i + ")");
      }
      System.out.println(" ");
    }
  }

  public void hashFunction(String[] inputArray, LinkedList[] table) {
    for (int i = 0; i < inputArray.length; i ++) {
      String newWord = inputArray[i];
      int tableIndex = Character.getNumericValue(newWord.charAt(0)) % arraySize;
      // linearAdd(newWord, table, tableIndex);
      linkedListAdd(newWord, table, tableIndex);
    }
  }

  public void linkedListAdd(String input, LinkedList[] table, int index) {
    if (table[index] == null) {
      table[index] = new LinkedList();
    }
    table[index].addFirst(input);
  }

  public void linearAdd(String input, String[] table, int index) {
    if (table[index] != null) {
      if (index >= arraySize - 1) {
        linearAdd(input, table, 0);
      } else {
        linearAdd(input, table, index + 1); 
      }
    } else {
      table[index] = input;
    }
  }

  public String findKeyOld(String key, String[] table) {
    int tableIndex = Character.getNumericValue(key.charAt(0)) % arraySize;
    while (table[tableIndex] != null) {
      if (table[tableIndex] == key) {
        System.out.println("Found " + key + " at index" + tableIndex);
        return table[tableIndex];
      }
      if (tableIndex >= arraySize - 1) {
        tableIndex = 0;
      } else {
        tableIndex ++;
      }
    }
    return null;
  }

  public Node findNode(String word) {
    int tableIndex = Character.getNumericValue(word.charAt(0)) % arraySize;
    return table[tableIndex].findNode(word);
  }
}