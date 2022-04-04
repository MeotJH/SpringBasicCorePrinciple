package hello.core.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    @DisplayName("람다 테스트")
    void lambdaTest(){
        lambdaRole helloworld = () -> System.out.println("helloworld");
        helloworld.run();
    }

    static interface lambdaRole{
        void run();
    }

}
