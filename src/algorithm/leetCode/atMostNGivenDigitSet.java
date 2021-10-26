package algorithm.leetCode;

public class atMostNGivenDigitSet {
    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[] {"1"}, 834));
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        
        char[] target = convertToDigit(n);

        if(digits.length == 1 && target.length == digits.length) {
            if(Integer.parseInt(digits[0]) < n) return 1;
            else return 0;
        }
        
        int answer = 0;
        for(int i=target.length; i>0; i--) {            
            answer += digits.length == 1 ? 1 : Math.pow(digits.length, i);
        }
        // n보다 큰 경우의 수를 빼자
        for(int i=0; i<digits.length; i++) {
            answer -= permutation(digits[i], target.length, 0, digits, target);
        }
        return answer;        
    }
    
    private static char[] convertToDigit(int n) {
        String str = String.valueOf(n);
        return str.toCharArray();
    }
    
    private static int permutation(String candidate, int power, int depth, String[] digits, char[] target) {
        int result = 0;
        // System.out.println(candidate + ", " + power + ", " + depth + ", " + target[depth]);
        if(Character.getNumericValue(target[depth]) > Integer.parseInt(candidate)) {
            return 0;  
        } else if(Character.getNumericValue(target[depth]) < Integer.parseInt(candidate)) {
            // System.out.println("pow : " + (int) Math.pow(digits.length, power - 1));
            return (int) Math.pow(digits.length, power - 1);
        } else { // if same
            if(depth < target.length - 1) {
                for(int i=0; i<digits.length; i++) {
                    result += permutation(digits[i], power - 1, depth + 1, digits, target);
                }                
            }

        }
        return result;
    }
}
