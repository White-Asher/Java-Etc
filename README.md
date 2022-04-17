# 자바 클린코드 원칙 

## 클린코드란? 
<b>가독성이 높은 코드</b><br>
가독성을 높이려면 다음과 같이 구현해야 한다.<br>

- 네이밍이 잘 되어야 함
- 오류가 없어야 함
- 중복이 없어야 함
- 의존성을 최대한 줄여야 함
- 클래스 혹은 메서드가 한가지 일을 해야 함

[출처: 클린코드와 리팩토링 - 규글님 기술블로그](https://kim6394.tistory.com/213)

---
### 자바 코딩 규칙 (Java Code Convention) 을 지켜라
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Google Java Style Guide - newwisdom님 번역](https://newwisdom.tistory.com/96)
- [자바 코딩 규칙](https://myeonguni.tistory.com/1596) 
- [캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java/)
- IntelliJ 또는 Eclipse 통합 개발 도구에서 formatting을 한다.
---
### 한 메서드에 오직 한 단계의 들여쓰기(indent)만 허용했는가?

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
### 메소드가 한가지 일만 담당하도록 구현했는가?

---
### 클래스를 작게 유지하기 위해 노력했는가?
---
<br>

# 리팩토링

## 리팩토링이란?
<b>리팩토링은 사용하지 않는 코드 또는 중복된 코드를 지우고, 코드의 로직을 깨끗하고 이해하기 쉽게 디자인하는 것</b><br>


[출처: 코드 리팩토링에 대해서 알아보자 - 수구리님 기술블로그](https://tasddc.tistory.com/85)

---

### 출처 및 참고한 곳
- [woowacourse-docs](https://github.com/woowacourse/woowacourse-docs/blob/master/cleancode/pr_checklist.md)