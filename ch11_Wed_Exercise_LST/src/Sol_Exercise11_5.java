// [11-5] 다음에 제시된
// Student클래스가 Comparable인터페이스를 구현하도록 변경해서
// 이름(name)이 기본 정렬기준이 되도록 하시오.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
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
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
                + "," + getTotal() + "," + getAverage();
    }

    @Override
    public int compareTo(Object o) {
        //⭐⭐Object o로 받는 것은 해당 Student 객체이어야 하므로 다운캐스팅한다.
        Student6 tmp = (Student6) o;
        //⭐String 클래스에서 구현된 문자열 비교자를 활용한다. (⭐String.compareTo(String anotherString))
        return this.name.compareTo(tmp.name);
    }
}

class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student6("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student6("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student6("김자바", 1, 3, 80, 80, 90));
        list.add(new Student6("이자바", 1, 4, 70, 90, 70));
        list.add(new Student6("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator it = list.iterator();

        while (it.hasNext()) System.out.println(it.next());

    }
}


/*
<실행결과>
김자바,1,3,80,80,90,250,83.3
남궁성,1,2,90,70,80,240,80.0
안자바,1,5,60,100,80,240,80.0
이자바,1,4,70,90,70,230,76.7
홍길동,1,1,100,100,100,300,100.0
 */

/*
<풀이 접근>
Comparable과 Comparator는 서로 유사하지만 다른 방식의 정렬이다.
Comparable은 해당 클래스에 대한 기본 정렬 방식을 구현한다.
추상 메서드 public int compareTo(Object o)를 구현해 비교하며,
음수가 나오면 기준이 더 적고, 0이 나오면 같은 크기, 양수가 나오면 기준이 더 큰 것을 의미한다.

Comparator는 기본 정렬방식이 아닌 별도의 정렬방식를 구현하기 위해서 Comparator를 구현하는 별도의 비교자 클래스를 만든다.
int compare(T o1, T o2); 추상메서드를 구현해야 한다.
o1과 o2의 비교를 원하는 방식으로 구현하여 마찬가지로,
음수면 기준이 더 적음. 0이면 같음, 양수면 기준이 더 큼의 방식으로 진행된다.

⭐Comparable을 통해서 정렬을 구현해야 하므로,
int compare(Object o)를 구현한다.
이름(name)을 기준으로 비교하는데, 문자열은 공백, 숫자, 대문자, 소문자 순으로 크다.
문자열 String 클래스에서는 이미 Comparable을 구현하면서 int compareTo(String anotherString)을 구현했으므로,
해당 메서드를 재사용해 리턴해주면 될 것이다.
 */

/*
<모범 풀이>
class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
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
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
                + "," + getTotal() + "," + getAverage();
    }

    public int compareTo(Object o) {
        if (o instanceof Student) { //⭐형변환 검사를 해야한다. 그렇지 않으면 예외 발생가능
            Student tmp = (Student) o;

            return name.compareTo(tmp.name); // String클래스의 compareTo()를 호출
        } else {
            return -1;  //⭐ Object로 받는 객체가 Student 클래스가 아니면, 애초에 name을 비교할 수 없다.
        }
    }
}

class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student("김자바", 1, 3, 80, 80, 90));
        list.add(new Student("이자바", 1, 4, 70, 90, 70));
        list.add(new Student("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list); // list에 저장된 요소들을 정렬한다.(compareTo()호출) Iterator it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}

<해설>
⭐Collections.sort(List list)를 이용하면 ArrayList에 저장된 요소들을 쉽게 정렬 할 수 있다.
    Collections.sort(list); // list에 저장된 요소들을 정렬한다.(compareTo()호출)
⭐그러나 한 가지 조건이 있다. ArrayList에 저장된 요소들은 모두 Comparable인터페이스를 구현한 것이어야 한다는 것이다.
이 인터페이스에는 compareTo메서드가 정의되어 있는데, 이 메서드는 Collections.sort(List list)에 의해 호출되어 정렬기준을 제공하게 된다
    public interface Comparable {
        public int compareTo(Object o); // ⭐주어진 객체(o)와 자신의 멤버변수를 비교
    }

⭐compareTo메서드는 매개변수로 주어진 객체(o)를 인스턴스자신과 비교해서 자신이 작으면 음수를, 같으면 0을, 크면 양수를 반환하도록 구현되어야 한다.
문제에서는 학생의 이름으로 정렬될 것을 요구했으므로, 인스턴스변수 name만 비교하도록 compareTo메서드를 구현하면 된다.
문자열 name을 어떻게 비교하도록 구현해야할까?
고민되겠지만, ⭐String클래스에는 이미 문자열 비교를 위한 compareTo메서드를 구현해 놓았고
우리는 단지 그것을 활용하기만 하면 된다.
    public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence
    {
    ...

    class Student implements Comparable {
    ...
    public int compareTo(Object o) { if(o instanceof Student) {
    Student tmp = (Student)o;
    return name.compareTo(tmp.name); // String클래스의 compareTo()를 호출
    } else {
    return -1;
    }
    }

 */

/*
<참고>
참고로 지네릭스(generics)를 적용한 예제를 추가한다. 어떤 차이가 있는지 잘 비교해 보 자.
아직 지네릭스를 배우지 않았으므로, 나중에 지네릭스를 배우고 나서 봐도 좋다.

import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
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
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
                + "," + getTotal() + "," + getAverage();
    }

    public int compareTo(Student s) {
        return name.compareTo(s.name);
    }
}

class Exercise11_5_2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student("김자바", 1, 3, 80, 80, 90));
        list.add(new Student("이자바", 1, 4, 70, 90, 70));
        list.add(new Student("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator it = list.iterator();

        while (it.hasNext()) System.out.println(it.next());
    }
}

 */

