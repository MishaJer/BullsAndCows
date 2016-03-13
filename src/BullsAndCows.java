import java.util.Random;
import java.util.Scanner;

/**
 * Created by Misha on 3/13/2016.
 */
public class BullsAndCows {
    static void StartGame() {
        int pred1, pred2;
        int end=0;
        int guess1,guess2;
        String P1Name = GetNick("Player 1");
        String P2Name = GetNick("Player 2");
        int P2Num = GetPlayerNum(P1Name, P2Name);
        int P1Num = GetPlayerNum(P2Name, P1Name);
        do{
        System.out.println(P1Name + ", please make a guess");
        Scanner scan = new Scanner(System.in);
        pred1 = scan.nextInt();
        System.out.println(P2Name + ", please make a guess");
        pred2 = scan.nextInt();
        guess1 = guess(P1Name, pred1, P2Num);
        guess2 = guess(P2Name, pred2, P1Num);
        if (guess1 == 4) {
            if (guess2 == 4) {
                System.out.println("Draw");
                end=10000;
            } else {
                System.out.println(P1Name + " Won!!!");
                end=10000;
            }
        } else {
            if (guess2 == 4) {
                System.out.println(P2Name + " Won!!!");
                end=10000;
            }
        }}while(end!=10000);
    }

    static int guess(String name, int prediction, int realNum) {
        int corPlace = 0;
        int rightNum = 0;
        int i;
        int j;
        int[] predictionA = getFourDigits(prediction);
        int[] realNumA = getFourDigits(realNum);
        for (i = 0; i != 4; i++) {
            if (predictionA[i] == realNumA[i]) {
                corPlace++;
            } else {
                for (j = 0; j != 4; j++) {
                    if (predictionA[i] == realNumA[j]) {
                        rightNum++;
                    }
                }
            }
        }
        System.out.println("Info about " + name + "'s guess");
        System.out.println("The number of digits at the same position as in real number is " + corPlace);
        System.out.println("The number of digits that exist in real number but don't stand at the correct position is " + rightNum);
        return corPlace;
    }

    static int[] getFourDigits(int n) {
        int[] A = {0, 0, 0, 0};
        A[0] = n / 1000;
        A[1] = n / 100 % 10;
        A[2] = n / 10 % 10;
        A[3] = n % 10;
        return A;
    }

    static int GetPlayerNum(String NameAway, String Name) {
        int n = 0;
        System.out.println(NameAway + ", please move away from the screen");
        System.out.println(Name + ", please insert your secret number");
        Scanner scan = new Scanner(System.in);
        do {
            n = scan.nextInt();
            if (checkNum(n) != true) {
                System.out.println("Please insert another number");
                System.out.println("All digits should be different and there should be four of them");
            }
        } while (checkNum(n) != true);
        return n;
    }

    static boolean checkNum(int n) {
        if (n / 1000 < 1) {
            return false;
        }
        if (n / 1000 == n / 100 % 10) {
            return false;
        }
        if (n / 1000 == n / 10 % 10) {
            return false;
        }
        if (n / 1000 == n % 10) {
            return false;
        }
        if (n / 100 % 10 == n / 10 % 10) {
            return false;
        }
        if (n % 10 == n / 10 % 10) {
            return false;
        }
        return true;

    }

    static String GetNick(String s) {
        System.out.println(s + ", please insert your nickname");
        Scanner scan = new Scanner(System.in);
        String Nick = scan.nextLine();
        return Nick;
    }

    public static void main(String[] args) {
        StartGame();
    }
}
