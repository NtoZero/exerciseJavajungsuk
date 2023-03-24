// [9-5] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
/*
메서드명 : count
기	능 : 주어진 문자열(src)에 찾으려는 문자열(target)이 몇 번 나오는지 세어서 반환한다.
반환타입 : int
매개변수 : String src
String target

[Hint] String클래스의 indexOf(String str, int fromIndex)를 사용할 것
 */

import java.util.Arrays;

class Sol_Exercise9_5 {
    public static int count(String src, String target) {
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

    /*
        (1) 반복문을 사용해서 아래의 과정을 반복한다.
            1.	src에서 target을 pos의 위치부터 찾는다.
            2.	찾으면 count의 값을 1 증가 시키고, pos의 값을 target.length만큼 증가시킨다.
            3.	indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
    */
        for(pos=src.indexOf(target); pos<src.length(); ) {    //⭐굳이 pos에 증감식을 붙이지 않는다. pos는 for문 안에서 계속 증가재할당 할 것이다.
            if(src.indexOf(target, pos)!=-1) { // src안에 target이 존재하면
                ++count;
                pos += target.length(); //⭐for문에서 조건문의 기준이 되는 변수에 =을 붙이지말자. 원래 실수로 =을 붙였는데 무한루프문에 빠졌다.
                pos = src.indexOf(target, pos);
                if(pos == -1) return count;
            } else return count;    //애초에 src에 target이 없을 경우 count 반환
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB","AB"));
        System.out.println(count("12345","AB"));
    }
}

/*
<실행결과>
3
0
 */

/*
<문제 접근>
어떤 문자열에 특정 문자열이 몇 번 반복되는지 확인하는 메서드이다.
    src안의 target의 개수를 찾아야한다.
아이디어가 떠올랐는데, for문을 사용할 필요 없이 String 클래스의 split 메서드를 활용하여 분할된 요소의 개수-1만큼 return해주면 되지 않을까?
        System.out.println(Arrays.toString(src.split(target)));
        return src.split(target).length-1 ; //target으로 분할된 String 배열의 요소개수-1
        //⭐아, 이렇게 하면 target이 가장 마지막에 존재하는 경우 src.split(target)의 요소로 반영되지 않는다... 테스트 코드의 중요성!
        //그런데 이럴경우 if(src.split(target).endsWith(target)일 시, 리턴 값을 -1할 필요가 없다. 마찬가지로, startsWith(target)할 때는 -1할 필요가없다.
         String[] div_src = src.split(target);   //src를 target으로 분할한 문자열배열을 div_src에 저장
            if(src.endsWith(target)) return div_src.length; //끝문자로 target을 가지고 있으면 나눠진 요소 개수 모두 반환
            else if(src.startsWith(target)) return div_src.length;  //시작문자로 target을 가지고 있으면 나눠진 요소 개수 모두 반환
            else return div_src.length-1;    //끝 문자로 target을 가지고 있지 않으면 나눠진  요소개수에서 -1해야한다.

다시 원래 문제로 접근하여,
찾기 시작할 위치를 pos로, 찾은 횟수를 count로 지정해 주었다.
    값을 찾을 때마다 pos의 값이 해당 인덱스값 이후로 변화하며, count++하면 될 것이다.
 */

/*
<모범풀이> while(true)문과 조건식으로 값 적절히 재할당
class Exercise9_5 {
    public static int count(String src, String target) { int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

//	(1) 반복문을 사용해서 아래의 과정을 반복한다.
        while(true) {
//	1. src에서 target을 pos의 위치부터 찾는다.
            pos = src.indexOf(target,pos);

//	2. 찾으면 count의 값을 1 증가 시키고,
//	pos의 값을 target.length만큼 증가시킨다.
            if(pos!=-1) {
                count++;
                pos += target.length(); // pos를 찾은 단어 이후로 옮긴다.
            } else {
//	3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) { System.out.println(count("12345AB12AB345AB","AB")); System.out.println(count("12345","AB"));
    }

**내 풀이와 차이점** :
1. while(true)문으로 `pos`의 값을 적절히 `indexOf(target, pos)`로 재할당한다. ⭐단, 해당 `if(pos=-1)`이 아닐 조건일 때 `pos += target.length()`해야 무한 순환에 빠지지 않는다.
2. ⭐클린코드 관점에서 내가 `src.indexOf(target, pos)`로 사용했던 부분을 값을 재할당한 `pos`를 사용하여 조건식을 깔끔하게 만들었다.
항상 코드의 가독성을 생각하자!

}*/
