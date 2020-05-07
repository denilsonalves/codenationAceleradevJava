package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		int current=0, next=1, previous=0;

		List<Integer> fibonacciSequence = new ArrayList<>();

		while(current < 378){
			fibonacciSequence.add(current);
			previous = current + next;
			current = next;
			next = previous;
		}

		return fibonacciSequence;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}


}