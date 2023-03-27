/*
[9-14] 다음은 화면으로부터 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진
        문자열 배열에서 찾아서 출력하는 프로그램이다.
        알맞은 코드를 넣어 프로그램을 완성하시오.

        [Hint] Pattern, Matcher클래스를 사용할 것
*/

import java.util.*;
import java.util.regex.*;

class Sol_Exercise9_14 {
    public static void main(String[] args) {
        String[] phoneNumArr = {
                "012-3456-7890",
                "099-2456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };
        ArrayList list = new ArrayList();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String input = s.nextLine().trim(); //🌟입력한값을 .trim()으로 잘라 공백 끝이 없도록 한다.

            if (input.equals("")) { //🌟좌우 공백을 제거한 상태이므로, input이 빈 문자열이라면 아무 것도 입력하지 않았다는 소리이다. 다시 입력값 받자.
                continue;
            } else if (input.equalsIgnoreCase("Q")) {   //🌟 q, Q 입력 시 true를 반환하여 System.exit(0) 동작.
                System.exit(0);
            }

            /*
            (1) 알맞은 코드를 넣어 완성하시오.
            */
            String pattern = ".*"+input+".*";   //🌟input을 포함하는 모든 문자열
            for(int i=0; i<phoneNumArr.length; i++) {
                String phoneNum = phoneNumArr[i];
                phoneNum.replaceAll("-", "");   //🌟phoneNum에서 '-'제거
                if(Pattern.matches(pattern, phoneNumArr[i])) {
                    list.add(phoneNumArr[i]);
                }
            }


            if (list.size() > 0) {  //🌟ArrayList list의 사이즈가 0보다 크면
                System.out.println(list); //🌟list를 출력하고
                list.clear(); //🌟 list의 모든 요소를 삭제한다.
            } else {    //🌟ArrayList list의 사이즈가 0이하이면 일치 번호가 없다고 출력한다. list에는 String 배열 phoneNumArr의 일부값이 담겨 있어야한다.
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    } // main
}


/*
<실행결과>
>>
>>
>>asdf
일치하는 번호가 없습니다.
>>
>>
>>0
[012-3456-7890, 099-2456-7980, 088-2346-9870, 013-3456-7890]
>>234
[012-3456-7890, 088-2346-9870]
>>7890
[012-3456-7890, 013-3456-7890]
>>q
 */

/*
<모범답안>
```java
import java.util.*; import java.util.regex.*;

class Exercise11_18 {
public static void main(String[] args) { String[] phoneNumArr = {
"012-3456-7890",
"099-2456-7980",
"088-2346-9870",
"013-3456-7890"
};
Vector list = new Vector(); // 검색결과를 담을 Vector Scanner s = new Scanner(System.in);

while(true) {
System.out.print(">>");
String input = s.nextLine().trim(); // trim()으로 입력내용에서 공백을 제거

if(input.equals("")) { continue;
} else if(input.equalsIgnoreCase("Q")) { System.exit(0);
}

String pattern = ".*"+input+".*"; // input을 포함하는 모든 문자열
Pattern p = Pattern.compile(pattern);

for(int i=0; i< phoneNumArr.length;i++) { String phoneNum = phoneNumArr[i];
String tmp = phoneNum.replace("-",""); // phoneNum에서 '-'를 제거

Matcher m = p.matcher(tmp);

if(m.find()) {	// 패턴과 일치하면, list에 phoneNum을 추가한다. list.add(phoneNum);
}
}

if(list.size()>0) {	// 검색결과가 있으면 System.out.println(list); // 검색결과를 출력하고 list.clear();	// 검색결과를 삭제
} else {
System.out.println("일치하는 번호가 없습니다.");
}
}
} // main
}

<실행결과>
>>
>>
>>asdf
일치하는 번호가 없습니다.
>>
>>
>>0
[012-3456-7890, 099-2456-7980, 088-2346-9870, 013-3456-7890]
>>234
[012-3456-7890, 088-2346-9870]
>>7890
[012-3456-7890, 013-3456-7890]
>>q

- ❓💡추후 자바의 정석 3판으로 Vector와 Pattern, Matcher 클래스를 보고 다시 이해해보자.
 */
