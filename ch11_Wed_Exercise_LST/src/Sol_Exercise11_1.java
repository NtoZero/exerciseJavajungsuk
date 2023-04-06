import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// [11-1] 다음은 정수집합 1,2,3,4와 3,4,5,6의 교집합, 차집합, 합집합을 구하는 코드이다.
// 코드를 완성하여 실행결과와 같은 결과를 출력하시오.
// [Hint] ArrayList클래스의 addAll(), removeAll(), retainAll()을 사용하라.
public class Sol_Exercise11_1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList kyo = new ArrayList();    //교집합
        ArrayList cha = new ArrayList();    //차집합
        ArrayList hap = new ArrayList();    //합집합

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        /*
            (1) 알맞은 코드를 넣어 완성하시오.
         */

        //0. ArrayList ➡️ Collection 변환하여 addAll(합집합), removeAll(차집합), retainAll(교집합) ~~containsAll(교집합) => boolean형 반환이라 불가능~~ 비교
        //🔥🔥 Collection으로 변환할 필요가 없다. 왜냐하면 Collection 인터페이스는 Set, List가 이미 구현한 조상 인터페이스이기 때문이다.
        Collection c1 = list1;
        Collection c2 = list2;

        //1. 반복자에 각 객체 담기
        /*Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();*/

        //2. 교집합 (contains(Object obj)를 사용하는법)
        /*while(it1.hasNext()) {
            Object tmp = it1.next();
            if(list2.contains(tmp)) {
                kyo.add(tmp);
            }
        }*/
        // ⭐2. 교집합 retainAll(Collection c)를 사용하는 법
        //kyo = list2.retainAll(c1);
        kyo.addAll(c2);
        kyo.retainAll(c1);

        // ⭐3. 차집합 removeAll(Collection c)를 사용하는 법
        cha.addAll(c2);
        cha.removeAll(c1);  //c2에서 c1의 요소만 지움

        // ⭐4. 합집합 addAll(Collection c)를 사용하는 법
        hap.addAll(c1);
        hap.addAll(cha);    //c1에 c2의 독립 요소만 추가함

        System.out.println("list1="+list1);
        System.out.println("list2="+list2);
        System.out.println("kyo="+kyo);
        System.out.println("cha="+cha);
        System.out.println("hap="+hap);
    }
}


/*
<정답>
import java.util.*;

class Exercise11_1 {
    public static void main(String[] args) { ArrayList list1 = new ArrayList(); ArrayList list2 = new ArrayList(); ArrayList kyo = new ArrayList(); // 교집합 ArrayList cha = new ArrayList(); // 차집합 ArrayList hap = new ArrayList(); // 합집합

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        kyo.addAll(list1);	// list1의 모든 요소를 kyo에 저장한다.
        kyo.retainAll(list2); // list2와 kyo의 공통요소만 남기고  삭제한다.

        cha.addAll(list1);
        cha.removeAll(list2); // cha에서  list2와  공통된 요소들을  모두  삭제한다.


        hap.addAll(list1); hap.removeAll(kyo); hap.addAll(list2);

// list1의 모든 요소를 hap에 저장한다.
// hap에서 kyo와 공통된 모든 요소를 삭제한다.
// list2의 모든 요소를 hap에 저장한다.


        System.out.println("list1="+list1); System.out.println("list2="+list2); System.out.println("kyo="+kyo); System.out.println("cha="+cha); System.out.println("hap="+hap);
    }
}

 */