package newInsertSort;


import java.util.Arrays;


class ArrayIns
{
 private double[] a;
 private int nElems; 
//----------------------------------------------------------
public ArrayIns(int max){
 a =new double[max]; 
 nElems=0;  
}
//----------------------------------------------------------
public void insert(double d){ 
 a[nElems]=d; 
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
public void insertionSort(){
	
 int out,in;
 for(out=1;out<nElems;out++) 
 {
     double temp=a[out];
     in=out;
     while(in>0 &&a[in-1]>=temp){
         a[in]=a[in-1];
         --in;
     }
     a[in]=temp;
 } 

}
//------------------------------------------------------------

public void insertionSort2(){
	
	 int out,in;
	 for(out=1;out<nElems;out++) 
	 {
	     double temp=a[out];
	     a[0]=temp;
	     in=out;
	     try {
	     while(a[in-1]>=temp){
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
public  class InsertSort {

 public static void main(String[] args) {

 	long start = System.currentTimeMillis();;
     int maxSize=8000;
     ArrayIns arr=new ArrayIns(maxSize);
  
     for (int j = 0; j < maxSize; j++) {
    	 double i=java.lang.Math.random()*999;
  	   arr.insert(i);
          }
     
     arr.display();
     System.out.println("sorted:----------------------------------------------------------------");
     
     arr.insertionSort2();
     arr.display();
     

     long end = System.currentTimeMillis();;

     System.out.println((end - start) + " ms");
    
 }
 
}
