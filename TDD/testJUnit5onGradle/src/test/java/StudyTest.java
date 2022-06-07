import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.lang.annotation.*;
import java.time.Duration;

public class StudyTest {

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @NullAndEmptySource
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @Test
    @Order(2)
    void create_new_study() {
        System.out.println("first test");
    }

    @Test
    @Order(1)
    void create_new_study_again() {
        System.out.println("second test");
    }
}