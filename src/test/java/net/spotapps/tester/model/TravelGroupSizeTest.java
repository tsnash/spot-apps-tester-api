package net.spotapps.tester.model;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TravelGroupSizeTest {

    @ParameterizedTest
    @MethodSource("provideDifferentTravelGroupSizes")
    public void testTravelGroupSizeInequality(TravelGroupSize testTravelGroupSize1, TravelGroupSize testTravelGroupSize2) {
        ModelTestHelper.assertInequality(testTravelGroupSize1, testTravelGroupSize2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelGroupSizes")
    public void testTravelGroupSizeEquality(TravelGroupSize testTravelGroupSize1, TravelGroupSize testTravelGroupSize2) {
        ModelTestHelper.assertEquality(testTravelGroupSize1, testTravelGroupSize2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelGroupSizes")
    public void testTravelGroupSizeHashcodeEquality(TravelGroupSize testTravelGroupSize1, TravelGroupSize testTravelGroupSize2) {
        ModelTestHelper.assertHashcodeEquality(testTravelGroupSize1, testTravelGroupSize2);
    }

    private static Stream<Arguments> provideDifferentTravelGroupSizes() {
        TravelGroupSize travelGroupSize1 = new TravelGroupSize("Solo");
        travelGroupSize1.setTravelGroupSizeId(1L);

        TravelGroupSize travelGroupSize2 = new TravelGroupSize("Couple");
        travelGroupSize2.setTravelGroupSizeId(2L);

        TravelGroupSize travelGroupSizeNull = null;

        return Stream.of(
                Arguments.of(travelGroupSize1, travelGroupSize2),
                Arguments.of(travelGroupSize1, travelGroupSizeNull));
    }

    private static Stream<Arguments> provideIdenticalTravelGroupSizes() {
        TravelGroupSize travelGroupSize1 = new TravelGroupSize("Solo");
        travelGroupSize1.setTravelGroupSizeId(1L);

        TravelGroupSize travelGroupSize2 = new TravelGroupSize("Solo");
        travelGroupSize2.setTravelGroupSizeId(2L);

        return Stream.of(
                Arguments.of(travelGroupSize1, travelGroupSize1),
                Arguments.of(travelGroupSize1, travelGroupSize2));
    }
}
