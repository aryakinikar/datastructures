

public class ListNode<E>
	{
	//Initializing variables
		private E value;
		private ListNode<E> next, prev;

		//Constructor to declare value, next and previous
		public ListNode(E value, ListNode<E> next, ListNode<E> prev)
		{
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		//returns the value
		public E getValue()
		{
			return value;
		}

		//sets the next element
		public void setNext(ListNode<E> next)
		{
			this.next = next;
		}

		//returns the previous element
		public ListNode<E> getPrev()
		{
			return prev;
		}
		
		//returns the next element
		public ListNode<E> getNext()
		{
				return next;
		}

		//sets the previous element
		public void setPrev(ListNode<E> prev)
		{
			this.prev = prev;
		}

		//returns true if the next element exists; false if it doesn't
		public boolean hasNext()
		{
			return next!= null;
		}
		
		//returns true if the previous element exists; false if it doesn't
		public boolean hasPrevious()
		{
				return prev!= null;
		}
	}
