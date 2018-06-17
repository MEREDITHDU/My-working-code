package lcs;


public class LongestCommonSubsequence {
    public int lcs(char str1[],char str2[],int len1, int len2){
        
        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1 + lcs(str1,str2,len1+1,len2+1);
        }
        else{
            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
        }   
    }
    
    public void lcsprint(String X, String Y, int m, int n)
	{
		int[][] L = new int[m+1][n+1];

		for (int i=0; i<=m; i++)
		{
			for (int j=0; j<=n; j++)
			{
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i-1) == Y.charAt(j-1))
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}

		int index = L[m][n];
		int temp = index;

		char[] lcs = new char[index+1];
		int i = m, j = n;
		while (i > 0 && j > 0)
		{
			if (X.charAt(i-1) == Y.charAt(j-1))
			{
				lcs[index-1] = X.charAt(i-1); 

				i--; 
				j--; 
				index--;	 
			}

			else if (L[i-1][j] > L[i][j-1])
				i--;
			else
				j--;
		}

		System.out.print("Substring is: ");
		for(int k=0;k<=temp;k++)
			System.out.print(lcs[k]);
	}
    public int lcsDynamic(char str1[],char str2[]){
    
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
    }
        static int min(int x,int y,int z)
    	{
    		if (x<=y && x<=z) return x;
    		if (y<=x && y<=z) return y;
    		else return z;
    	}

    	static int editDist(String str1 , String str2 , int len1 ,int len2)
    	{
    	if (len1 == 0) return len2;
    	
    	if (len2 == 0) return len1;
    
    	if (str1.charAt(len1-1) == str2.charAt(len2-1))
    		return editDist(str1, str2, len1-1, len2-1); //recursive
    	
    	return 1 + min ( editDist(str1, str2, len1, len2-1), 
    					editDist(str1, str2, len1-1, len1), 
    					editDist(str1, str2, len1-1, len2-1) 				 
    				);
    
    }
    
    public static void main(String args[]){
    	
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "INTENTION";
        String str2 = "EXECUTION";
        int len1=str1.length();
        int len2=str2.length();
        
        int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.println("String A="+str1);
        System.out.println("String B="+str2);
        System.out.println("length is:"+result);
        lcs.lcsprint(str1, str2, len1, len2);
        System.out.println();
        
        long start = System.currentTimeMillis();
        System.out.println( "edit distance is:"+editDist( str1 , str2 , str1.length(), str2.length()) );
        long end = System.currentTimeMillis();;
        System.out.println("Running time is:"+(end - start) + " ms");
    }

    
}