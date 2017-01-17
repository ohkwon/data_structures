import java.util.Arrays;

class TheStack {
  String[] stackArray;
  int stackSize;
  int topOfStack = -1;

  TheStack(int size) {
    stackSize = size;
    stackArray = new String[stackSize];
  }

  //put elements on top of the stack
  public void push(String input) {
    // check that the stack isn't full first
    if (topOfStack + 1 < stackSize) {
      topOfStack++;
      stackArray[topOfStack] = input;
      System.out.println("Pushed " + input + " into index " + topOfStack);
    } else {
      System.out.println("Stack is full, cannot input");
    }
  }

  public static void main(String[] args) {

  }
}