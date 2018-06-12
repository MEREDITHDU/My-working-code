/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble;

import java.util.UUID;

class ArrayBub
{
    private String[] a;
    private int nElems; 
//----------------------------------------------------------
public ArrayBub(int max){
    a =new String[max];
    nElems=0;  
}
//----------------------------------------------------------
public void insert(String s){ 
    a[nElems]=s;
    nElems++; 
}
//-----------------------------------------------------------
public void display(){ 
    for(int j=0;j<nElems;j++){   
        System.out.print(a[j]+" ");  
        System.out.println(" ");
    }
}
//-----------------------------------------------------------
public void bubbleSort1(){
    int out,in;
    for(out=nElems-1;out>1;out--) 
        for(in=0;in<out;in++) 
            if(a[in].compareTo(a[in+1])>0) 
                swap(in,in+1); 
}
//------------------------------------------------------------
private void swap(int one,int two)
{
    String temp=a[one];
    a[one]=a[two];
    a[two]=temp;
}
//--------------------------------------------------------------
public void bubbleSort3() {
    for (int i = 0; i < nElems/2; i++) {
        boolean swapped = false;
        for (int j = i; j < nElems -i - 1; j++) {
            if (a[j].compareTo(a[j+1])<0) {
               swap(j,j+1);
                swapped = true;
            }
        }
        for (int j = nElems - 2 - i; j > i; j--) {
            if (a[j].compareTo(a[j-1])>0) {
               swap(j,j-1);
                swapped = true;
            }
        }
        if(!swapped) break;
    }
}
//------------------------------------------------------------
public void bubbleSort2(){
    int endPoint = nElems-1;  
   
    while(endPoint>0){ 
       int pos = 0;
	for(int j=1;j<=endPoint;j++){  
		try{
           if(a[j].compareTo(a[j+1])<0){  
              swap(j,j+1);
          
              pos= j;  
           }
		 }   catch(Exception e) {
      	   System.out.println("Exception!");
         }     
       }
       endPoint= pos-1;  
    }
}
//-------------------------------------------------------
}

public class BubbleSort {
 
    public static void main(String[] args) {
        // TODO code application logic here
    	
        long start = System.currentTimeMillis();;
        int maxSize=33000;
        ArrayBub arr=new ArrayBub(maxSize);
        
        for (int i = 0; i < 32000; i++) {
           	String id = UUID.randomUUID().toString();
              arr.insert(id);
             }
        
        arr.display();
        
        System.out.println("sorted:-------------------------------------------------------------------------------------");
     
        arr.bubbleSort1();
        arr.display();

        long end = System.currentTimeMillis();;

        System.out.println((end - start) + " ms");
    }
    
}