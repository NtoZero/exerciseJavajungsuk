/*
[9-10] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

메서드명 : format
기	능 : 주어진 문자열을 지정된 크기의 문자열로 변환한다. 나머지 공간은 공백으로 채운다.
반환타입 : String
매개변수 : String str - 변환할 문자열
        int length - 변환된 문자열의 길이
        int alignment - 변환된 문자열의 정렬조건
        (0:왼쪽 정렬, 1: 가운데 정렬, 2:오른쪽 정렬)
 */

class Sol_Exercise9_10  {
/*
(1) format메서드를 작성하시오.
1.	length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
2.	1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
3.	정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다. (System.arraycopy()사용)
4.	2에서 생성한 char배열을 문자열로 만들어서 반환한다.
*/
    static String format(String str, int length, int alignment) {
        if(str==null||length<1||alignment<0) return "인자가 정상적이지 않습니다.";
        if(length<str.length()) return str.substring(0, length);
            char[] chars = new char[length];
            for(int i=0; i<length; i++) {
                chars[i]=' ';
            } //❓원래 char타입 배열에서 char 기본값이 공백이지 않나? 그런데 이걸 써주지않으면 이상한 문자가출력됨.
            switch (alignment) {
                case 0: //왼쪽 정렬
                    System.arraycopy(str.toCharArray(), 0, chars, 0, str.length());   //⭐str.toCharArray()로 문자열을 문자배열로 바꿔주지 않으면 ArrayStoreException 예외발생!
                    break;
                case 1: //가운데 정렬
                    System.arraycopy(str.toCharArray(), 0, chars, length/3, str.length());
                    break;
                case 2: //오른쪽 정렬
                    System.arraycopy(str.toCharArray(), 0, chars, length*2/3, str.length());
                    break;
            }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str,7,0)); // 왼쪽 정렬
        System.out.println(format(str,7,1)); // 가운데 정렬
        System.out.println(format(str,7,2)); // 오른쪽 정렬
    }
}

/*
<실행결과>
가나다
    가나다
        가나다

 */

/*
<모범풀이>
class Exercise9_10 {
    static String format(String str, int length, int alignment) {

//	1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
        int diff = length - str.length();
        if(diff < 0) return str.substring(0, length);

//	2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다. char[] source = str.toCharArray(); // 문자열을 char배열로 변환 char[] result = new char[length];

        for(int i=0; i < result.length; i++)
            result[i] = ' ';	// 배열 result를 공백으로 채운다.

//	3. 정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다.
        switch(alignment)
        {   case 0 :
            default :   //⭐case와 default를 같이 사용하여 1,2를 제외한 값이 나오면 왼쪽정렬하도록 함.
                System.arraycopy(source, 0, result, 0, source.length); break;
            case 1 :
                System.arraycopy(source, 0, result, diff/2, source.length); break; //⭐(length-str.length)를 2로 나누는 지점이 복사스타트지점
            case 2 :
                System.arraycopy(source, 0, result, diff, source.length); break;
        }

//	4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
        return new String(result);
    } // static String format(String str, int length, int alignment) {

    public static void main(String[] args) { String str = "가나다";

        System.out.println(format(str,7,0)); // 왼쪽 정렬 System.out.println(format(str,7,1)); // 가운데 정렬 System.out.println(format(str,7,2)); // 오른쪽 정렬
    }
}
 */

