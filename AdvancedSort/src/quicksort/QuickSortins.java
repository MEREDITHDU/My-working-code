package quicksort;

import java.util.UUID;

class ArrayIns3
{
private String[] theArray;          
private int nElems;              
//--------------------------------------------------------------
public ArrayIns3(int max)         
   {
   theArray = new String[max];      
   nElems = 0;                    
   }
//--------------------------------------------------------------
public void insert(String s)    
   {
   theArray[nElems] = s;      
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
public void quickSort3()
   {
   recQuickSort(0, nElems-1);
   
   }
//--------------------------------------------------------------
public void recQuickSort(int left, int right)
   {
   int size = right-left+1;
   if(size < 10)                  
      insertionSort(left, right);
   else                            
      {
      String median = medianOf3(left, right);
      int partition = partitionIt(left, right, median);
      recQuickSort(left, partition-1);
      recQuickSort(partition+1, right);
      }
   }  // end recQuickSort()
//--------------------------------------------------------------
public String medianOf3(int left, int right)
   {
   int center = (left+right)/2;
                                   
   if( theArray[left].compareTo(theArray[center])>0 )
      swap(left, center);
                                    
   if( theArray[left].compareTo(theArray[right])>0 )
      swap(left, right);
                                    
   if( theArray[center].compareTo(theArray[right])>0 )
      swap(center, right);

   swap(center, right-1);           
   return theArray[right-1];        
   } 
//--------------------------------------------------------------
public void swap(int dex1, int dex2)  
   {
   String temp = theArray[dex1];        
   theArray[dex1] = theArray[dex2];   
   theArray[dex2] = temp;             
   } 
//--------------------------------------------------------------
 public int partitionIt(int left, int right, String pivot)
    {
    int leftPtr = left;             
    int rightPtr = right - 1;       
    while(true)
       {
       while( theArray[++leftPtr].compareTo(pivot)<0 )  
          ;                                  
       while( theArray[--rightPtr].compareTo(pivot)>0 ) 
          ;                                 
       if(leftPtr >= rightPtr)      
          break;                   
       else                         
          swap(leftPtr, rightPtr);  
       } 
    swap(leftPtr, right-1);         
    return leftPtr;               
    }  
//--------------------------------------------------------------
                                   
public void insertionSort(int left, int right)
   {
   int in, out;
                                    
   for(out=left+1; out<=right; out++)
      {
      String temp = theArray[out];    
      in = out;                    
                                    
      while(in>left && theArray[in-1].compareTo(temp)>=0)
         {
         theArray[in] = theArray[in-1];
         --in;                      
         }
      theArray[in] = temp;         
      } 
   } 
//--------------------------------------------------------------
} 
////////////////////////////////////////////////////////////////
class QuickSortins
{
public static void main(String[] args)
   {
    long start = System.currentTimeMillis();;
	
   int maxSize = 1024000;             
   ArrayIns3 arr;                 
   arr = new ArrayIns3(maxSize);  

   for(int j=0; j<maxSize; j++)  
      {                          
	   String id = UUID.randomUUID().toString();
       arr.insert(id);
      }
   arr.display();                
   arr.quickSort3();       
   System.out.println("After sorting:-------------------------------------------------");
   arr.display();      
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   }  
}  
