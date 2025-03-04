package example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator  {
    // 접근제어자 설정
    private ArrayList<Double> resultList = new ArrayList<>(); // 결과 저장할 컬렉션 타입 필드

    public enum OperatorType { // class 내부에 정의해서 사용 할 때는 public을 붙여줘야 외부에서 접근 가능
        ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'), X(' ');
        // enum으로 4칙연산 기호 정리
        private final char symbol;

        OperatorType(char symbol) {
            this.symbol = symbol;
        }

        //입력받은 값을로 enum을 비교해 동일한 값으로 전환
        public static OperatorType fromSymbol(char symbol) {
            return Arrays.stream(OperatorType.values())
                    .filter(s -> s.symbol == symbol).findFirst().orElse(X);

//            for (OperatorType op : OperatorType.values()) {
//                if (op.symbol == symbol) {
//                    return op;
//                }
//            }
//            throw new RuntimeException("unknown operator");
        }
    }

    // 두 양수와 연산 기호를 매개변수로 받아서 연산 수행 후 값(i)를 반환
    public <T extends Number> double cal(T n1, T n2, char op) {
        double firstVal = n1.doubleValue();
        double secondVal = n2.doubleValue();

        double result = switch (OperatorType.fromSymbol(op)) {
            case ADD -> firstVal + secondVal; // 제네릭 타입은 연산이 불가능함
            case SUBTRACT -> firstVal - secondVal;
            case MULTIPLY -> firstVal * secondVal;
            case DIVIDE -> {
                if (secondVal == 0) {
                    throw new ArithmeticException();
                }
                yield firstVal / secondVal;
            }
            default -> 0;// 연산기호 4가지 이외의 입력 오류 발생 시 호출한 곳에서 처리
        };
        // 결과값을 arrayList에 추가
        resultList.add(result);
        return result;
    }

    public ArrayList<Double> getResultList() {
        return resultList;
    }
    // i번째 데이터를 num으로 변경
    public void setResultList(int i, double num) {
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
    public void findGreater(double x) {
        List<Double> ret1 = resultList.stream().filter(num -> num > x).collect(Collectors.toList());
        System.out.println(ret1);
    }
}

