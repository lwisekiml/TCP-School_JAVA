/*
# 제네릭의 개념
제네릭(generic)이란?
데이터의 타입(data type)을 일반화한다(generalize)는 것을 의미
클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법
컴파일 시에 미리 타입 검사(type check)를 수행하면 다음과 같은 장점이 있음

1. 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있음
2. 반환값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있음

JDK 1.5 이전에서는 여러 타입을 사용하는 대부분의 클래스나 메소드에서 인수나 반환값으로 Object 타입을 사용
이 경우에는 반환된 Object 객체를 다시 원하는 타입으로 타입 변환해야 하며, 이때 오류가 발생할 가능성 존재
JDK 1.5부터 도입된 제네릭을 사용하면 컴파일 시에 미리 타입이 정해지므로, 타입 검사나 타입 변환과 같은 번거로운 작업을 생략 가능

# 제네릭의 선언 및 생성
클래스와 메소드에만 다음과 같은 방법으로 선언 가능

class MyArray<T> {
    T element;
    void setElement(T element) { this.element = element; }
    T getElement() { return element; }
}

위의 예제에서 사용된 'T'를 타입 변수(type variable)라고 하며, 임의의 참조형 타입을 의미
꼭 'T'뿐만 아니라 어떠한 문자를 사용해도 상관없으며, 여러 개의 타입 변수는 쉼표(,)로 구분하여 명시할 수 있음
타입 변수는 클래스에서뿐만 아니라 메소드의 매개변수나 반환값으로도 사용할 수 있음

위와 같이 선언된 제네릭 클래스(generic class)를 생성할 때에는 타입 변수 자리에 사용할 실제 타입을 명시해야 함
MyArray<Integer> myArr = new MyArray<Integer>();

위의 예제는 MyArray 클래스에 사용된 타입 변수로 Integer 타입을 사용하는 예제
위처럼 제네릭 클래스를 생성할 때 사용할 실제 타입을 명시하면, 내부적으로는 정의된 타입 변수가 명시된 실제 타입으로 변환되어 처리

자바에서 타입 변수 자리에 사용할 실제 타입을 명시할 때 기본 타입을 바로 사용할 수는 없음
위 예제의 Integer와 같이 래퍼(wrapper) 클래스를 사용해야  함

Java SE 7부터 인스턴스 생성 시 타입을 추정할 수 있는 경우에는 타입을 생략할 수 있음
MyArray<Integer> myArr = new MyArray<>(); // Java SE 7부터 가능함.
 

제네릭에서 적용되는 타입 변수의 다형성을 보여주는 예제
*/
import java.util.*;

class LandAnimal { public void crying() { System.out.println("육지동물"); } }
class Cat extends LandAnimal { public void crying() { System.out.println("냐옹냐옹"); } }
class Dog extends LandAnimal { public void crying() { System.out.println("멍멍"); } }
class Sparrow { public void crying() { System.out.println("짹짹"); } }

class AnimalList<T> {
    ArrayList<T> al = new ArrayList<T>();

    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}

public class Generic {
    public static void main(String[] args) {
        AnimalList<LandAnimal> landAnimal = new AnimalList<>(); // Java SE 7부터 생략가능함.

        landAnimal.add(new LandAnimal());
        landAnimal.add(new Cat());
        landAnimal.add(new Dog());
        // landAnimal.add(new Sparrow()); // 오류가 발생함.

        for (int i = 0; i < landAnimal.size() ; i++) {
            landAnimal.get(i).crying();
        }
    }
}

/*
위의 예제에서 Cat과 Dog 클래스는 LandAnimal 클래스를 상속받는 자식 클래스이므로,
AnimalList<LandAnimal>에 추가할 수 있으나 Sparrow 클래스는 타입이 다르므로 추가할 수 없음

# 제네릭의 제거 시기
컴파일 시 컴파일러에 의해 자동으로 검사되어 타입 변환 됨
코드 내의 모든 제네릭 타입은 제거되어, 컴파일된 class 파일에는 어떠한 제네릭 타입도 포함되지 않게 됨
이런 식으로 동작하는 이유는 제네릭을 사용하지 않는 코드와의 호환성을 유지하기 위함
*/