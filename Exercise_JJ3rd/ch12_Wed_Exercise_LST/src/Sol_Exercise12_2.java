//[12-2] 지네릭 메서드 makeJuice()가 아래와 같이 정의되어 있을 때, 이 메서드를 올바르게 호출한 문장을 모두 고르시오.
// (Apple과 Grape는 Fruit의 자손이라고 가정하자.)

class Juicer {
    //⭐ T는 Fruit을 상속받는 클래스타입이 와야한다.
    static <T extends Fruit> String makeJuice(FruitBox<T> box) {
        String tmp = "";
        for (Fruit f : box.getList()) tmp += f + " ";
        return tmp;
    }
}

//        a.	Juicer.<Apple>makeJuice(new FruitBox<Fruit>()); ❌ (리턴타입 제네릭이 더 자손클래스)
//        b.	Juicer.<Fruit>makeJuice(new FruitBox<Grape>()); ⭕
//        c.	Juicer.<Fruit>makeJuice(new FruitBox<Fruit>()); ⭕
//        d.	Juicer.makeJuice(new FruitBox<Apple>()); ⭕
//        e.	Juicer.makeJuice(new FruitBox<Object>()); ❌ (Object는 Fruit을 상속받지 않음)

/*
⭐ 해당 문제는 Juicer 클래스의 지네릭 메서드에 대한 내용이다.
<T extends Fruit>로 지네릭 제약이 걸려있다는 점이 중요하다.
FruitBox<T> box로 전달받은 타입은 Fruit이거나 Fruit을 상속받는 Apple, Grape이어야 한다.
단, 리턴 타입 앞에 있는 타입이 더 조상클래스이어야 한다. 따라서 a는 성립하지 않는다.
 */

/*
<정답>
[정답] c, d


[해설]
a.	Juicer.<Apple>makeJuice(new FruitBox<Fruit>()); // 에러. 지네릭 메서드에 대입된 타입이 Apple이므로,
이 메서드의 매개변수는 'FruitBox<Apple>'타입이 된다. new FruitBox<Fruit>()는 매개변수의 타입과 일치하지 않으며, 자동형변환도 불가능한 타입이 므로 에러이다.

b.	Juicer.<Fruit>makeJuice(new FruitBox<Grape>()); // Grape가 Fruit의 자손이라고 해도 라고 해도, 타입이 다르기 때문에 같은 이유로 에러.

c.	Juicer.<Fruit>makeJuice(new FruitBox<Fruit>()); // OK.
d.	Juicer.makeJuice(new FruitBox<Apple>()); // OK. 지네릭 메서드의 타입 호출이 생략된 형태. 생략하지 않았다면, ‘Juicer.<Apple>makeJuice(new FruitBox<Apple>());'과 같다. 대부분의 경우 이처럼 생략한다.
e.	Juicer.makeJuice(new FruitBox<Object>()); // 에러. 지네릭 메서드의 타입 호출이 생략되지 않았다면, ‘Juicer.<Object>makeJuice(new FruitBox<Object>());'과 같다.
// d 번의 경우와같이 타입이 일치하긴 하지만, <T extends Fruit>로 제한이 걸려있으므로, 타 입 T는 Fruit의 자손이어야 한다. Object는 Fruit의 자손이 아니므로 에러.

 */