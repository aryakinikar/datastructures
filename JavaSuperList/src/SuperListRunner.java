import java.lang.Math;   
public class SuperListRunner 
{

	public static void main(String[] args) 
	{
		// Filling list with random integers and displaying toString
		SuperList<Integer> randomList = new SuperList<Integer>();
		for(int i=0; i<30; i++)
		{
			randomList.add((int)(Math.random()*(1000)+1));
		}
		System.out.println("ArrayList--> "+randomList.toString());
		System.out.println("Size: "+randomList.size());
		
		//Creating new list functioning like a stack
		SuperList<Integer> stackList = new SuperList<Integer>();
		while(randomList.size()!=0)
			stackList.push(randomList.remove(0));
		
		//Displaying Stack and storing in queue
		System.out.println("Stack--> "+stackList.toString());
		SuperList<Integer> queueList = new SuperList<Integer>();
		while(stackList.size()!=0)
			queueList.add(stackList.pop()); 
		
		//Displaying queue and store back in original in random positions
		System.out.println("Queue--> "+queueList.toString());
		while(queueList.size()!=0)
		{
			if(randomList.size()==0)
				randomList.add(queueList.poll());
			else
				randomList.add(((int)(Math.random()*(randomList.size()-1))), queueList.poll());
		}
		System.out.println("New random ArrayList--> "+randomList.toString());
		System.out.println();
		
		//Calculate sum of arrayList
		int sum =0;
		for(int i=0; i<randomList.size(); i++)
		{
			sum+= randomList.get(i);
		}
		System.out.println("Sum: "+sum);
		
		//Calculate sum of even indexes
		sum=0;
		for(int i=0; i<randomList.size(); i+=2)
		{
			sum+= randomList.get(i);
		}
		System.out.println("Sum of even index elements: "+sum);
		
		//Calculate sum of odd indexes
		sum=0;
		for(int i=1; i<randomList.size(); i+=2)
		{
			sum+= randomList.get(i);
		}
		System.out.println("Sum of odd index elements: "+sum);	
		System.out.println();
		
		//Create duplicates of all even index values and add them to the end
		int startSize = randomList.size();
		for(int i=0; i<startSize; i+=2)
		{
			int val = randomList.get(i);
			randomList.add(val);
		}		
		System.out.println("ArrayList with duplicates of even indexes--> "+randomList.toString()); //WAS I SUPPOSED TO ADD TO THE END LIKE THAT
		
		//Remove all instances of values that are divisible by 3
		for(int i=randomList.size()-1; i>=0; i--)
			if(randomList.get(i)%3 == 0)
				randomList.remove(i);
		System.out.println("ArrayList with removed multiples of 3--> "+randomList.toString());
		
		//Insert the value 55555 into the 4th position in the SuperList
		if(randomList.size()>=4)
			randomList.add(3, 5555);
		System.out.println("ArrayList with 5555 in 4th position--> "+randomList.toString());
		
		//Sort list in descending order
		for(int i=0; i<randomList.size(); i++)
		{
			int j=0;
			Boolean greater = false;
			while(j<randomList.size()&&greater==false)
			{
				if(randomList.get(i)>randomList.get(j))
				{
					randomList.add(j, randomList.remove(i));
					greater = true;
				}
				j++;
			}
			
		}
		
		//insertionSortInt(randomList);
		System.out.println("ArrayList sorted in descending order--> "+randomList.toString()); //ISSUE WITH REMOVE ITSELF OR JUST RUNNER?
		
		//Search through your SuperList to find the “median” value. Identify that value and list the values that fall before and after the “median”
		int median;
		int beforeMedian;
		int afterMedian;
		
		if(randomList.size()%2==0)
		{
			median = (randomList.get((randomList.size()/2)-1)+ randomList.get((randomList.size()/2)-1)-1)/2;
			beforeMedian = randomList.get((randomList.size()/2)-1);
			afterMedian = randomList.get(randomList.size()/2);
		}
		else
		{
			median = randomList.get((randomList.size()/2));
			beforeMedian = randomList.get((randomList.size()/2)-1);
			afterMedian = randomList.get((randomList.size()/2)+1);
		}
		System.out.println("Median: "+median+". Before: "+beforeMedian+". After: "+afterMedian+"."); //SHOULD MEDIAN VALUES BE IN DOUBLES?
		System.out.println();
		System.out.println();
		
		
		//--------------------------------------------------------------------------------------------------------------------------------------//
		//Store sentence in String and store each word into a SuperList
		SuperList<String> strList = new SuperList<String>();
		String sent = "This is the sentence that I am going to use to test out my SuperList.";
		sent = sent.replace(".", "");
		String[] sentArray = sent.split(" ");
		String s;
		for(int i=0; i<sentArray.length; i++)
		{
			strList.add(sentArray[i]);
		}
		System.out.println(strList.toString());

		//Remove each word that is less than or equal to 3 characters
		for(int i=0; i<strList.size(); i++)
		{
			s = strList.get(i);
			if(s.length()<=3)
			{
				strList.remove(i);
				i--;
			}
		
		}
		System.out.println(strList.toString());
		
		//Use insertion sort to sort words in ascending order by length
		insertionSort(strList);
		System.out.println(strList.toString());
	}

	   public static void insertionSort(SuperList<String> strList) 
	   {  
	        int n = strList.size();  
	        for (int j = 1; j < n; j++) 
	        {  
	            int key = strList.get(j).length();  
	            String keyString = strList.get(j);
	            int i = j-1;  
	            while ( (i > -1) && ( strList.get(i).length() > key ) ) 
	            {  
	            	strList.set(i+1, strList.get(i));       
	                i--;  
	            }  
	            strList.set(i+1, keyString);
	        }  
	    } 
	   
	   public static void insertionSortInt(SuperList<Integer> array) {
		    for (int j = 1; j < array.size(); j++) {
		        int current = array.get(j);
		        int i = j-1;
		        while ((i > -1) && (array.get(i) > current)) {
		        	array.set(i+1, array.remove(i));
		            i--;
		        }
		        array.set(i+1, current);
		    }
		}
}
