class HashTable
  attr_reader :size, :table, :item_count

  def initialize(size)
    @size = size
    @table = Array.new(@size)
    @item_count = 0
  end

  def hash_function(input)
    key = (input[0].downcase.ord) % @size
    linear_add(key, input)
  end

  def linear_add(key, input)
    if (@table[key] == nil)
      @table[key] = input
      @item_count += 1
      return @table
    else
      if (key >= size - 1)
        linear_add(0, input)
      else
        linear_add(key + 1, input)
      end
    end
  end

  def find(input)
    key = (input[0].downcase.ord) % @size

    while (@table[key] != nil)
      if (@table[key] == input)
        puts "Found #{input} at #{key}"
        return input
      else
        if (key >= @size - 1)
          key = 0
        else
          key += 1
        end
      end
    end
    puts "Couldn't find #{input}"
    return nil
  end
end

test_ht = HashTable.new(30)

input_array = ["Billy", "bob", "Thornton", "zamboni", "kraken", "Frank", "Zappa", "revan", "Star"]

input_array.each do |word|
  test_ht.hash_function(word)
end

test_ht.table.each_with_index do |item, i|
  puts "(#{i}, #{item})"
end

test_ht.find("Star")
test_ht.find("billy")