import java.util.Arrays;

class TheStack {
  String[] stackArray;
  int stackSize;
  int topOfStack = -1;

  TheStack(int size) {
    stackSize = size;
    stackArray = new String[stackSize];
    Arrays.fill(stackArray, "-1");
  }

  //put elements on top of the stack
  public void push(String input) {
    // check that the stack isn't full first
    if (topOfStack + 1 < stackSize) {
      //increment topOfStack
      topOfStack++;
      //put in input into stack
      stackArray[topOfStack] = input;
      System.out.println("Pushed " + input + " into index " + topOfStack);
    } else {
      //stack is full, cannot push
      System.out.println("Stack is full, cannot input");
    }
  }


  public String pop() {
    //check if stack isn't empty
    if (topOfStack >= 0) {
      System.out.println("Popped " + stackArray[topOfStack] + " from index " + topOfStack);
      //set top of stack element to default empty value, in this case -1
      stackArray[topOfStack] = "-1";
      //deincrement topOfStack down by 1
      topOfStack--;
      //return the new top of stack element
      return stackArray[topOfStack];
    } else {
      //stack is empty, cannot pop
      System.out.println("Stack is empty, cannot remove");
    }
  }

  public String peek() {
    System.out.println(stackArray[topOfStack] + " is at the top of the stack.");
    return stackArray[topOfStack];
  }

  public static void main(String[] args) {
    testStack = new TheStack(10);
    testStack = 
  }
}