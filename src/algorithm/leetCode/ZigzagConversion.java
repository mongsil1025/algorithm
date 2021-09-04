package algorithm.leetCode;

public interface ZigzagConversion {
    public static void main(String[] args) {
        String result = optimized("abc", 1);
        System.out.println(result);
        System.out.println("abc".equals(result));
    }

    public static String convert(String s, int numRows) {

        if(s.length() == 1) {
            return s;
        }
        
        int col_size = s.length();
        char[][] converted = new char[numRows][col_size];

        int x = 0;
        int y = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            y = y < 0 ? 0 : y;
            if(x == 0 || numRows - 1 == 0 || x % (numRows - 1) == 0) { // 양쪽 벽
                converted[y++][x] = c;
                if(y > 0 && y % numRows == 0) {
                    x++;
                    y -= 2;
                }
            } else { // 대각선
                converted[y--][x++] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++) {
            for(int j =0; j<col_size; j++) {
                if(converted[i][j] > 0) {
                    sb.append(converted[i][j]);
                }
            }
        }
        
        return sb.toString();
    }

    public static String optimized(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;

        // 이중포문 보다, String 을 이어 붙일 StringBuffer 배열쓰기
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i=0; i<sb.length; i++) sb[i] = new StringBuffer(); // Initialization

        int i = 0; // string 의 인덱스
        while(i < len) {
            for(int idx = 0; idx < nRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            for(int idx = nRows-2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        for(int idx=1; idx < nRows; idx ++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
