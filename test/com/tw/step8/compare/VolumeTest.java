package com.tw.step8.compare;

import com.tw.step8.compare.exception.InvalidStandardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

  @Test
  void shouldReturnOutcomeOfEqualIfBothAreSame() throws InvalidStandardException {
    Volume gallon = Volume.create(1, UnitOfVolume.GALLON);
    Volume litre = Volume.create(3.178, UnitOfVolume.LITRE);

    Outcome comparisonResult = gallon.compare(litre);

    assertEquals(Outcome.EQUAL, comparisonResult);
  }

  @Test
  void shouldReturnOutcomeOfGreaterThanIfFirstVolumeIsGreater() throws InvalidStandardException {
    Volume gallon = Volume.create(2, UnitOfVolume.GALLON);
    Volume litre = Volume.create(5, UnitOfVolume.LITRE);

    Outcome comparisonResult = gallon.compare(litre);

    assertEquals(Outcome.GREATERTHAN, comparisonResult);
  }

  @Test
  void shouldReturnOutcomeOfLesserThanIfFirstVolumeIsLesser() throws InvalidStandardException {
    Volume gallon = Volume.create(1, UnitOfVolume.GALLON);
    Volume litre = Volume.create(5, UnitOfVolume.LITRE);

    Outcome comparisonResult = gallon.compare(litre);

    assertEquals(Outcome.LESSERTHAN, comparisonResult);
  }

  @Test
  void shouldAddTwoVolumesOfSameUnit() throws InvalidStandardException {
    Volume oneLitre = Volume.create(1, UnitOfVolume.LITRE);
    Volume twoLitre = Volume.create(2, UnitOfVolume.LITRE);
    Volume expected = Volume.create(3, UnitOfVolume.LITRE);

    Volume actual = oneLitre.add(twoLitre);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldAddTwoVolumesOfDifferentUnit() throws InvalidStandardException {
    Volume oneLitre = Volume.create(1, UnitOfVolume.LITRE);
    Volume oneGallon = Volume.create(1, UnitOfVolume.GALLON);
    Volume expected = Volume.create(4.178, UnitOfVolume.LITRE);

    Volume actual = oneLitre.add(oneGallon);

    assertTrue(expected.isDifferenceInDelta(actual, 0.01));
  }

  @Test
  void shouldThrowExceptionForInvalidValues() {
    assertThrows(InvalidStandardException.class, () -> Volume.create(-5, UnitOfVolume.LITRE));
  }
}