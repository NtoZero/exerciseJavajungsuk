////[12-3] 다음 중 올바르지 않은 문장을 모두 고르시오.
//
//        a.	Box<?> b = new Box();
//        b.	Box<?> b = new Box<>();
//        c.	Box<?> b = new Box<Object>();
//        d.	Box<Object> b = new Box<Fruit>(); ❌ 앞, 뒤 지네릭이 일치해야 한다.
//        e.	Box	b = new Box<Fruit>(); ❌ 참조변수쪽에 <Fruit>을 붙이고 생성자는 생략 가능
//        f.	Box<? extends Fruit> b = new Box<Apple>();
//        g.	Box<? extends Object> b = new Box<? extends Fruit>();


/*[정답] c, d, g
        [해설]
        a.	Box<?> b = new Box(); // OK. Box<?>는 Box<? extends Object>를 줄여쓴 것이다. 객
        체 생성에 지네릭 타입을 지정해 주지 않았지만 문제가 되지는 않는다. Box()대신 new Box<>()를 사용하는 것이 좋다.
        그래도, new
        b.	Box<?> b = new Box<>(); // OK. new Box<>();는 타입을 생략한 것으로, 일반적으로는
        참조변수의 타입과 같은 타입으로 간주된다.
        참조변수의 타입이
        <?>, 즉
        <? extends Object>이므로 생략된 타입은
        Object이라고 생각하기 쉬운데,
        여기서는 지네릭 클래스
        Box에 정의된 타입이 <T extends Fruit>와 같이 제한되어 있기 때문에, 'Object'가 아니
        라‘Fruit'이 생략된 것으로 봐야 한다.
        그래서
        Box<?> b = new Box<Object>();와 같이
        하면 에러가 발생한다. Object는 Fruit의 자손이 아니기 때문이다.
        ‘Box<? extends Object>’는 Box<Object>와 같지 않음에 주의하자. 지네릭 클래스 Box는
        타입 T가
        Fruit의 자손으로 제한되어 있기 때문에, Box<Object>와 같이
        Fruit의 자손이
        아닌 클래스를 대입할 수 없다. 그러나, 'Box<? extneds Object>'와 같이 와일드 카드를 사용하는 것은 가능하다.
        c.	Box<?> b = new Box<Object>();	// 에러 b의 설명 참조
        d.	Box<Object> b = new Box<Fruit>(); // 에러. 타입 불일치
        e.	Box	b = new Box<Fruit>(); // OK. 바람직하지 않음.‘Box<?> b’가 더 나음.
        f.	Box<? extends Fruit> b = new Box<Apple>(); // OK.
        g.	Box<? extends Object> b = new Box<? extends Fruit>(); // 에러. new연산자는 타입 이 명확해야하므로 와일드 카드와 같이 사용불가*/
