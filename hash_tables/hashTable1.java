class HashTable1 {
  String[] table;
  int arraySize;
  int itemCount = 0;

  public static void main(String[] args) {
    HashTable1 test = new HashTable1(30);
    String[] input = {"1", "8", "15", "19", "26"};
    test.hashFunction(input, test.table);
    for (int i = 0; i < test.table.length; i ++) {
      System.out.println(test.table[i]);
    }

  }

  public void hashFunction(String[] inputArray, String[] table) {
    for (int i = 0; i < inputArray.length; i ++) {
      String addElement = inputArray[i];
      table[Integer.parseInt(addElement)] = addElement;
    }
  }

  public HashTable1(int size) {
    arraySize = size;
    table = new String[size];
  }
}