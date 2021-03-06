package newShellSort;



class ArraySh
{
private long[] theArray;          
private int nElems;               
//--------------------------------------------------------------
public ArraySh(int max)           
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
public void shellSort()
   {
   int inner, outer;
   long temp;

   int h = 1;                     
   while(h <= nElems/3)
      h = h*4 + 1;                

   while(h>0)                     
      {
                                  
      for(outer=h; outer<nElems; outer++)
         {
         temp = theArray[outer];
         inner = outer;
                                  
         while(inner > h-1 && theArray[inner-h] >=  temp)
            {
            theArray[inner] = theArray[inner-h];
            inner -= h;
            }
         theArray[inner] = temp;
         }  // end for
      h = (h-1) / 4;              
      }  
   } 
//--------------------------------------------------------------
}  

class ShellSort
{
public static void main(String[] args)
   {
    long start = System.currentTimeMillis();;
    
   int maxSize = 96000;             
   ArraySh arr;
   arr = new ArraySh(maxSize);   
 
   for(int j=0; j<maxSize; j++)  
      {                         
      long n = (int)(java.lang.Math.random()*999);
      arr.insert(n);
      }
   arr.display();                
   arr.shellSort();             
   arr.display();    
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   }  
}  
