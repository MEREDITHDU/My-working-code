/*
    * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert;

import java.util.UUID;


class ArrayIns
{
    private String[] a;
    private int nElems; 
//----------------------------------------------------------
public ArrayIns(int max){
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
public void insertionSort1(){
	
    int out,in;
    for(out=1;out<nElems;out++) 
    {
        String temp=a[out];
        in=out;
        while(in>0 &&a[in-1].compareTo(temp)>=0){
            a[in]=a[in-1];
            --in;
        }
        a[in]=temp;
    } 
   
}
//------------------------------------------------------------
public void insertionSort2()
{
	int out,in;
	 for(out=1;out<nElems;out++) 
	 {
	     String temp=a[out];
	     a[0]=temp;
	     in=out;
	     try {
	     while(a[in-1].compareTo(temp)>=0){
	         a[in]=a[in-1];
	         --in;
	     }
	     }catch(ArrayIndexOutOfBoundsException e) {
	    	 System.out.println("Exception!");
	     }
	     a[in]=temp;
	 } 
}
//	----------------------------------------------------------------------------
} 
public  class insertSort {

    public static void main(String[] args) {

    	long start = System.currentTimeMillis();;
        int maxSize=32000;
        ArrayIns arr=new ArrayIns(maxSize);
     
        for (int i = 0; i < 32000; i++) {
           	String id = UUID.randomUUID().toString();
              arr.insert(id);
             }
        
        arr.display();
        
        System.out.println("sorted:----------------------------------------------------------------");
        
        arr.insertionSort2();
        arr.display();
        

        long end = System.currentTimeMillis();;

        System.out.println((end - start) + " ms");
       
    }
    
}
