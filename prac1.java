package example;

import java.util.Scanner;

public class prac1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        char os = ' ';
        String exitInput = "";
        // calculator 객체 생성, 값이 정확하진 않지만 미리 객체를 만들어 두는 이유는 반복문이라 객체가 계속 생성될거 같아서
        Calculator calculator = new Calculator();
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
            // 제대로된 기호를 입력할 때 까지 반복
            // 0으로 나누기를 시도할 시 try-catch를 통한 예외 처리
            while (true) {
                System.out.println("enter symbol(+, -, *, /) :");
                os = in.next().charAt(0);
                if(os != '+' && os != '-' && os != '*' && os != '/') { // 4칙 연산 기호가 아니라면 continue
                    System.out.println("wrong symbol");
                    continue;
                }
                // Calculator 내 메서드인 cal 호출
                int result = calculator.cal(num1, num2, os);
                System.out.println("result = " + result);
                System.out.print("resultList : ");
                // 결과값이 arrayList에 잘 쌓이는지 확인용
                for(int a = 0; a < calculator.getResultList().size(); a++) {
                    System.out.print(" " + calculator.getResultList().get(a));
                }
                break; // 제대로 된 입력을 했을 시 반복문 탈출
            }
            in.nextLine(); // next()에 남아있던 개행문자(엔터키) 비우기 , 버퍼 비우기
            System.out.println("\nenter any key to continue \nenter 'exit' to quit");
            exitInput = in.nextLine();
        }
    }
}
