package newBubbleSort;

class ArrayBub
{
private double[] a;                 
private int nElems;               
//--------------------------------------------------------------
public ArrayBub(int max)          
   {
   a = new double[max];            
   nElems = 0;                        
   }
//--------------------------------------------------------------
public void insert(double value)    
   {
   a[nElems] = value;            
   nElems++;                    
   }
//--------------------------------------------------------------
public void display()            
   {
   for(int j=0; j<nElems; j++)       
      System.out.println(a[j] + " ");  
   System.out.println("");
   }
//--------------------------------------------------------------
public void bubbleSort()
   {
   int out, in;

   for(out=nElems-1; out>1; out--)   
      for(in=0; in<out; in++)        
         if( a[in] > a[in+1] )      
            swap(in, in+1);         
   }
//------------------------------------------------------------
public void bubbleSort2(){
    int endPoint = nElems-1;  
   
    while(endPoint>0){ 
       int pos = 0;
	for(int j=1;j<=endPoint;j++){  
           if(a[j]<a[j+1]){  
              swap(j,j+1);
          
              pos= j;  
           }	
       }
       endPoint= pos-1;  
    }
}
//-------------------------------------------------------
public void bubbleSort3() {
    for (int i = 0; i < nElems/2; i++) {
        boolean swapped = false;
        for (int j = i; j < nElems -i - 1; j++) {
            if (a[j] < a[j+1]) {
               swap(j,j+1);
                swapped = true;
            }
        }
        for (int j = nElems - 2 - i; j > i; j--) {
            if (a[j] > a[j-1]) {
               swap(j,j-1);
                swapped = true;
            }
        }
        if(!swapped) break;
    }
}
//--------------------------------------------------------------
private void swap(int one, int two)
   {
   double temp = a[one];
   a[one] = a[two];
   a[two] = temp;
   }
//--------------------------------------------------------------
} 

class BubbleSort
{
public static void main(String[] args)
   {
	
    long start = System.currentTimeMillis();;
	
   int maxSize = 1000;           
   ArrayBub arr= new ArrayBub(maxSize);  

   for(int j=0;j<maxSize; j++)  
   {                         
	   double i=java.lang.Math.random()*999;
	   arr.insert(i);
   }

   arr.display();                

   arr.bubbleSort();        
   System.out.println("sorted:------------------------------------------------------------------------------------");

   arr.display();                
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   }  
}  
