package quicksort;

import java.util.UUID;

class ArrayIns
{
private String[] theArray;          
private int nElems;               
//--------------------------------------------------------------
public ArrayIns(int max)          
   {
   theArray = new String[max];     
   nElems = 0;                    
   }
//--------------------------------------------------------------
public void insert(String value)    
   {
   theArray[nElems] = value;      
   nElems++;                      
   }
//--------------------------------------------------------------
public void display()            
   {
   System.out.print("A=");
   for(int j=0; j<nElems; j++)    
      System.out.println(theArray[j] + " "); 
   System.out.println("");
   }
//--------------------------------------------------------------
public void quickSort()
   {
   recQuickSort(0, nElems-1);
   }
//--------------------------------------------------------------
public void recQuickSort(int left, int right)
   {
   if(right-left <= 0)             
       return;                      
   else                             
      {
      String pivot = theArray[right];      
                                    
      int partition = partitionIt(left, right, pivot);
      recQuickSort(left, partition-1);   
      recQuickSort(partition+1, right);  
      }
   }  
//--------------------------------------------------------------
 public int partitionIt(int left, int right, String pivot)
    {
    int leftPtr = left-1;           
    int rightPtr = right;           
    while(true)
       {                           
       while( theArray[++leftPtr].compareTo(pivot)<0 )
          ;  
                                    
       while(rightPtr > 0 && theArray[--rightPtr].compareTo(pivot)>0)
          ;  

       if(leftPtr >= rightPtr)      
          break;                   
       else                         
          swap(leftPtr, rightPtr); 
       }  // end while(true)
    swap(leftPtr, right);           
    return leftPtr;                 
    }  
//--------------------------------------------------------------
public void swap(int dex1, int dex2)  
   {
   String temp = theArray[dex1];        
   theArray[dex1] = theArray[dex2];   
   theArray[dex2] = temp;            
   } 
//--------------------------------------------------------------

} 

class QuickSort1
{
public static void main(String[] args)
   {
    long start = System.currentTimeMillis();;
    
   int maxSize = 1024000;            
   ArrayIns arr;
   arr = new ArrayIns(maxSize);  

   for(int j=0; j<maxSize; j++)  
      {                          
	   String id = UUID.randomUUID().toString();
       arr.insert(id);
      }
   arr.display();                
   arr.quickSort();  
   System.out.println("After sorting:-------------------------------------------------");
   arr.display();         
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   } 
} 

