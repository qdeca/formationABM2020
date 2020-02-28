package fr.natsystem.quiz_manager;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class AppTest {


	
	public double computation(double a, double b, BiFunction<Double, Double, Double> f) {
		return f.apply(a, b);
	}
	
	public double computation(double a, Function<Double, Double> f) {
		return f.apply(a);
	}
	
	@Test
    public void testApp()
    {
        System.out.println(computation(5, 2, Math::pow));
        System.out.println(computation(4, 3, Math::hypot));
        System.out.println(computation(4.5, Math::floor));
       
    }
	
	
	
}
