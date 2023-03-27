//[10-2] 어떤 회사의 월급날이 매월 21일이다. 두 날짜 사이에 월급날이 몇 번있는지 계산해서 반환하는 메서드를 작성하고 테스트 하시오.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Sol_Exercise10_2 {
    static int paycheckCount(Calendar from, Calendar to) {
    /*
    (1) 아래의 로직에 맞게 코드를 작성하시오.
    1.	from 또는 to가 null이면 0을 반환한다.
    2.	from와 to가 같고 날짜가 21일이면 1을 반환한다.
    3.	to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
    4.	monDiff가 음수이면 0을 반환한다.
    5.	만일 from의 일(DAY_OF_MONTH)이 21일이거나 이전이고
    to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff의 값을 1 증가시킨다.
    6.	만일 from의 일(DAY_OF_MONTH)이 21일 이후고
    to의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1 감소시킨다.
    */
        if(from==null || to==null) return 0;    //1. null값이 아니어야 함
        if(from==to && from.get(Calendar.DAY_OF_MONTH)==21) return 1;   //2. Date가 같고 일자가 21이면 1 반환, eqauls()를 사용하여도 됨.

        //3.monDiff와 5~6에 사용할 변수 만들기
        int toYear = to.get(Calendar.YEAR);
        int toMon = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);
        int fromYear = from.get(Calendar.YEAR);
        int fromMon = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int monDiff = (toYear*12+toMon) - (fromYear*12+fromMon);

        //4.
        if (monDiff<0) return 0;
        //5~6.
        if (fromDay<=21&&toDay>=21) monDiff++;
        if (fromDay>21&&toDay<21) monDiff--;

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print(sdf.format(fromDate)+" ~ "
                +sdf.format(toDate)+":"); System.out.println(paycheckCount(from, to));
    }

    public static void main(String[] args) { Calendar fromCal = Calendar.getInstance(); Calendar toCal = Calendar.getInstance();

        fromCal.set(2010,0,1); toCal.set(2010,0,1); printResult(fromCal, toCal);

        fromCal.set(2010,0,21); toCal.set(2010,0,21); printResult(fromCal, toCal);

        fromCal.set(2010,0,1); toCal.set(2010,2,1); printResult(fromCal, toCal);

        fromCal.set(2010,0,1); toCal.set(2010,2,23); printResult(fromCal, toCal);

        fromCal.set(2010,0,23); toCal.set(2010,2,21); printResult(fromCal, toCal);

        fromCal.set(2011,0,22); toCal.set(2010,2,21); printResult(fromCal, toCal);

    }
}

/*
<실행결과>
2010-01-01 ~ 2010-01-01:0
2010-01-21 ~ 2010-01-21:1
2010-01-01 ~ 2010-03-01:2
2010-01-01 ~ 2010-03-23:3
2010-01-23 ~ 2010-03-21:2
2011-01-22 ~ 2010-03-21:0
 */