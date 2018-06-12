package quicksort;

import java.util.Random;
import java.util.UUID;

class ArrayIns5
   {
   private String[] theArray;          
   private int nElems;               
//--------------------------------------------------------------

public ArrayIns5(int max)          
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
//   -------------------------------------------------------------
   public void QuickSort() {
		// TODO Auto-generated method stub
		recQuickSort(theArray,0, nElems-1);
	}
//--------------------------------------------------------------
   public void recQuickSort(String[] theArray2,int left, int right)
      {
      if(right-left <= 0)            
          return;                      
      else                             
         {
                                            
         int pivot = partitionIt(theArray2,left, right);
         recQuickSort(theArray2,left,pivot-1);   
         recQuickSort(theArray2,pivot+1, right);  
         }
      }  
//--------------------------------------------------------------
    public int partitionIt(String[] theArray2, int left,int right)
       {
    	String pivot = choosePivot(theArray2, left, right);
    	int leftptr=left;
    	for(int j=left+1;j<=right;j++) {
    		if(theArray2[j].compareTo(pivot)<0) {
    			leftptr++;
    			swap(leftptr,j);
    		}
    	}
    	theArray2[left]=theArray2[leftptr];
    	theArray2[leftptr]=pivot;
       return leftptr;               
       }  
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  
      {
      String temp = theArray[dex1];       
      theArray[dex1] = theArray[dex2];   
      theArray[dex2] = temp;             
      }  // end swap(
//--------------------------------------------------------------
   private String choosePivot(String[] theArray2, int p, int q) {
       return theArray2[p + new Random().nextInt(q - p)];
   		}

   }  

class QuickSort2
   { 
   public static void main(String[] args)
      {
      int maxSize = 1024000;   
      long start = System.currentTimeMillis();;
      ArrayIns5 arr= new ArrayIns5(maxSize);  

      for(int j=0; j<maxSize; j++)  
      {                         
    	  String id = UUID.randomUUID().toString();
          arr.insert(id);
      }
   arr.display();               
   System.out.println("After sorting:-------------------------------------------------");
   arr.QuickSort();             
   arr.display();  
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
      }  
   }  


