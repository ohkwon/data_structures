# Hash Table
# - offers fast insertion and searching
# - limited in size because they're based on arrays
# - can be resized but should avoid this
# - hard to order

# Hash Tables use Hash Functions to get key values assigned to elements
# - hash functions calculate the best index (key value) to go into the array
# - index must be small enough for array size
# - must not overwrite other data in hash table

# hash functions job is to store values in an array with a limited size
# - it does it in a way that the array doesn't need to be searched to find it
# - it allows you to enter values in any order
# - it should be able to find them using a calculation instead of searching through the array

class HashTable
  attr_accessor :table, :itemCount
  attr_reader :array_size

  def initialize(size)
    @array_size = size
    @table = Array.new(size) # assume is an array of strings
    @itemCount = 0
  end

  # simple hash function that puts values in same index that matches its values
  def hash_function_1(input_array)
    # loop through the input array (of strings)
    input_array.each do |input|
      # get the key index, simple datatype conversion in this case
      key_index = input.to_i
      # assign input to table at index key_index
      @table[key_index] = input
      puts "Input #{input} at index #{key_index}"
    end
  end

  # hash function that utilizes modulus to fit items into the corresponding array_size
  # goal is to make array big enough to avoid collisions and small enough to not waste memory
  def hash_function_2(input_array)
    # loop through the input array (of strings)
    input_array.each do |input|
      # set new_input to current iteration
      new_input = input
      # Hash Function: set key_index to new_input (as int) modulus array_size
      key_index = new_input.to_i % @array_size
      # loop while table at index key_index isn't empty
      while (table[key_index] != nil)
        # increment key_index up by 1
        key_index += 1
        # set key_index to key_index modulus array_size
        key_index %= @array_size
      end
      # set table at index key_index to new_input
      @table[key_index] = new_input
    end
  end

  # returns value stored in the hash table at input key
  def find_key(key)
    # use hash function calculation to get the key_index
    key_index = key.to_i % @array_size
    # loop while table at index key_index isn't the default empty value
    while (@table[key_index] != nil)
      # if table at index key_index is the key, return the table at index key_index
      if (@table[key_index] == key)
        puts "Found #{key} at index #{key_index}"
        return @table[key_index]
      end
      # increment key_index up by 1
      key_index += 1
      # use hash function calculation to make sure key_index is not out of bounds
      key_index %= @array_size
    end
    # if at this point, there is no match, return nil
    puts "No match"
    return nil
  end

  def display_table
    print "["
    @table.each_with_index do |item, i|
      if (item != nil)
        print item
      else
        print " "
      end
      if (i + 1 != @array_size)
        print ", "
      end
    end
    puts "]"
  end
end

hash_table = HashTable.new(30)

input_array = ["1", "300", "69", "41", "50", "32", "62", "71", "101", "29", "59"]

hash_table.hash_function_2(input_array)

hash_table.display_table

hash_table.find_key("300")
hash_table.find_key("33")