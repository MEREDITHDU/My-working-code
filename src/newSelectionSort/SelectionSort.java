package newSelectionSort;




class ArraySel{
    private double[] a;
    private int nElems; 
//----------------------------------------------------------
    public ArraySel(int max){
        a=new double[max];
        nElems=0;
    }
 //-------------------------------------------------------
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
    public void selectionSort(){
        int out,in,min;
        for(out=0;out<nElems-1;out++)
        {
            min=out;
            for(in=out+1;in<nElems;in++)
            	
                if(a[in]<a[min])
                    min=in;
            swap(out,min);
        }
    }
//------------------------------------------------------------
    private void swap(int one,int two)
{
    double temp=a[one];
    a[one]=a[two];
    a[two]=temp;
}
//------------------------------------------------------------
}
public class SelectionSort {
    public static void main(String[] args){
    	long start = System.currentTimeMillis();;
        int maxSize=2000;
        ArraySel arr=new ArraySel(maxSize);
        
        for(int j = 0; j < maxSize; j++){
        	double i=java.lang.Math.random()*999;
        	arr.insert(i);
        }
        
        arr.display();
        
        System.out.println("sorted:----------------------------------------------------------------------");
        
        arr.selectionSort();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
        arr.display();
        
        

        long end = System.currentTimeMillis();;

        System.out.println((end - start) + " ms");
    
    }

	
}
