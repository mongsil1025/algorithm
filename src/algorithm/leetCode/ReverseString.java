package algorithm.leetCode;

public class ReverseString {
    public static void main(String[] args) {
        String str = "God Ding";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
        int p1 = 0;
        int p2 = 0;

        char[] array = s.toCharArray();
        
        int cur = 0;
        while(p2 < s.length()) {
            if(array[p2] == ' ') { // met blank
                cur = p2;

                while(p1 < p2) {
                    char temp = array[p1];
                    array[p1] = array[p2 - 1];
                    array[p2 - 1] = temp;

                    p1 ++;
                    p2 --;
                }

                p1 = cur + 1;
                p2 = cur + 1;
            } else {
                p2 ++;
            }
            
        }
        while(p1 < p2) {
            char temp = array[p1];
            array[p1] = array[p2 - 1];
            array[p2 - 1] = temp;

            p1 ++;
            p2 --;
        }
        return String.valueOf(array);
    }
}
