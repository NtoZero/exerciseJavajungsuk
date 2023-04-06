// [11-7] 다음에 제시된 BanNoAscending클래스를 완성하여,
// ArrayList에 담긴 Student인스턴스들이 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.
// (반이 같은 경우 번호를 비교해서 정렬한다.)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student7 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student7(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public String toString() {
        return name
                + "," + ban
                + "," + no
                + "," + kor
                + "," + eng
                + "," + math
                + "," + getTotal()
                + "," + getAverage()
                ;
    }
} // class Student

class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2) {
        /*
        (1)	알맞은 코드를 넣어 완성하시오.
        */
        //🔥 o1과 o2 모두 형변환이 되는지 여부부터 검사한다.
        if(o1 instanceof Student7 && o2 instanceof Student7) {
            Student7 s1 = (Student7) o1;
            Student7 s2 = (Student7) o2;

            //🔥반이 같지 않다면 반 번호 차이를 리턴한다. ⭐사실 return은 하나이므로 이 조건식이 필요없다.
            if(s1.ban != s2.ban) return s1.ban - s2.ban;
            //🔥반이 같다면 학생 번호 차이를 리턴한다.
            else {
                return s1.no-s2.no;
            }
        } else {
            System.out.println("잘못된 데이터입니다.");
            return -1;
        }
    }
}

class Sol_Exercise11_7 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student7("이자바", 2, 1, 70, 90, 70));
        list.add(new Student7("안자바", 2, 2, 60, 100, 80));
        list.add(new Student7("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student7("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student7("김자바", 1, 2, 80, 80, 90));
        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}

/*
<실행결과>
남궁성,1,1,90,70,80,240,80.0
김자바,1,2,80,80,90,250,83.3
홍길동,1,3,100,100,100,300,100.0
이자바,2,1,70,90,70,230,76.7
안자바,2,2,60,100,80,240,80.0
 */

/*
풀이 접근
Comparator로 정렬 기능을 구현하는 문제이다.
BanNoAscending 비교자는 Comparator를 구현하며
이에 따라서 int compare(Object o1, Object o2)를 구현해야 한다.

반에 따라 오름차순으로 정렬하되, 반이 같다면 학생번호를 비교해서 음수, 0, 양수 조건을 추가하면 된다.

 */

/*
<모범 풀이>
public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            int result = s1.ban - s2.ban;

            if (result == 0) { //⭐ 반이 같으면, 번호를 비교한다.
                return s1.no - s2.no;
            }

            return result;
        }

        return -1;
    }

 */


