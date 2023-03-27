//[10-1] Calendar클래스와 SimpleDateFormat클래스를 이용해서 2010년의 매월 두 번째 일요일의 날짜를 출력하시오.

/*
<실행결과>
2010-01-10은 2번째 일요일입니다.
2010-02-14은 2번째 일요일입니다.
2010-03-14은 2번째 일요일입니다.
2010-04-11은 2번째 일요일입니다.
2010-05-09은 2번째 일요일입니다.
2010-06-13은 2번째 일요일입니다.
2010-07-11은 2번째 일요일입니다.
2010-08-08은 2번째 일요일입니다.
2010-09-12은 2번째 일요일입니다.
2010-10-10은 2번째 일요일입니다.
2010-11-14은 2번째 일요일입니다.
2010-12-12은 2번째 일요일입니다.

 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Sol_Exercise10_1 {
    public static void main(String[] args) {
        // 달력 객체 생성하여 cal에 저장, SimpleDateFormat객체 생성하여 df에 저장
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //⭐MM이 달이고 mm이 분이다. 헷갈리지 말자!
        cal.set(2010,00,1); //⭐ cal객체의 달력을 2010년 01월 01일로 맞춤.
        
        //while(cal.get(Calendar.MONTH)<11) {    //❗❗무한 루프 때문에 사용불가 (Month에서 11+1=0이 되버린다.)
        int month=1;    //⭐ 무한루프 방지용 변수
        while(true) {
            cal.add(Calendar.DAY_OF_MONTH, 1);  // 날짜를 1씩 증가시켜서
            if(cal.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY) {  //⭐ cal객체의 요일이 일요일이면
                cal.add(Calendar.DAY_OF_MONTH, 7);  // 일주일 증가시키면 두 번째 일요일.
                System.out.printf("%s은 %d번째 일요일입니다.%n",
                                    df.format(cal.getTime()),
                                    cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));    //값을 출력하고
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 1);    //⭐다음 달 1일로 초기화 ⭐⭐단, MONTH가 11일때 +1하게 되면 =>0로 바뀐다. (무한루프주의)
                month++;    //⭐ 무한루프 방지용 변수
                if (month>12) { //⭐ 무한루프 방지
                break;
                }
            }
        }
    }
}

/*
<접근 방식1>
1. Calendar 객체를 생성하여 연, 월, 일에 대한 정보를 초기화해야한다.
2. SimpleDateFormat 생성자에 일정 포맷을 지정한 객체를 생성한다.
3. DateFormat.format(Date d)이 매개변수로 Date d를 요구하므로, Calendar를 Date로 변환한다. (⭐Cal객체.getTime()으로 Date 타입으로 변환 가능)
4. 💡날짜의 반복이 필요하므로, 반복문의 기준점이 별도로 필요하다. 1월 1일을 기준으로 잡고, add로 일요일이 되도록 한다.
5. 2주차의 일요일을 구하려면 다시 add를 사용해 첫 번째 일요일에서 +7을 더하도록 한다. 그럼 두 번째 일요일이 된다.
6. 이제 add를 사용해 Month를 +1씩 증가시켜서 12월(Month기준으로는 11)까지 반복문이 돌게 한다. ➡️ 여기서 문제가 발생한다. +1개월씩 해주는 것이므로 요일까지 맞춤으로 증가하는 것은 아니다.
➡️ 매월 마다 2번째 일요일을 찾아주는 반복문이 필요하다. add()로 더해서 해결할 수는 없다.

❌❌❌❌❌❌❌
public static void main(String[] args) {
        // 달력 객체 생성하여 cal에 저장, SimpleDateFormat객체 생성하여 df에 저장
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //⭐MM이 달이고 mm이 분이다. 헷갈리지 말자!
        cal.set(2010,00,1); //⭐ cal객체의 달력을 2010년 01월 01일로 맞춤.
        System.out.println(cal);
        for (int i=1; i<=7; i++) {
            if(cal.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY) {  //⭐순회해서 DAY_OF_WEEK 값이 일요일이면 for문 끝냄.
                break;  //return이 아니라 break를 써야 main메서드를 탈출하는 것이 아닌 for문을 탈출함.
            }
            cal.add(Calendar.DAY_OF_MONTH, 1);      //⭐날짜를 하루씩 증가시키면서 일요일 찾기
        }
        //⭐ 2010년 1월의 첫 번째 일요일이 cal에 저장된 상태에서 두 번째 일요일을 구하려면 날짜를 +7 해주고, 각 개월의 두 번째 일요일을 구하려면 거기서 ~~+31해야한다.~~ ⭐⭐아니다. 모든 일수가 동일하지 않기때문에 달을+1한다.
        cal.add(Calendar.DAY_OF_MONTH, 7);  //⭐ 1월의 두 번째 일요일
        System.out.println(cal);
        for(int month=0; month<12; month++) {
            System.out.printf(df.format(cal.getTime())+"은 %d번째 %d요일입니다.%n", cal.get(Calendar.DAY_OF_WEEK_IN_MONTH), cal.get(Calendar.DAY_OF_WEEK));
            cal.add(Calendar.MONTH, 1); //⭐한 달씩 증가.❌❌❌ 요일까지 맞춰 증가하는게 아니다
        }
    }
<해당코드 실행결과>
2010-01-10은 2번째 1요일입니다.
2010-02-10은 2번째 4요일입니다.
2010-03-10은 2번째 4요일입니다.
2010-04-10은 2번째 7요일입니다.
2010-05-10은 2번째 2요일입니다.
2010-06-10은 2번째 5요일입니다.
2010-07-10은 2번째 7요일입니다.
2010-08-10은 2번째 3요일입니다.
2010-09-10은 2번째 6요일입니다.
2010-10-10은 2번째 1요일입니다.
2010-11-10은 2번째 4요일입니다.
2010-12-10은 2번째 6요일입니다.
❌❌❌❌❌❌❌
 */

/*
<접근 방식2>
1. Calendar 객체를 생성하여 연, 월, 일에 대한 정보를 초기화해야한다.
2. SimpleDateFormat 생성자에 일정 포맷을 지정한 객체를 생성한다.
3. DateFormat.format(Date d)이 매개변수로 Date d를 요구하므로, Calendar를 Date로 변환한다. (⭐Cal객체.getTime()으로 Date 타입으로 변환 가능)
4. 날짜의 반복이 필요하다. ⭐반복문(while 조건)으로 매월 1일을 세팅한 후, 2번째 일요일을 구해서 출력하도록 하자.
 */

/*
<모범풀이>
import java.util.*;
import java.text.*;

class Exercise10_1
{
    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();

        cal.set(2010,0,1); // cal의 날짜를 2010년 1월 1일로 설정한다.

        for(int i=0; i < 12;i++) {
            int weekday = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일을 구한다.

// 두 번째 일요일은 1일의 요일에 따라 달라진다.
// 1일이 일요일인 경우에는 두번째 일요일은 8일이고,
// 1일이 다른 요일일 때는 16에서  1일의 요일(weekday)을 빼면 알 수 있다.
            int secondSunday = (weekday==1) ? 8 : 16 - weekday;

// 두 번째 일요일(secondSunday)로 cal의 날짜(DAY_OF_MONTH)를 바꾼다.
            cal.set(Calendar.DAY_OF_MONTH, secondSunday);

            Date d = cal.getTime(); // Calendar를 Date로 변환한다.
            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));

// 날짜를 다음달 1일로 변경한다.
            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.DAY_OF_MONTH,1);
        }
    }
}

[해설] 매월 두 번째 일요일(secondSunday)을 구하려면, 매월 1일이 무슨 요일인지 알아내야한다. 만일 1일이 일요일이라면
2번째 일요일은 8일이 된다. 1일이 월요일이라면 2번째 일요일은 14일이 된다. 1일이 일요일인 경우를 제외하고는 1일의 요일(weekday)과 2번째 일요일의 날짜를 더하면 일정한 값(16)이라는 것을 알 수 있다.
즉, 16에서 1일의 요일(weekday)을 빼면 2번째 일요일이 며칠인지 알 수 있는 것이다.(1일이 일요일인 경우 에는 9에서 1을 뺀 8이 된다.)
`int secondSunday = (weekday==1) ? 8 : 16 - weekday;`
![](https://velog.velcdn.com/images/9to0/post/785798ee-8d69-475d-9349-f68db64cb5d0/image.png)
이제 두 번째 일요일의 날짜(secondSunday)를 알아냈으니, set()를 사용해서 cal의 날짜(DAY_OF_MONTH)를 두 번째 일요일의 날짜로 변경한다.
SimpleDateFormat클래스의 format 메서드는 매개변수로 Date타입을 받기 때문에 cal.getTime()을 호출해서 Calendar를 Date로 변환해야한다.
// 두 번째 일요일(secondSunday)로 cal의 날짜(DAY_OF_MONTH)를 바꾼다. cal.set(Calendar.DAY_OF_MONTH, secondSunday);

Date d = cal.getTime(); // Calendar를 Date로 변환한다.
System.out.println(new SimpleDateFormat("yyyy-MM-dd은
F번째 E요일입니다.").format(d));	//⭐F번째 E요일 기호 사용
*/


