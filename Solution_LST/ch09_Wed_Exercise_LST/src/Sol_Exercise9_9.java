//[9-9] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

/*
메서드명 : delChar
기	능 : 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
반환타입 : String
매개변수 : String src - 변환할 문자열, String delCh - 제거할 문자들로 구성된 문자열
         [힌트] StringBuffer와 String클래스의 charAt(int i)과 indexOf(int ch)를 사용하라.
 */


class Sol_Exercise9_9 {
    /*
    (1) delChar메서드를 작성하시오.
    */
    static String delChar(String src, String delCh) {
        if(src==null||delCh==null) return null; //⭐ 매개변수에 대한 유효성 검사 필수!
        StringBuffer sb = new StringBuffer(src);    //🔥 문자열 조작을 위한 SB객체 sb를 만든다.
//        for(int i=0; i<sb.length(); i++) {
//            char del = delCh.charAt(i); //🔥del은 delCh안의 문자를 순회한다.
//            int delIndex = sb.indexOf(del+""); //🔥지워야할 문자 del의 인덱스를 delIndex에 저장
//            if(delIndex!=-1) {    //🔥지워야할 문자 del의 인덱스가 -1이 아니면 (즉, 지워야할 문자 del이 sb에 존재하면)
//                sb.deleteCharAt(delIndex);
//            }    //delIndex==1이면 지워야할 문자가 없다는 말이므로 다시 for문으로 돌아가야 한다.
//            if(i==delCh.length()-1) return sb.toString();  //✔️해당 조건이 있어야 순회하는 i의 크기가 delCh의 인덱스 범위를 넘지 않는다.
//        }
            for(int i=0; i<delCh.length(); i++) {   //🔥 i는 0부터 시작하여 delCh의 인덱스를 순회한다.
              String delDest = delCh.charAt(i) +"";   //🔥delDest는 src에서 지워야할 목표문자. indexOf의 매개변수로 사용하기 위해 String으로 변환.
              while(sb.indexOf(delDest)!=-1) { //⭐🔥🔥지워야할 문자의 인덱스가 sb에 존재하면 계속해서 지운다. -1이면 다시 for문으로 돌아간다.
                  int delIndex = sb.indexOf(delDest); //🔥delIndex는 sb에서 지워야할 문자의 인덱스 ⭐재지정 필요
                  sb.deleteCharAt(delIndex);    //sb에서 delIndex번 인덱스를 지운다.
              }
            }
        return sb.toString(); //⭐sb.toString()은 String 타입이기 때문에 잘 기억해두자!
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> "
                + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2	3 4\t5)" + " -> "
                + delChar("(1 2	3 4\t5)", " \t"));

    }
}
/*
<실행결과>
(1!2@3^4~5) -> 12345
(1 2	3 4 5) -> (12345)
 */

/*
<🔥문제접근>
src의 char값들을 delCh 안의 char 타입과 일일이 대조해서 해당 데이터를 삭제하면 될 것이다.
⭐문자열 조작에 관한 내용이므로 StringBuffer 객체를 만들어서 사용한다.
StringBuffer 객체 주소값을 담고 있는 참조변수 sb는 String src의 내용을 복사해서 만들어졌다.
🔥for문을 사용해 sb의 요소 중 delCh안에 있는 각각의 요소를 확인하여 indexOf로 -1을 반환하지 않으면
sb.delete(delCh.charAt[i])를 사용해 삭제하게하면 될 것이다.
 */

/*
<모범풀이>
class Exercise9_9 {
    public static String delChar(String src, String delCh) { StringBuffer sb = new StringBuffer(src.length());

        for(int i=0; i < src.length();i++) {
            char ch = src.charAt(i);

        // ch가 delCh에 포함되있지 않으면(indexOf()로 못찾으면) sb에 추가
            if(delCh.indexOf(ch)==-1) // indexOf(int ch)를 호출
                sb.append(ch);
        }

        return sb.toString(); // StringBuffer에 저장된 내용을 String으로 반환
    }
 */
