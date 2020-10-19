package io.codegitz.mockito;

/**
 * Mock 测试
 *
 * @author 张观权
 * @date 2020/10/19 15:21
 **/
public class Calculation {

    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int add(int i, int j) {
        System.out.println(i + j);
        return sum =( i + j);
    }

    public int getId() {
        System.out.println(1);
        return 1;
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        int add = calculation.add(1, 1);
        System.out.println(add);
    }
}
