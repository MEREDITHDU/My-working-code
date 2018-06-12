
package selection;

import java.util.UUID;

class ArraySel{
    private String[] a;
    private int nElems; 
//----------------------------------------------------------
    public ArraySel(int max){
        a=new String[max];
        nElems=0;
    }
 //-------------------------------------------------------
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
    public void selectionSort(){
        int out,in,min;
        for(out=0;out<nElems-1;out++)
        {
            min=out;
            for(in=out+1;in<nElems;in++)
            	
                if(a[in].compareTo(a[min])<0)
                    min=in;
            swap(out,min);
        }
    }
//------------------------------------------------------------
    private void swap(int one,int two)
{
   String temp=a[one];
    a[one]=a[two];
    a[two]=temp;
}
//------------------------------------------------------------
}
public class SelectSort {
    public static void main(String[] args){
    	long start = System.currentTimeMillis();;
        int maxSize=32000;
        ArraySel arr=new ArraySel(maxSize);
        
        for(int i = 0; i < 32000; i++){
        	String id = UUID.randomUUID().toString();
            arr.insert(id);
        }
        
        arr.display();
        
        System.out.println("sorted:----------------------------------------------------------------------");
        
        arr.selectionSort();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
        arr.display();
        
        

        long end = System.currentTimeMillis();;

        System.out.println((end - start) + " ms");
    
    }

	
}