package example;

import java.util.Scanner;

public class prac1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1;
        int num2;
        String exitInput = "";
        // 양의 정수 2개를 각각 num1, num2에 전달 받기
        // 음수를 받을 경우 처음으로 돌아가서 다시 실행
        while (!exitInput.equals("exit")) { // exitInput에 exit을 제외한 기타 문자열이 들어올 시 반복
            while (true) { // 양수를 입력하기 전까지 무한 반복
                System.out.println("enter number :");
                num1 = in.nextInt();
                if (num1 < 0) {
                    System.out.println("enter number greater than 0");
                    continue; // 현재 반복 주기의 나머지 코드를 건너뛰고 다음 반복 주기로 넘어가도록 하는 제어문
                }
                num2 = in.nextInt();
                if (num2 < 0) {
                    System.out.println("enter number greater than 0");
                    continue;
                }
                break; // 둘다 양수를 입력하면 반복문 탈출
            }
            // 사칙연산 기호(+, -, *, /) 입력 받기
            // 제대로된 기호를 입력할 때 까지 반복
            // 0으로 나누기를 시도할 시 try-catch를 통한 예외 처리
            while (true) {
                System.out.println("enter symbol(+, -, *, /) :");
                char os = in.next().charAt(0);
                if(os != '+' && os != '-' && os != '*' && os != '/') { // 4칙 연산 기호가 아니라면
                    System.out.println("wrong symbol");
                    continue;
                }
                int result = cal(num1, num2, os);
                // 4칙연산 기호가 아니면 continue를 넣고싶다
                System.out.println("result = " + result);
                break; // 제대로 된 입력을 했을 시 반복문 탈출
            }
            in.nextLine(); // next()에 남아있던 개행문자(엔터키) 비우기 , 버퍼 비우기
            System.out.println("enter any key to continue \nenter 'exit' to quit");
            exitInput = in.nextLine();
        }
    }
    // 두 양수와 연산 기호를 매개변수로 받아서 연산 수행 후 값(i)를 반환
    public static int cal(int n1, int n2, char s1) {
        int i = 0;
        if (s1 == '+') {
            i = n1 + n2;
        } else if (s1 == '-') {
            i = n1 - n2;
        } else if (s1 == '*') {
            i = n1 * n2;
        } else if (s1 == '/') try {   // ArithmethicException 오류 발생 가능 부분
            i = n1 / n2;
        } catch (RuntimeException e) { // 오류 발생 시 예외 처리 부분
            System.out.println("cannot divide by zero");
        }
        return i;
    }

}
