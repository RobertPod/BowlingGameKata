package org.bmc.tdd;

public class BowlingGame {

  public int getScore(char[] input) {
    int score = 0;
    int multiplierNext = 1;
    int multiplierNextNext = 1;
    var len = input.length;
    int round = 0;

    for (int i = 0; i < len; i++) {
      switch (input[i]) {
        case '-':
          multiplierNext = multiplierNextNext;
          multiplierNextNext = 1;
          break;

        case '/':
          score += multiplierNext * (10 - Integer.parseInt(Character.toString(input[i - 1])));
          multiplierNext = 2;
          break;

        case 'X':
          if (round<=20) {
            score += multiplierNext * 10;
          }
          round++;

//          multiplierNext++;
          multiplierNext = multiplierNext == 3 ? multiplierNext : multiplierNext+1;
          multiplierNextNext = multiplierNextNext == 3 ? multiplierNextNext : multiplierNextNext+1;
          break;

        default:
          if (round<20) {
            score += multiplierNext * Integer.parseInt(Character.toString(input[i]));
          } else {

            score += Integer.parseInt(Character.toString(input[i]));
          }
          multiplierNext = multiplierNextNext;
          multiplierNextNext = 1;
      }
      round++;
    }
    return score;
  }
}
