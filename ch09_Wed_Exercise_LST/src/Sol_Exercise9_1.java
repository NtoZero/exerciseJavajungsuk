//[9-1] 다음과 같은 실행결과를 얻도록 SutdaCard클래스의 equals()를 멤버변수인 num, isKwang의 값을 비교하도록 오버라이딩하고 테스트 하시오.
class Sol_Exercise9_1 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3,true);
        SutdaCard c2 = new SutdaCard(3,true);

        System.out.println("c1="+c1);   //🌟toString()이 오버라이딩된 상태이므로, 주소값 출력이 아닌 iv값 출력을 한다.
        System.out.println("c2="+c2);
        System.out.println("c1.equals(c2):"+c1.equals(c2));
    }
}

class SutdaCard { int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) { this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj) {
    /*
    (1) 매개변수로 넘겨진 객체의 num, isKwang과
    멤버변수 num, isKwang을 비교하도록 오버라이딩 하시오.
    */
        //⭐형변환이 가능한지 검사해야한다. 💡가능하지 않다면 false를 리턴하는게 편하다!
        if(!(obj instanceof SutdaCard)) return false;
        //⭐다운 캐스팅 될 때는 (괄호)가 필수이다. 자손 참조변수가 조상객체를 담기 불안정하다.
        SutdaCard sc = (SutdaCard) obj;
        //⭐num값과 isKwang이 같을 때 true를, 아닐 때 false를 리턴한다.
        return (this.num==sc.num)&&(this.isKwang==sc.isKwang);
    }

    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
/*
<실행결과
c1=3K
c2=3K
c1.equals(c2):true
 */

/*
<⭐풀이 접근>
equals()를 오버라이딩하는 문제이다.
매개변수에 대한 유효성 검사는 반드시 진행해야 한다.
자손객체가 조상참조변수에 저장되기에는 안정적이지만,
조상객체가 자손참조변수에 저장되기에는 불안정적이다.(자손에 확장된 멤버가 존재한다면 아예 불가능하다.)
⭐따라서 형변환이 가능한지 instanceof를 통해서 검사해야한다.
⭐형변환이 가능하다면 캐스팅하여, 해당 클래스타입의 멤버를 사용할 수 있다.
  여기서는 그 멤버를 사용하여 각각의 iv값을 비교한 다음 같으면 equals를 리턴한다.

<추가적으로 생각할 것>
사실, equals()와 더불어서 hashCode()메소드 역시 오버라이딩 해야한다.
equals()를 통해 true가 나오면 hashCode() 역시 true가 나오도록 하는게 일반적인 규칙이다.

 */

/*
<정답>
public boolean equals(Object obj) {
    if(obj instanceof SutdaCard) {
        SutdaCard c = (SutdaCard)obj;
        return num==c.num && isKwang==c.isKwang;
}
    return false;
}

<풀이>
[해설] ⭐매개변수가 Object타입이므로 어떤 타입의 인스턴스도 매개변수로 가능하다. (업캐스팅은 얼마든지!)
⭐그래서 반드시 instanceof로 확인한 후에 형변환해서 멤버변수 num과 isKwang의 값을 비교해야한다.
만일 instanceof의 결과가 false라면 멤버변수의 값을 비교할 필요도 없이
그냥 false만 반환하면 된다.
 */

