
package newQuickSort;
class ArrayIns1000
   {
   private long[] theArray;          
   private int nElems;              
//--------------------------------------------------------------
   public ArrayIns1000(int max)      
      {
      theArray = new long[max];     
      nElems = 0;                
      }
//--------------------------------------------------------------
   public void insert(long value)    
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
         long pivot = theArray[right];      
                                            
         int partition = partitionIt(left, right, pivot);
         recQuickSort(left, partition-1);   
         recQuickSort(partition+1, right); 
         }
      } 
//--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot)
       {
       int leftPtr = left-1;       
       int rightPtr = right;        
       while(true)
          {                            
          while( theArray[++leftPtr] < pivot )
             ;  // (nop)
                                      
          while(rightPtr > 0 && theArray[--rightPtr] > pivot)
             ;  // (nop)

          if(leftPtr >= rightPtr)     
             break;                   
          else                        
             swap(leftPtr, rightPtr);  
          }  // end while(true)
       swap(leftPtr, right);           
       return leftPtr;                
       }  // end partitionIt()
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)
      {
      long temp = theArray[dex1];       
      theArray[dex1] = theArray[dex2];  
      theArray[dex2] = temp;           
      }  // end swap(
//--------------------------------------------------------------
   }  

class QuickSort1
   {
   public static void main(String[] args)
      {
	    long start = System.currentTimeMillis();;
	    
      int maxSize = 128000;             
      ArrayIns1000 arr;
      arr = new ArrayIns1000(maxSize); 
      
      for(int j=0; j<maxSize; j++) 
         {                          
         long n = (int)(java.lang.Math.random()*999);
         arr.insert(n);
         }
      arr.display();                
      arr.quickSort(); 
      System.out.println("After sorting:-------------------------------------------------");
      arr.display();     
      
      long end = System.currentTimeMillis();;

      System.out.println((end - start) + " ms");
      } 
   }  

