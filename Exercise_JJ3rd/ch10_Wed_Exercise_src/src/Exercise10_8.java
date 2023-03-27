//[10-8] 서울과 뉴욕간의 시차가 얼마인지 계산하여 출력하시오.

/*
<실행결과>
2016-01-28T23:01:00.136+09:00[Asia/Seoul]
2016-01-28T09:01:00.138-05:00[America/New_York] sec1=32400
sec2=-18000
diff=14 hrs

 */

import java.time.*;

// <모범 풀이>
class Exercise10_8 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime zdtNY = ZonedDateTime.now().withZoneSameInstant(nyId);

        System.out.println(zdt); System.out.println(zdtNY);

        long sec1 = zdt.getOffset().getTotalSeconds();
        long sec2 = zdtNY.getOffset().getTotalSeconds();
        long diff = (sec1 - sec2)/3600;

        System.out.println("sec1="+sec1);
        System.out.println("sec2="+sec2);
        System.out.printf("diff=%d hrs%n",diff);
    }
}

/*
<모범 풀이 해설>
[해설]

ZonedDateTime의 getOffset()은 ZoneOffset을 반환한다.
ZoneOffset의 getTotalSeconds()를 호출하면, 날짜와 시간을
초단위로 변환한 결과를 얻을 수 있다.

ZoneOffset offset = zdt.getOffset();
long sec1 = offset.getTotalSeconds();

현재 서울과 뉴욕의 날짜와 시간을 초단위로 바꾼다음에,
차이를 구하면 시차를 초단위로 구할 수 있다.
이 값을 3600초(1시간)으로 나누면, 시간단위의 값을 구할 수 있다.
 */