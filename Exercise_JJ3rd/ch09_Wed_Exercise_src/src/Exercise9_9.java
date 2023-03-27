//[9-9] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

/*
메서드명 : delChar
기	능 : 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
반환타입 : String
매개변수 : String src - 변환할 문자열, String delCh - 제거할 문자들로 구성된 문자열
         [힌트] StringBuffer와 String클래스의 charAt(int i)과 indexOf(int ch)를 사용하라.
 */

class Exercise9_9 {
    /*
    (1) delChar메서드를 작성하시오.
    */


    public static void main(String[] args)  {
    System.out.println("(1!2@3^4~5)"+" -> "
            + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
    System.out.println("(1 2	3 4\t5)"+" -> "
            + delChar("(1 2	3 4\t5)"," \t"));

}
}
/*
<실행결과>
(1!2@3^4~5) -> 12345
(1 2	3 4 5) -> (12345)
 */