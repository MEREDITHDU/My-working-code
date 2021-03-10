package matrixExample;

class FindMyWord{
	public void findWord(String w,char[][] data){
	    int x=0,y=0;
	    for(char[] i:data){
	        String d = new String(i);
	        while(d.contains(w)){
	            x+=i.length;
	            System.out.println("pattern found at " + x + ", " + y);
	            x++;
	            d=d.substring(x);
	        }
	        y++;
	        x=0;
	    }
	}
}

public class WordsBuilder {
	
	static FindMyWord find = new FindMyWord();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] data = {
        		{'A','L','O','N','E'},
        		{'S','A','D','A','B'},	
        		{'H','A','P','P','Y'},
        		{'E','U','T','Q','W'},
        		{'S','O','C','O','L'}
        		};
        String Word1="NAP";
        String Word2="ZAP";
        find.findWord(Word1, data);
        System.out.println();
        find.findWord(Word2, data);
	}

}
