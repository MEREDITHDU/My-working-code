package hash;

import java.math.BigDecimal;

 class DoublHash {
	
		static int count = 0;
		static int countInsert = 0;

		public void DoublHashing() {
			int hashLength;
			double loadFactor = 0.0;
			
			int[] array = new int[1048573];
			int[] result = new int[1100000];
			int[] countSearch = new int[2000000];
			double loadFacs[] = new double[2000000];
			long timeCos[] = new long[2000000];
			
			for(int i=0;i<100;i++) {
	            int r=(int)(Math.random()*60);
	        	array[i]=r;
	        }

			int size = array.length;

			for (int l = 4; l < 9; l++) {
				count = 0;
				countInsert = 0;
				Double loadFactor1 = 0.1 * (l + 1);
				BigDecimal   b   =   new   BigDecimal(loadFactor1);    
				  
				loadFactor   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
				
				loadFacs[l] = loadFactor;
				hashLength = (int) (size * loadFactor);
				System.out.println("LoadFact: " + loadFactor +" Size: " + size + " HashLength: " + hashLength);
				int[] hash = new int[hashLength];
				//insert
				for (int i = 0; i < array.length; i++) {
					insertHash(hash, hashLength, array[i]);

				}
				System.out.println();
				//System.out.println(Arrays.toString(hash));

				long sumTime = 0;
				for ( int t =0; t < 10; t++){
				long startTime = System.currentTimeMillis();;
				for (int i = 0; i < size; i++) {
					int searchNum = array[i];
					result[i] = searchHash(hash, hashLength, searchNum);
				}
				long endTime = System.currentTimeMillis();;
				sumTime += (endTime - startTime);
				}
				timeCos[l] = sumTime / 10;
				countSearch[l] = count / 10;
				System.out.println("loadFactor is: " + loadFactor);

				System.out.println("Insert completed!  Insertcount: " + countInsert);
				System.out.println("Search completed!  ASL count: " + count / 160 + "test");
				System.out.println("Time cost: " + sumTime / 10+"ms");
				System.out.println(l);

			}
		}

		public static int searchHash(int[] hash, int hashLength, int key) {
			int hashAddress = key % hashLength;
			int stepSize,constant=5; 
			while (hash[hashAddress] != 0 && hash[hashAddress] != key) {
				count++;
				stepSize = constant - (hashAddress % constant);  
		        hashAddress = (hashAddress + stepSize) % hashLength;
			}
			count++;

			if (hash[hashAddress] == 0)
				return -1;
			return hashAddress;

		}

		public static void insertHash(int[] hash, int hashLength, int data) {
			int hashAddress = data % hashLength;
			countInsert++;
			int stepSize,constant=5; 
			while (hash[hashAddress] != 0) {
				stepSize = constant - (hashAddress % constant);  
		        hashAddress = (hashAddress + stepSize) % hashLength;                                                  
				countInsert++;
			}

			hash[hashAddress] = data;
		}
}

public class DoubleHash {
	public static void main(String[] args){
	DoublHash doub = new DoublHash();

	doub.DoublHashing();
    
	}

}
