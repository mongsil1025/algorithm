package algorithm.codeup.recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Loop1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	String str = scanner.nextLine();
        	list.add(str);        	
        }
        
        for(int i=0; i<list.size(); i++) {
        	split(list.get(i));
        	System.out.println();
        }

        scanner.close();
    }

    public static void split(String str) {
    	
    	char[] charAry = str.toCharArray();
    	for(int i=0; i < charAry.length; i=i+2) {
    		System.out.print(charAry[i]);
    	}
    	System.out.print(" ");
    	for(int i=1; i < charAry.length; i=i+2) {
    		System.out.print(charAry[i]);
    	}
    }
}


