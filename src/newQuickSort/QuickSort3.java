package newQuickSort;


class ArrayIns3
{
private double[] theArray;          
private int nElems;              
//--------------------------------------------------------------
public ArrayIns3(int max)         
   {
   theArray = new double[max];      
   nElems = 0;                    
   }
//--------------------------------------------------------------
public void insert(double d)    
   {
   theArray[nElems] = d;      
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
      double median = medianOf3(left, right);
      int partition = partitionIt(left, right, median);
      recQuickSort(left, partition-1);
      recQuickSort(partition+1, right);
      }
   }  // end recQuickSort()
//--------------------------------------------------------------
public double medianOf3(int left, int right)
   {
   int center = (left+right)/2;
                                   
   if( theArray[left] > theArray[center] )
      swap(left, center);
                                    
   if( theArray[left] > theArray[right] )
      swap(left, right);
                                    
   if( theArray[center] > theArray[right] )
      swap(center, right);

   swap(center, right-1);           
   return theArray[right-1];        
   } 
//--------------------------------------------------------------
public void swap(int dex1, int dex2)  
   {
   double temp = theArray[dex1];        
   theArray[dex1] = theArray[dex2];   
   theArray[dex2] = temp;             
   } 
//--------------------------------------------------------------
 public int partitionIt(int left, int right, double median)
    {
    int leftPtr = left;             
    int rightPtr = right - 1;       
    while(true)
       {
       while( theArray[++leftPtr] < median )  
          ;                                  
       while( theArray[--rightPtr] > median ) 
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
      double temp = theArray[out];    
      in = out;                    
                                    
      while(in>left && theArray[in-1] >= temp)
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
class QuickSort3
{
public static void main(String[] args)
   {
    long start = System.currentTimeMillis();;
	
   int maxSize = 96000;             
   ArrayIns3 arr;                 
   arr = new ArrayIns3(maxSize);  

   for(int j=0; j<maxSize; j++)  
      {                           
      long n = (int)(java.lang.Math.random()*999);
      arr.insert(n);
      }
   arr.display();                
   arr.quickSort3();       
   System.out.println("After sorting:-------------------------------------------------");
   arr.display();      
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   }  
}  

