//[12-1] 클래스 Box가 다음과 같이 정의되어 있을 때, 다음 중 오류가 발생하는 문장은? 경고가 발생하는 문장은?
class Box<T> { // 지네릭 타입 T를 선언
    T item;

    void setItem(T item) { this.item = item; }
    T getItem() { return item; }
}

//    a.Box<Object> b = new Box<String>();
//    b.Box<Object> b = (Object) new Box<String>();
//    c.new Box<String>().setItem(new Object());
//    d.new Box<String>().setItem("ABC");

/*
<문제풀이>
a. 는 오류가 발생한다. 참조변수와 생성자의 제네릭은 동일해야 한다.
b. 도 오류가 발생한다. 참조변수와 생성자 제네릭이 일치하지 않으며, 원시타입의 객체를 형변환 하는 것은 의미가 없다.
c. 도 오류가 발생한다. Box<String>객체를 통해서 T->String으로 변화했는데, Object 객체는 String 타입에 담기지 않는다. (조상객체 ->자손 참조변수X)
d. 는 오류가 발생하지 않는다. T-> String 타입으로 바뀌어 정상적으로 item을 "ABC"로 지정할 수 있다.
 */