class HashTable2 {
  String[] table;
  int arraySize;
  int itemCount;

  public static void main(String[] args) {
    HashTable2 test2 = new HashTable2(30);
    String[] array = {"1", "300", "69", "41", "50", "32", "62", "71", "101", "29", "59"};
    test2.hashFunction2(array, test2.table);
    for (int i = 0; i < test2.table.length; i ++) {
      System.out.println("(" + test2.table[i] + ", " + i + ")");
    }
    test2.findKey("300");
    test2.findKey("33");
  }

  public void hashFunction2(String[] inputArray, String[] table) {
    for (int i = 0; i < inputArray.length; i ++) {
      String newElement = inputArray[i];
      int tableIndex = Integer.parseInt(newElement) % arraySize;
      linearAdd(newElement, table, tableIndex);
    }
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

  public String findKey(String key) {
    int keyIndex = Integer.parseInt(key) % arraySize;
    while (table[keyIndex] != null) {
      if (table[keyIndex] == key) {
        System.out.println(key + " found at index " + keyIndex);
        return table[keyIndex];
      }
      if (keyIndex >= arraySize -1) {
        keyIndex = 0;
      } else {
        keyIndex ++;
      }
    }
    return null;
  }

  public HashTable2(int size) {
    arraySize = size;
    table = new String[size];
  }
}