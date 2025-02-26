package example;

import java.util.ArrayList;

public class Calculator {
    // 1. 속성
    // 접근제어자 설정
    private ArrayList<Integer> resultList = new ArrayList<>(); // 결과 저장할 컬렉션 타입 필드
    // 2. 생성자

    // 3. 기능
    // 두 양수와 연산 기호를 매개변수로 받아서 연산 수행 후 값(i)를 반환
    public int cal(int n1, int n2, char s1) {
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
        // 결과값을 arrayList에 추가
        resultList.add(i);
        return i;
    }

    public ArrayList<Integer> getResultList() {
        return resultList;
    }
    // i번째 데이터를 num으로 변경
    public void setResultList(int i, int num) {
        resultList.set(i, num);
    }
    // 계산 결과 중 첫번째 데이터 삭제
    // private로 선언했으니 class 내부 메서드를 통해 정보를 변경한다
    public void removeResultList() {
        resultList.remove(0);
    }
    // 첫번째 말고 지정 삭제, 메서드 오버로딩
    // 인덱스에 들어갈 숫자는 0 <= i < resultList.size() 가 되어야함
    public void removeResultList(int i) {
        if (i >= resultList.size() || i < 0) {
            System.out.println("입력하신 " + i + "번째 인덱스가 존재하지 않습니다.\n현재 인덱스의 크기 : " + resultList.size());
        } else {
            resultList.remove(i);
        }
    }
}
