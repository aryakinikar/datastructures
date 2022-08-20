import java.util.EmptyStackException;

public class SuperList<E> 
{
	//Initializing variables
	private ListNode<E> root;
	private ListNode<E> end;
	private int size;

	//Empty constructor
	public SuperList()
	{
		
	}
	
		//Adds at the end of the list; O(1) efficiency
	   public void add(E n) 
	   {
	        ListNode < E > node = new ListNode <E > (n,null,null);
	        if (root == null) 
	        {
	            root = node;
	            end = node;
	        } else 
	        {
	            end.setNext(node);
	            node.setPrev(end);
	            end = node;
	        }
	        size++;
	    }
	
	   //Adds at a certain index in the list; O(n) efficiency
	   public void add(int index, E n) 
	   {
	        if (index > size || index < 0)
	            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
	        if (index == 0) 
	        {
	            ListNode<E> a = new ListNode<E> (n,null,null);
	            if (root == null) 
	            {
	                root = a;
	                end = a;
	            } else 
	            {
	                root.setPrev(a);
	                a.setNext(root);
	                root = a;
	            }
	        } else if (index == size) 
	        {
	            add(n);
	        } else 
	        {
	            ListNode < E > temp = root;
	            for (int i = 0; i < index - 1; i++)
	                temp = temp.getNext();
	            ListNode < E > node = new ListNode < > (n,null,null);
	            ListNode < E > next = temp.getNext();
	            node.setNext(next);
	            node.setPrev(temp);
	            temp.setNext(node);
	            next.setPrev(node);
	        }
	        size++;
	    }	
	   
	   //Pushes a value onto the end of the list
	   public void push(E val)
	   {
		   add(val);
	   }
	   
	   //Pops a value from the end of the list and returns it
	   public E pop()
	   {
		   if(size==0|| root==null||end==null)
			   throw new EmptyStackException();
	       if (size == 1) 
	       {
	    	   ListNode < E > temp = end;
	            root = null;
	            end = null;
	            size--;
	            return temp.getValue();
	       }
		   else
		   {
			   ListNode < E > temp = end;
			   end = end.getPrev();
			   end.setNext(null);
			   size--;
			   return temp.getValue();
		   }
	   }
	   
	   //Removes a value from beginning of the list and returns it
	   public E poll()
	   {
		   if(size==0|| root==null||end==null)
			   throw new EmptyStackException();
	       if (size == 1) 
	       {
	    	   ListNode < E > temp = root;
	            root = null;
	            end = null;
	            size--;
	            return temp.getValue();
	       }
		   else
		   {
			   ListNode < E > temp = root;
			   root = root.getNext();
			   root.setPrev(null);
			   size--;
			   return temp.getValue();
		   }		   
	   }
	   
	   //Allows us to "peek" at the end of the stack
	   public E stackPeek()
	   {
		   if(size==0|| root==null||end==null)
			   throw new EmptyStackException();
		   return end.getValue();
	   }
	   
	   //Allows us to "peek" at the beginning of the queue
	   public E queuePeek()
	   {
		   if(size==0|| root==null||end==null)
			   throw new EmptyStackException();
		   return root.getValue();
	   }
	   
	   //returns the value at a certain index
	   public E get(int index)
	   {
		   	if(index>=size ||index<0)
		   		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		   	/*if(index==size-1)
		   		return end.getValue();
		   	if(index==0)
		   		return root.getValue();*/	   
		   		ListNode < E > temp = root;
		   		for(int i=0; i<index; i++)
		   			temp = temp.getNext();
		   		return temp.getValue();
		   			
		   		
	   }
	   
	   //Sets a value at a certain index to a new value
	   public E set(int index, E val)
	   {
		   	E oldVal;
		   	ListNode < E > newNode = new ListNode<E> (val, null,null);
		   	if(index>=size ||index<0)
		   		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		   	if(index==size-1)
		   	{
		   		oldVal = end.getValue();
		   		newNode.setPrev(end.getPrev());
		   		end = newNode;
		   		return oldVal;
		   	}
		   	if(index==0)
		   	{
		   		oldVal = root.getValue();
		   		newNode.setNext(root.getNext());
		   		root = newNode;
		   		return oldVal;	   		
		   	}
		   		
		   	else
		   	{
		   		ListNode < E > temp = root;
		   		for(int i=0; i<index; i++)
		   			temp = temp.getNext();
		   		oldVal = temp.getValue();
		   		ListNode < E > next = temp.getNext();
		   		ListNode < E > prev = temp.getPrev();
		   		newNode.setNext(next);
		   		newNode.setPrev(prev);
		   		next.setPrev(newNode);
		   		prev.setNext(newNode);
		   		return oldVal;
		   			
		   	}
		   				   
	   }
	   
	   //Returns the size of the list
	   public int size()
	   {
		   return size;
	   }
	   
	   //Removes an element from a certain index of the list and returns it
	   public E remove(int index) {
	        if (index >= size || index < 0)
	            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
	        if (index == 0) {
	            return poll();

	        }
	        if (index == size - 1) {
	            return pop();
	        }
	        ListNode < E > temp = root; // temp is value we are removing
	        for (int i = 0; i < index - 1; i++)
	            temp = temp.getNext();
	        ListNode < E > prev = temp;
	        temp = temp.getNext();
	        ListNode < E > next = temp.getNext();
	        prev.setNext(next);
	        next.setPrev(prev);
	        size--;
	        return temp.getValue();
	    }
	   
	   //Returns true if list is empty; false if it isn't
	   public boolean isEmpty()
	   {
		   return (size==0);
	   }
	   
	   //Clears the list and removes all of its elements
	    public void clear() 
	    {
	    	size = 0;
	        root = null;
	        end = null;
	    }
	    
	    //Returns true if the list "contains" a certain node; false if it doesn't
	    public boolean contains(ListNode<E> node)
	    {
	    	if(size==0|| root==null||end==null)
	    		throw new EmptyStackException();
	    	ListNode<E> prev = node.getPrev();
	    	ListNode<E> next = node.getNext();
	    	E val = node.getValue();
	    	ListNode<E> temp = root;
	    	for(int i=0; i<size; i++)
	    	{
	    		if(temp.getValue()==val && temp.getPrev()==prev && temp.getNext()==next)
	    			return true;
	    		temp = temp.getNext();
	    	}
	    	return false;
	    		
	    }
	    
	    //Returns the list as a String in the [ , ,...] format
	    public String toString() 
	    {
	        String s = "[";
	        ListNode < E > temp = root;
	        for(int i=0; i<size; i++)
	        {
	        	if(i==size-1)
	        		s+= temp.getValue() + "]";
	        	else
	        		s+= temp.getValue() + ", ";
	        	temp = temp.getNext();
	        }
	        return s;
	    }	    
}
