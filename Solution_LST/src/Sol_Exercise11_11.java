//   [11-11] 다음은 SutdaCard클래스를
//   HashSet에 저장하고 출력하는 예제이다.
//   HashSet에 중복된 카드가 저장되지 않도록 SutdaCard의 hashCode()를 알맞게 오버라이딩하시오.
//   [Hint] String클래스의 hashCode()를 사용하라.

import java.util.*;

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard13) {
            SutdaCard13 c = (SutdaCard13) obj;
            return num == c.num && isKwang == c.isKwang;
        } else {
            return false;
        }
    }

    //🔥 hashCode() 오버라이딩
    @Override
    public int hashCode() {
        //🔥1. String 클래스의 hashCode()를 그대로 이용하는 방법
        //return this.toString().hashCode();

        //🔥2. Objects.hash() 사용하기. 자바.유틸의 Object's'임을 확인!
        return Objects.hash(this.num, this.isKwang);

        //🔥3. SutdaCard에 구현되어있는 eqauls()이용해서 hashCode 만들어 반환하기
        // 인자값이 없는 hashCode()메서드라 구현이 불가능. 다른 곳에서 직접 만들어줘야 함.
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

class Sol_Exercise11_11 {
    public static void main(String[] args) {
        SutdaCard13 c1 = new SutdaCard13(3, true);
        SutdaCard13 c2 = new SutdaCard13(3, true);
        SutdaCard13 c3 = new SutdaCard13(1, true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}


/*
<실행결과>
[3K, 1K]
 */

/*
<🔥풀이접근>
HashSet의 특성에 대해 이해하고 있어야 하는 문제이다.
HashSet은 Set을 해싱 방식으로 구현한 자료구조이며,
해싱이란 배열 + 링크드 리스트의 조합을 의미한다. 키값에 따라 다른 해시코드를 반환한다. (해싱 과정에서 손실이 발생하지 않는다면)
배열 인덱스는 서랍의 위치, 링크드 리스트 객체는 서랍이며, 각 노드들은 서류가 될 것이다.
기본적으로 Set을 구현하기 때문에 HashSet 역시 중복을 허용하지 않는다.
이 중복X 특성을 구현하기 위하여 HashSet은 기존 객체와 새 객체의 equals와 hashCode의 값이 같은지 여부를 살핀다.
🔥equals메서드가 true가 나온다면 반드시 두 객체의 hashCode 값이 같아야 한다.

🔥현 상황에서 Sutda 클래스에서 equals메서드는 iv값을 비교하는 것으로 재정의 되어 있지만,
int hashCode() 메서드는 재정의 되어 있지 않기 때문에 HashSet을 사용했음에도 불구하고
3K로 동일한 iv를 가지고 있는 객체를 서로 다른 객체로 인식한다.
따라서 [1K, 3K, 3K]를 출력하게 되는 것이다.

🔥결론적으로, Sutda 클래스에 동일한 iv값을 가지고 있으면 동일한 hashCode()를 반환하도록 int hashCode()를 오버라이딩하면 된다.
앞의 조건은 equals()로 구현하였으므로 equals를 통한 조건식을 사용하던지, Object.hash(iv, iv)를 사용한다. ❓ Object.hash() 자동완성이 안되는데? Objects였다...
또는 String에 구현되어있는 hashCode()를 이용해서 this.toString.hashCode()를 사용하면 될 것이다.

<참고>
[Java Objects.hash() 대 Objects.hashCode()](https://www.baeldung.com/java-objects-hash-vs-objects-hashcode)
 */

/*
<해설>
[해설]
hashCode()의 기본 구현은 클래스이름과 메모리주소와 관련된 정수값으로 이루어져 있기 때문에,
⭐두 객체의 hashCode()값은 절대로 같을 수가 없다.(서로 다른 두 객체가 같은 메모리 번지에 존재할 수 없기 때문에)
⭐대부분의 경우 서로 다른 객체라도 클래스의 인스턴스변수 값이 같으면,
예를 들어 SutdaCar의 경우 num과 isKwang의 값이 같으면 같은 객체로 인식해야한다.
⭐즉, equals()의 결과가 true이어야하고, 두 객체의 해시코드(hashCode()를 호출한 결과)가 같아야 한다.
그래서 equals()와 hashCode()를 적절히 오버라이딩 해줘야 한다.

때로는 equals()만 오버라이딩해줘도 되지만,
⭐해시알고리즘을 사용하는 HashSet에 담을 때는 반드시 hashCode()도 오버라이딩해줘야 한다.
이 문제의 실행결과를 보면 중복을 허용하지 않는 HashSet을 사용하고도 [1K, 3K, 3K]와 같은 결과를 얻는다.
그 이유는 hashCode()를 오버라이딩 하지 않았기 때문이다.
그러나 hashCode()를 오버라이딩한 후에는 [3K, 1K]와 같이 중복이 제거된 결과를 얻을수 있다.

hashCode()를 오버라이딩하라고 하면 어떻게 해야 할지 막막할 것이다.
그러나 걱정하지 말자. 이미 다 구현되어 있으니 그냥 가져다 쓰기만 하면 된다.
⭐⭐String클래스의 hashCode()는 객체의 주소가 아닌 문자열의 내용을 기반으로 해시코드를 생성하므로
문자열의 내용이 같으면 항상 같은 값의 해시코드를 반환한다.

SutdaCard의 toString()이 num과 isKwang의 값으로 문자열을 만들어 반환하기 때문에,
toString()을 호출한 결과에 hashCode()를 호출함으로써
SutdaCard의 hashCode()를 간단히 구현할 수 있었다.

    public String toString() {
        return num + ( isKwang ? "K":"");
    }

    public int hashCode() {
        return toString().hashCode(); // String클래스의 hashCode()를 호출한다.

    }

 */


