package newQuickSort;

import java.util.Random;

class ArrayIns5
   {
   private int[] theArray;          
   private int nElems;               
//--------------------------------------------------------------

public ArrayIns5(int max)          
      {
      theArray = new int[max];      
      nElems = 0;                    
      }
//--------------------------------------------------------------
   public void insert(int d)    
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
//   -------------------------------------------------------------
   public void QuickSort() {
		// TODO Auto-generated method stub
		recQuickSort(theArray,0, nElems-1);
	}
//--------------------------------------------------------------
   public void recQuickSort(int[] theArray,int left, int right)
      {
      if(right-left <= 0)            
          return;                      
      else                             
         {                                    
         int pivot = partitionIt(theArray,left, right);
         recQuickSort(theArray,left,pivot-1);   
         recQuickSort(theArray,pivot+1, right);  
         }
      }  
//--------------------------------------------------------------
    public int partitionIt(int[] theArray, int left,int right)
       {
    	int pivot = choosePivot(theArray, left, right);
    	int leftptr=left;
    	for(int j=left+1;j<=right;j++) {
    		if(theArray[j]<pivot) {
    			leftptr++;
    			swap(leftptr,j);
    		}
    	}
    	theArray[left]=theArray[leftptr];
    	theArray[leftptr]=pivot;
       return leftptr;               
       }  
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  
      {
      int temp = theArray[dex1];       
      theArray[dex1] = theArray[dex2];   
      theArray[dex2] = temp;             
      }  // end swap(
//--------------------------------------------------------------
   private int choosePivot(int[] theArray, int p, int q) {
       return (int) theArray[p + new Random().nextInt(q - p)];
   		}

   }  

class QuickSort2
   { 
   public static void main(String[] args)
      {
	  long start = System.currentTimeMillis();;
      int maxSize = 96000;   

      ArrayIns5 arr= new ArrayIns5(maxSize);  

      for(int j=0; j<maxSize; j++)  
      {                         
      int n = (int)(java.lang.Math.random()*999);
      arr.insert(n);
      }
   arr.display();               
   System.out.println("After sorting:-------------------------------------------------");
   arr.QuickSort();             
   arr.display();  
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
      }  
   }  


