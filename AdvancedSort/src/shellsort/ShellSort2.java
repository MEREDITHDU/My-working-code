package shellsort;

import java.util.UUID;

class ArraySh
{
private String[] theArray;          
private int nElems;               
//--------------------------------------------------------------
public ArraySh(int max)           
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
public void shellSort()
   {
   int inner, outer;
   String temp;

   int h = 1;                     
   while(h <= nElems/3)
      h = h*4 + 1;                

   while(h>0)                     
      {
                                  
      for(outer=h; outer<nElems; outer++)
         {
         temp = theArray[outer];
         inner = outer;
                                  
         while(inner > h-1 && theArray[inner-h].compareTo(temp)>=0 )
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

class ShellSort2
{
public static void main(String[] args)
   {
    long start = System.currentTimeMillis();;
    
   int maxSize = 32000;             
   ArraySh arr= new ArraySh(maxSize);   

   for(int j=0; j<maxSize; j++)  
      {                         
	   String id = UUID.randomUUID().toString();
       arr.insert(id);
      }
   arr.display();                
   arr.shellSort();             
   arr.display();    
   
   long end = System.currentTimeMillis();;

   System.out.println((end - start) + " ms");
   }  
}  

