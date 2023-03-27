//[9-6] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
//
//        메서드명 : fillZero
//        기	능 : 주어진 문자열(숫자)로 주어진 길이의 문자열로 만들고, 왼쪽 빈 공간은 '0'으로 채운다.
//        만일 주어진 문자열이 null이거나 문자열의 길이가 length의 값과 같으면 그대로 반환한다.
//        만일 주어진 length의 값이 0보다 같거나 작은 값이면, 빈 문자열("")을 반환한다.
//        반환타입 : String
//        매개변수 : String src - 변환할 문자열
//        int length - 변환한 문자열의 길이

class Sol_Exercise9_6 {
    public static String fillZero(String src, int length) {
        /* (1) fillZero메서드를 작성하시오.
        1.	src가 널이거나 src.length()가 length와 같으면 src를 그대로 반환한다.
        2.	length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환한다.
        3.	src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다.
        4.	길이가 length인 char배열을 생성한다.
        5.	4에서 생성한 char배열을 '0'으로 채운다.
        6.	src에서 문자배열을 뽑아내서 4에서 생성한 배열에 복사한다.
        7.	4에서 생성한 배열로 String을 생성해서 반환한다.
        */
        if(src==null||src.length()==length) return src;
        else if(length<=0) return "";
        else if(src.length()>length) return src.substring(0, length);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length-src.length(); i++) {  //⭐length-src.length()는 0의 개수가 전체자리-src의 길이여야 하므로 0의 반복개수를 이정도로 제한한다.
            sb.append(0);
        }
            sb.append(src);
        return new String(sb);
    }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src,10));
        System.out.println(fillZero(src,-1));
        System.out.println(fillZero(src,3));
    }
}

/*
<실행결과>
0000012345

123
 */

/*
<🔥풀이접근>
주어진 길이 length만큼의 자리수를 만들어 반환하는 메서드를 만드는 것이다.
왼쪽 공백을 0으로 채우고 오른쪽에는 src가 그대로 붙어야 한다.
⭐문자열을 덧붙이는 클래스는 StringBuffer나 StringBuilder를 사용하는 것이 공간복잡도를 줄일 수 있다.
멀티 쓰레드일 경우 StringBuffer를, 단일 쓰레드일 경우 StringBuilder를 사용하는 것이 안전하지만,
여기서는 StringBuffer를 사용했다.
StringBuffer를 String으로 변환하여 반환해주면된다. 방법은 다음과 같다.
1. 생성자 new String(StringBuffer)를 사용하여 String 참조변수에 담기
2. StringBuffer.toString을 사용하여 String 참조변수에 담기⭐ 이 방법을 추천할만 하다.
(생성자 new String(StringBuffer)를 사용하기 보다 static String valueOf(Object obj)를 사용해 String에 담아주겠다.)

<🔥풀이접근2>
StringBuffer와 StirngBuilder 이외에도 결합연산자 +를 사용할 수 있다.
+를 사용하게 되면 상수풀에 하나씩 String 객체가 생성되므로 이번 문제같은 경우 공간효율 측면에서 비효율적이다.
단, 자바 컴파일러가 +연산자를 통해 String을
 */

/*
<모범답안>
class Exercise9_6 {
    public static String fillZero(String src, int length) {
//	1. src가 널이거나 src.length()가 length와 같으면 src를 그대로 반환한다.
        if(src==null || src.length()==length) { return src;
//	2. length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환한다.
        } else if(length <=0) { return "";
//	3. src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다.
        } else if(src.length() > length) { return src.substring(0,length);
        }

//	4. 길이가 length인 char배열을 생성한다.
        char[] chArr = new char[length];

//	5. 4에서 생성한 char배열을 '0'으로 채운다.
        for(int i=0;i<chArr.length;i++) chArr[i] = '0';

//	6. src에서 문자배열을 뽑아내서 4에서 생성한 배열에 복사한다.
        System.arraycopy(src.toCharArray(),0,chArr,length-src.length(),
                src.length());

//	7. 4에서 생성한 배열로 String을 생성해서 반환한다.
        return new String(chArr);
    }

    public static void main(String[] args) {
    String src = "12345";
    System.out.println(fillZero(src,10));
    System.out.println(fillZero(src,-1));
    System.out.println(fillZero(src,3));
    }
}

<🔥내 풀이와 다른점>
나는 StringBuffer.append를 이용했지만,
⭐모범 답안은 문자열이 char[]이라는 점을 이용하여 배열을 만들어서 풀었다.
이 경우, System.arraycopy()를 사용해야 한다.

 */

