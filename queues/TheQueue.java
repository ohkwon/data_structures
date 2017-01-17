import java.util.Arrays;

class TheQueue {
  String[] queueArray;
  int queueSize;
  int front, rear, itemCount = 0;

  TheQueue(int size) {
    queueSize = size;
    queueArray = new String[queueSize];
    //fill array with default empty value, in this case, "-1"
    Arrays.fill(queueArray, "-1");
  }

  // insert item into the queue
  public void insert(String input) {
    //check if queue is not full
    if (rear + 1 < queueSize) {
      //input at rear, to the end of the queue
      queueArray[rear] = input;
      System.out.println("Inserted " + input + " into index " + rear);
      rear++;
      itemCount++;
    } else {
      System.out.println("Queue is full");
    }
  }

  public void remove() {
    //check if queue is not empty
    if (itemCount > 0) {
      System.out.println("Removed " + queueArray[front] + " from the front");
      //set front of queue to default empty value
      queueArray[front] = "-1";
      front++;
      itemCount--;
    } else {
      System.out.println("Queue is empty");
    }
  }

  public void peek() {
    System.out.println(queueArray[front] + " is at the front");
  }

  public String priorityInsert(String input) {
    int i;
    //check if queue is empty
    if (itemCount == 0) {
      insert(input);
    } else {
      for (i = rear; i >= front; i--) {
        if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
          if (i + 1 >= queueSize) {
            System.out.println("Queue is full");
            return null;
          } else {
            // shift over items in the array to the up by one, starting from the top to make room for the new input
            queueArray[i + 1] = queueArray[i];
            queueArray[i] = "-1";
          }
        } else break;
      }
      // space above current i should be empty (or "-1") so insert there
      queueArray[i + 1] = input;
      rear++;
      itemCount++;
      return input;
    }
    return null;
  }

  public void display() {
    System.out.print("(");
    for (int i = 0; i < queueSize; i++) {
      if (queueArray[i] != "-1") {
        System.out.print(queueArray[i]);
      } else {
        System.out.print(" ");
      }
      if (i != queueSize -1) {
        System.out.print(", ");
      }
    }
    System.out.println(")");
  }

  public static void main(String[] args) {
    TheQueue testQueue = new TheQueue(10);
    testQueue.insert("20");
    testQueue.display();
    testQueue.insert("15");
    testQueue.display();
    testQueue.peek();
    testQueue.insert("10");
    testQueue.display();
    testQueue.peek();
    testQueue.remove();
    testQueue.display();
    testQueue.priorityInsert("18");
    testQueue.display();
    testQueue.priorityInsert("12");
    testQueue.display();
    testQueue.priorityInsert("22");
    testQueue.display();
  }
}