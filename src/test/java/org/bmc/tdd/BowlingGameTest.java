package org.bmc.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

  BowlingGame theGame = new BowlingGame();

//  @Test
//  public void shouldScoreOneWhenRolledOneWithJUnit() {
//    assertEquals(1, theGame.getScore());
//  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata.csv")
  public void shouldScoreZero(String input, int expected) {
    assertEquals(expected, theGame.getScore(input.toCharArray()));
  }

  @Test
  public void shouldScoreZero() {
    // given
    char[] input = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
        '-', '-', '-', '-'};

    assertEquals(0, theGame.getScore(input));
  }

  @Test
  public void shouldScoreOne() {
    // given
    char[] input = {'1', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
        '-', '-', '-', '-'};

    assertEquals(1, theGame.getScore(input));
  }

  @Test
  public void shouldSpareAndScoreOneAndSpare() {
    // given
    char[] input = {'1', '/', '1', '-', '-', '-', '-', '-', '-', '-',
                    '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};

    assertEquals(12, theGame.getScore(input));
  }

  @Test
  public void shouldScoreOneAndSpare() {
    // given
    char[] input = {'1', '/', '1', '-', '1', '-', '-', '-', '-', '-',
        '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};

    assertEquals(13, theGame.getScore(input));
  }

  @Test
  public void shouldScoreOneAndSpareInNextRound() {
    // given
    char[] input = {'-', '1', 'X', '1', '1', '-', '-', '-', '-',
        '-', '-', '-', '-', '-', '-', '-', '-', '-', '1'};

    assertEquals(16, theGame.getScore(input));
  }

//  @Test
//  public void shouldScoreOneWhenRolledOneWithAssertJ() {
//    Assertions.assertThat(theGame.getScore()).isEqualTo(1);
//  }

}