# Inrtoduction
 본인의 코드나 팀 멤버 코드를 보고 '<b>정말 대단하군!, 고양이가 키보드 위를 걸어다닌 것 같은 코드 같지?</b>' 라고 생각한 적이 있나요? <br>
 그렇다면, 프로젝트의 코드를 깨끗하게 하는데에 시간을 쓸 필요가 분명히 있습니다. <br>
 왜냐하면 좋은 품질의 코드는 이해하기 쉽고, 수정하고 확장하기 쉽기 때문입니다.<br>
 [-10 Tips To Keep Your Code Clean written by.Ihor Sokolyk-](https://medium.com/oril/10-tips-to-keep-your-code-more-clean-2fa9aafea1cf)
<hr>
<hr>
<br>

# 자바 클린코드 원칙 
## 클린코드란? 
<b>가독성이 높은 코드</b><br>
가독성을 높이려면 다음과 같이 구현해야 한다.<br>

- 네이밍이 잘 되어야 함
- 오류가 없어야 함
- 중복이 없어야 함
- 의존성을 최대한 줄여야 함
- 클래스 혹은 메서드가 한가지 일을 해야 함
---
### 자바 코딩 규칙 (Java Code Convention) 을 지켜라
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Google Java Style Guide - newwisdom님 번역](https://newwisdom.tistory.com/96)
- [자바 코딩 규칙](https://myeonguni.tistory.com/1596) 
- [캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java/)
- IntelliJ 또는 Eclipse 통합 개발 도구에서 formatting을 한다.
---
<br>

## 네이밍 작성시 원칙
- 풀네임을 쓰는 것을 귀찮아 하지 말아라.
- 어떤 값을 위한 값인지를 나타내야 한다. (의도를 밝혀라)
    - 아래처럼 코드를 작성하면 다른사람도 알 수 없을 뿐더러 시간이 지나면 코드를 작성한 본인도 변수의 의미를 잊기 쉽다.
    ```
    public boolean check() {
        if (a < max) {
            return true;
        } else {
            return false;
        }
    }
    ```
    ```
    // 변수에 명확한 의미를 적어서 추후에 알기 쉽다.
    public boolean isAgeAcceptable() {
        if (userAge < maxAge) {
            return true;
        } else {
            return false;
        }
    }
    ```
- 비슷한 이름을 사용하지 않는다.
- 변수 이름에 타입을 넣지 않는다. (한눈에 들어오지 않는다.)
    ```
    XYZControllerForEfficientHandingOfStrings 
    XYZControllerForEfficientStorageOfStrings 
    ```
- 클래스 이름은 명사나 명사구가 좋다.
    ```
    PhoneNumber phoneString (x)
    List<Integer> accountList (x) → accounts
    ```
- 메서드 이름은 동사나 동사구가 좋다.

    ```
    Customer, Account, WikiPage 같은 이름은 좋다
    Manager, Data, Info 같은 이름은 피한다
    ```
- 기발한 이름은 피하고, 일관성 있는 어휘를 사용해라

---
### 변수와 메소드 선언시 위치
- 모든 클래스의 변수들은 클래스의 맨 위에 선언되어야 한다. 
- 이러한 접근은 변수들을 찾을 위치를 언제든 알 수 있고, 전체 클래스를 스크롤해서 선언된 곳을 찾을 필요가 없다.
---
<br>

## 함수 관련
### 메소드(함수)는 하나의 역할만 수행해야 한다.
- 하나의 메소드는 한개의 동작에만 관련이 있어야 한다. 
- 만약 메소드가 두개나 세개의 다른 것들을 한번에 한다면, 기능적으로 다른 메소드들로 나눌 것을 고려해야 한다.
- 그런 메소드는 더 이해하기 쉽고, 다른 메소드에서 재사용하기 쉽다.
- 예를들면, saveUserAndChargeCard() 라는 메소드가 있어서 데이터베이스에 유저를 저장하고, 그의 신용카드를 청구한다. 
- 이 메소드는 분명 나쁘다. 왜냐하면 'AND' 가 이름에 들어가서 두개의 액션을 한다. 
- And 나 Or 등의 글자를 피해라. saveUser() 과 chargeCard() 로 나눌 수 있다.

### 서술적인 이름을 사용해라
- 네이밍은 중요하다. 길어도 괜찮다. 이름을 정하는데 시간이 걸려도 괜찮다. 일관성 있게 함수가 하는 일을 잘 표현하는 이름을 사용해라.

### 적절한 인수값 (Parameter)
- 플래그 인수는 bool인수를 말한다. 
- 플래그 인수를 사용하자마자 함수는 참인지 거짓인지에 따라 두가지 일을 해야한다.
    ```
    render(bool isTest);
    ```
- 가장 이상적인 인수의 개수는 0개이다.
- 3개 이상의 인수는 가급적 피하는게 좋다.
- 삼항 함수나 이항 함수의 경우 인수값을 넣을 때 그 순서가 바뀌는 실수를 범할 수 있다.
    ```
    Circle makeCircle(double x , double y, double radius);

    //x, y 를 묶어 Point 클래스로
    Circle makeCircle(Point point, double radius);
    ```
### 객체의 상태를 변경한 후 출력하는 함수를 만들지마라
- 객체의 변경은 객체 내부에서만 하는 것이다. 다른 객체에게 변경이나 생성을 맡기려 하지마라.
    ```
    public class MovieRepository { 
        private static List<Movie> movies = new ArrayList<>();

        static { 
            Movie movie1 = new Movie(1, "생일", 8_000); 
            movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 12:00"), 6)); 
            movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 14:40"), 6)); 
            ...이하 생략 
            movies.add(movie1); 
        }
    ```
    영화 예매 목록을 담고 있는 객체이다.<br>
    Movie의 스케쥴을 추가하고 있는데, MovieRepo에서 추가하는 것이 아니라, Movie내의 메소드에서 추가하고 있다.
    <br>
    ```
    public class Movie { 
        private final int id; 
        private final String name; 
        private final int price; 

        private List<PlaySchedule> playSchedules = new ArrayList<>(); 

        void addPlaySchedule(PlaySchedule playSchedule) { 
            playSchedules.add(playSchedule); 
        } 
    }​
    ```
    엄연히 스케쥴을 관리해야 하는 것은 변수를 가지고 있는 Movie의 역할이다.
---

### 자료를 추상화하라
- 추상인터페이스를 이용하여 클래스를 생성하자. 
---
### 객체의 구조를 숨겨라
- private 변수를 선언 한다고, 구조를 숨기는 것이 아니다. 
- 객체는 내부에서 값을 얻고 변화하고 계산하고, 외부로 나오는 메소드는 그 결과값만 리턴하는 것. 이외의 다른 메소드들은 피하자.
- 객체 통체로 꺼내서 get메소드를 이용하지 마라
---

### 클래스, 메소드를 작게 유지하기 위해 노력했는가?
- 개발자들 사이에 메소드의 길이에 대한 표준 패턴은 없다.
- 보통 15줄의 코드를 이해하기 좋고 좋은 퀄리티로 만들어라.
---
### 코드를 최소화하라
- 한줄로 끝날 코드를 3줄로 풀어쓰지 말아라.
- 최고의 기능과 알고리즘을 만들겠지만, 나중에 코드 리뷰하는 사람들이 몇배나 적은 코드로 같은 것을 할 수 있기 때문에 리팩토링하려고 물어보지 않을거란 보장이없다.<br>

    다음 예시를 보자.
    ```
    boolean hasCreditCard(User user) {
        if (user.hasCard) {
            return true;
        } else {
            return false;
        }
    }
    ```
    다음과 같이 단순화 할 수 있다.
    ```
    boolean hasCreditCard(User user) {
        return user.hasCard;
    }
    ```
---
### 중복을 피해라
- 만약 다른곳에서 메소드를 재활용 할 수 없다면 좋은 코드가 아니다.
- 메소드는 재사용할 더 좋은 방법을 생각하고 가능하면 최대한 넓게 쓰여야 한다.
- 예시를 들면, 거의 같은 것을 구현한 두개의 메서드가 있고, 단지 1줄의 코드만 다르다면, 같은 기능을 추출하여 하나로 만든 후 두개를 연결해서 다른 조건 체크를 만드는 것이 좋다.
---
### 코멘트(주석)를 남겨라
- 매우 짧은 메소드가 아닌이상 복잡한 알고리즘이나, 코멘트가 다른 개발자들의 이해에 도움이 된다면 코멘드를 남기는 것은 괜찮다.
---


<br>

#### 클린코드 정리 블로그
- [클린코드 핵심 요약 및 정리 - 망나니개발자님 기술블로그](https://mangkyu.tistory.com/132)
- [클린코드(Clean Code) 시리즈 - 바닐라라떼중독자님 기술블로그](https://bang-jh.tistory.com/7?category=971942)
- [클린코드(Clean Code) 시리즈 - Aaron님 기술블로그](https://data-make.tistory.com/632?category=453633)
---
---
<br>

# 리팩토링
## 리팩토링이란?
<b>리팩토링은 사용하지 않는 코드 또는 중복된 코드를 지우고, 코드의 로직을 깨끗하고 이해하기 쉽게 디자인하는 것</b><br>

### 리팩토링이 필요한 코드는 다음과 같다
- 중복 코드
- 긴 메소드
- 거대한 클래스
- switch 문
- 절차지향으로 구현한 코드
---
### else 예약어를 쓰지 않았는가?

---
### 모든 원시값과 문자열을 포장했는가?

---
### 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [일급 컬렉션 (First Class Collection)의 소개와 써야할 이유 - 향로님 기술블로그](https://jojoldu.tistory.com/412)
---
### 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
* 쉽지 않은 연습일 수 있다. 가능하면 인스턴스 변수의 수를 줄이기 위해 노력한다.

---
### getter/setter 없이 구현했는가?
* 핵심 로직을 구현하는 도메인 객체에 getter/setter를 쓰지 않고 구현했는가?
* 단, DTO는 허용한다.

---
### 메소드의 인자 수를 제한했는가? 
* 4개 이상의 인자는 허용하지 않는다.
* 3개도 가능하면 줄이기 위해 노력해 본다.

---
### 코드 한 줄에 점(.)을 하나만 허용했는가?
* 디미터(Demeter)의 법칙(“친구하고만 대화하라”)을 지켰는가?
* 예를 들어 location.current.representation.substring(0, 1)와 같이 여러 개의 점(.)이 등장하면 리팩토링할 부분을 찾아본다.

---
### 한 메서드에 오직 한 단계의 들여쓰기(indent)만 허용했는가?

---
---
<br>

# 클린코드와 리팩토링의 차이점
- 가깝게 본다면 리팩터링과 클린 코드에 차이점이 별로 없어 보인다.
- 하지만 좀 더 멀리 떨어져서 본다면 리팩터링이 더 큰 의미를 가지는 것처럼 보인다.
- 클린 코드는 단순하게 가독성을 높이기 위한 작업
- 리팩터링은 클린 코드를 포함하여 유지보수를 위한 코드의 개선
- 클린 코드와 같은 부분은 설계단계에서 잘 이루어져 있는 것이 중요함
- 리팩토링은 결과물이 나온 이후 수정이나 추가 작업이 진행될 때 개선해야함

---
---
<br>

# 출처 및 참고한 곳

- [woowacourse-docs](https://github.com/woowacourse/woowacourse-docs/blob/master/cleancode/pr_checklist.md)
- [출처: 클린코드와 리팩토링 - 규글님 기술블로그](https://kim6394.tistory.com/213)
- [출처: 코드 리팩토링에 대해서 알아보자 - 수구리님 기술블로그](https://tasddc.tistory.com/85)
- [출처: 클린코드와 코드 리팩토링 - devuna님 기술블로그 (튜나 개발일기)](https://devuna.tistory.com/26)
- [10 Tips To Keep Your Code Clean](https://medium.com/oril/10-tips-to-keep-your-code-more-clean-2fa9aafea1cf)
- [클린 코드, 클린 코드 40 가지 원칙! - ordinCode님 기술블로그](https://ocblog.tistory.com/84)
---
---
<br>

# 추가로 읽어보면 좋은 것들
- [코딩할 때 자주 사용되는 패턴과 스탭 줄이는 방법 - 명월님 기술블로그](https://nowonbun.tistory.com/380)
- [코딩 스타일 설정(Google Standard coding style) - 명월님 기술블로그](https://nowonbun.tistory.com/378?category=636956)