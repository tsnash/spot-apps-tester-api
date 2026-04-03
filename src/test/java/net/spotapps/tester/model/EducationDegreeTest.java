package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EducationDegreeTest {

    @ParameterizedTest
    @MethodSource("provideDifferentEducationDegrees")
    public void testEducationDegreeInequality(EducationDegree testEducationDegree1, EducationDegree testEducationDegree2) {
        assertNotEquals(testEducationDegree1, testEducationDegree2, "Different education degrees should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalEducationDegrees")
    public void testEducationDegreeEquality(EducationDegree testEducationDegree1, EducationDegree testEducationDegree2) {
        assertEquals(testEducationDegree1, testEducationDegree2, "Identical education degrees should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalEducationDegrees")
    public void testEducationDegreeHashcodeEquality(EducationDegree testEducationDegree1, EducationDegree testEducationDegree2) {
        assertEquals(testEducationDegree1.hashCode(), testEducationDegree2.hashCode(),
                "Identical education degrees should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentEducationDegrees() {
        EducationDegree educationDegree1 = new EducationDegree("Bachelor");
        educationDegree1.setEducationDegreeId(1L);

        EducationDegree educationDegree2 = new EducationDegree("Master");
        educationDegree2.setEducationDegreeId(2L);

        EducationDegree educationDegreeNull = null;

        return Stream.of(
                Arguments.of(educationDegree1, educationDegree2),
                Arguments.of(educationDegree1, educationDegreeNull));
    }

    private static Stream<Arguments> provideIdenticalEducationDegrees() {
        EducationDegree educationDegree1 = new EducationDegree("Bachelor");
        educationDegree1.setEducationDegreeId(1L);

        EducationDegree educationDegree2 = new EducationDegree("Bachelor");
        educationDegree2.setEducationDegreeId(2L);

        return Stream.of(
                Arguments.of(educationDegree1, educationDegree1),
                Arguments.of(educationDegree1, educationDegree2));
    }
}
