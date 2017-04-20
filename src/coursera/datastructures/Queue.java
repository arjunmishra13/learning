package coursera.datastructures;

class Queue {
	
	//Implement fixed size queue using arrays

	int[] queue;
    int numberOfElements;
    int beginIndex;

    public Queue(int size) {
        queue = new int[size];
        numberOfElements = 0;
        beginIndex = 0;
    }
    
    void enqueue(int val) throws Exception {
        
        if(numberOfElements >= queue.length) {
            throw new Exception("No Space in Queue");   
        }
        //Adds new element to the list in the front
        int endIndex = (beginIndex + numberOfElements)%queue.length;
        queue[endIndex] = val;
        numberOfElements++;
    }
    
    int dequeue() throws Exception{
        
        if(numberOfElements <= 0) {
            throw new Exception("Empty Queue");
        }
        //Retrieve the first added value
        int retVal = queue[beginIndex];
        beginIndex = (beginIndex + 1)%queue.length;
        numberOfElements--;
        
        return retVal;
    }
    
    public static void main(String[] args) throws Exception {

        int size = 3;
        Queue queue = new Queue(size);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        try{
        	queue.enqueue(4);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        
        try{
        	System.out.println(queue.dequeue());
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        
        try{
        	System.out.println(queue.dequeue());
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
    }
}

