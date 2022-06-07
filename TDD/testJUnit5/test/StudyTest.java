import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.lang.annotation.*;
import java.time.Duration;

public class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    void create1() {
        System.out.println("create1");
    }

    /*

    // @BeforeAll, @AfterAll은 전체 테스트 시작과 끝에 수행할 코드를 작성한다.
    // @BeforeAll, @AfterAll은 반드시 메서드에 static void를 붙여주어야 한다.
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    // @BeforeEach, @AfterEach는 각각의 테스트 시작과 끝에 수행할 코드를 작성하면 된다.
    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    @Test
    @Disabled // 수행하고 싶지 않은 테스트에 대해 붙여주면 JUnit이 해당 테스트는 무시하게 된다.
    void create2() {
        System.out.println("create1");
    }
    */

    /*
    테스트 이름은 기본적으로 메서드 이름으로 지정된다.
    그래서 보통 다음과 같이 메서드 이름에 Snake Case를 사용한다.
    Camel Case에 비해 알아보기 쉽기 때문이다.
     */
    @Test
    void create_new_studyyy() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    void create_new_study_again() {
        System.out.println("create1");
    }

    /*
    @DisplayName
    테스트 이름을 보다 쉽게 표현할 수 있는 방법을 제공하는 애노테이션이다.
    @DisplayNameGeneration보다 우선 순위가 높다.
     */
    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = new Study(-10);

        // assert문들의 성공 유무를 확인하고 싶다면 asserAll()을 사용
        assertAll(
                // 값이 null이 아닌지 확인
                () -> assertNotNull(study),

                // asserEquals()는 메서드의 첫 번째 인자와 두 번째 인자가 같은지 확인한다.
                () -> assertEquals(StudyStatus.DRAFT, study.getStudyStatus(), () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."),

                // 다음 조건이 참(true)인지 확인
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

    @Test
    @DisplayName("스터디 만들기2")
    void create_new_study2() {
        Study study = new Study();
        // assertNotNull()은 인자가 null이 아니면 테스트를 통과
        assertNotNull(study);
        // assertTrue()는 인자가 True이면 테스트를 통과한다.
        assertTrue(1 < 2);
    }

    @Test
    @DisplayName("스터디 만들기3")
    void create_new_study3() {
        // assertThrows()는 특정 exception이 발생할 것으로 기대되는 상황에 대해서 테스트하는 메서드
        assertThrows(IllegalArgumentException.class, () -> new Study(-10));
    }

    // assertThrows()의 반환값으로 exception을 받아서 또 다른 테스트에 활용할 수 있다.
    @Test
    @DisplayName("스터디 만들기4")
    void create_new_study4() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-20));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
    }

    // assertTimeout()은 특정 로직이 특정 시간 안에 수행되도록 기대하는 테스트
    @Test
    @DisplayName("스터디 만들기5")
    void create_new_study5() {
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    // Jupiter가 제공하는 테스트 라이브러리 중 하나인 Assumptions의 assumTrue()를 사용
    @Test
    @DisplayName("스터디 만들기6")
    void create_new_study6() {
        String test_env = System.getenv("TEST_ENV");
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
    }

    // Assumptions를 활용해서 특정 조건에 따라 테스트를 실행하는 방법 => assumingThat()
    // if문처럼 환경변수의 값에 따라 다른 테스트 로직을 수행하도록 설정할 수 있다.
    @Test
    @DisplayName("스터디 만들기7")
    void create_new_study7() {
        String test_env = System.getenv("TEST_ENV");

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            System.out.println("local");
        });

        assumingThat("REMOTE".equalsIgnoreCase(test_env), () -> {
            System.out.println("remote");
        });
    }

    @Test
    @DisplayName("스터디 만들기8")
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void create_new_study8() {
        System.out.println("study");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    void create_new_study_again2() {
        System.out.println("again");
    }

    // @EnabledOnJre는 특정 자바 버전에 대해 테스트 코드를 수행
    @Test
    @DisplayName("스터디 만들기9")
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    void create_new_study9() {
        System.out.println("study");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.OTHER)
    void create_new_study_again3() {
        System.out.println("again");
    }

    // @EnabledEnvironmentVariable은 환경 변수에 따라 테스트를 수행
    @Test
    @DisplayName("스터디 만들기")
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void create_new_study10() {
        System.out.println("study");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.OTHER)
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "remote")
    void create_new_study_again4() {
        System.out.println("again");
    }

    // Junit5 태깅과 필터링
    /*
    @Tag를 사용해서 각각의 value 값을 다르게 설정
    첫 번째 테스트는 빠르게 끝낼 수 있어 fast,
    두 번째 테스트는 테스트 시간이 오래걸려 slow 태그를 달았다고 하자.
     */
    /* 태그만 실행
    1. 프로젝트 우측 상단에 "Edit Configurations" 메뉴를 클릭
    2. Build and run -> Tags 선택 -> 우측 블록에 태그 value 값 설정
    3. 실행항목을 이전에 설정한 Tags로 실행.
     */
    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create_new_study11() {
        System.out.println("fast");
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_new_study_again5() {
        System.out.println("slow");
    }


    // JUnit 5는 애노테이션을 조합하여 커스텀 태그를 만들 수 있다
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @Tag("fast")
    public @interface FastTest {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @Tag("slow")
    public @interface SlowTest {
    }

    /*
    @Target, @Retetion은 애노테이션을 만들 때 사용하는 메타 애노테이션이고,
    중요한건 @Test, @Tag를 붙임으로써 기존에 여러 애노테이션으로 설정했던 부분을
    하나의 애노테이션으로 설정한다는 것이다.
    아래 예제는 이전 예제와 같은 코드가 된다.
    */
    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study12() {
        System.out.println("fast");
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again6() {
        System.out.println("slow");
    }

    // 특정 테스트를 반복할 수 있다. 다음 예제는 반복 횟수를 10회로 설정했다.
    @RepeatedTest(10)
    void repeatTest() {
        System.out.println("test");
    }
    // @RepeatedTest는 반복 테스트의 이름을 설정할 수 있고, RepetitionInfo 인자를 받아서 반복 횟수를 출력할 수 있다.

}