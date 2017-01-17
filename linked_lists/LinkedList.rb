# create node with its relevant and accessible values
class Node
  attr_accessor :num, :next

  def initialize(number)
    @num = number
    @next = nil
  end
end

# linkedList class
class LinkedList
  attr_accessor :front
  attr_reader :size

  def initialize
    @front = nil
    @size = 0
  end

  #add the inputted value as a node to the front
  #consider changing it so it create the node objects in the method itself
  def add_front(input_node)
    input_node.next = @front #create node here instead
    @front = input_node
    @size += 1
  end

  #returns the node with the inputted value
  def find(number)
    current_node = @front
    while (current_node.next != nil)
      if (current_node.num == number)
        return current_node
      else
        current_node = current_node.next 
      end
    end
    puts "Could not find node"
    return nil
  end

  #removes the node with the inputted value
  def remove(number)
    current_node = @front
    prev_node = @front

    while (current_node.next != nil)
      if (current_node == @front)
        if (current_node.num == number)
          @front == current_node.next
          @size -= 1
          return current_node
        else
          current_node = current_node.next
        end
      end
      if (current_node.num == number)
        prev_node.next = current_node.next
        @size -= 1
        return current_node
      else
        prev_node = current_node
        current_node = current_node.next
      end
    end
    puts "Could not find node"
    return nil
  end

  #simple formatted display for entire linked list
  #this algorithm for display was having issues, not sure what it was
  def display
    current_node = @front
    puts @size
    puts "{"
    puts current_node.num
    while (current_node.next != nil)
      current_node = current_node.next
      puts current_node.num
    end
    puts "}"
  end

  #outputs all nodes in more readable format, and is accurate
  def display_2
    puts "I have " + @front.num.to_s
    if (@front.next != nil)
      display_2_1(@front.next)
    end
  end

  def display_2_1(node)
    if node != nil
      puts "which is in front of " + node.num.to_s
    end
    if node.next != nil
      display_2_1(node.next)
    end
  end
end

#runner code
test_ll = LinkedList.new
nodes = [
  node_1 = Node.new(80),
  node_2 = Node.new(85),
  node_2 = Node.new(90)
]

nodes.each do |node|
  puts node.num
  test_ll.add_front(node)
  test_ll.display
end

test_ll.display
# test_ll.display_2
# puts "{" + test_ll.find(85).num.to_s + "}"
# puts test_ll.find(95)
# test_ll.remove(85)
# test_ll.display_2