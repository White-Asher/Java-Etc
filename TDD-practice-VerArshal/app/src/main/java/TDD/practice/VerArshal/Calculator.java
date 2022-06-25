package TDD.practice.VerArshal;

import java.util.stream.IntStream;

public class Calculator {

    public int plus(int x, int y){
        if(y == 0){
            return x;
        }
        return plus(x + 1 , y - 1);
    }


    public int minus(int x, int y){
        if(y<0){
            return plus(x,-y);
        }
        if(y == 0){
            return x;
        }
        return minus(x - 1 , y - 1);
    }

    public int multiply(int x, int y){
        return IntStream.generate(()-> 0).limit(y)
                .reduce(0, (a, e) -> plus(a, x));
    }


    public int fib(int x) {
        if(x<=0){
            return 0;
        }
        if(x<3){
            return 1;
        } else {
            return fib(x - 2) + fib(x - 1);
        }
    }

    public float divide(float x, float y){

        if(x == 0 || y == 0){
//            System.out.println("0으로 나눌 수 없음");
            return 0;
        }
        else{
            return x/y;
        }
    }
}
