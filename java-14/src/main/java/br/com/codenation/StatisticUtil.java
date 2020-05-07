package br.com.codenation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class StatisticUtil {

    public static int average(int[] elements) {
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }
        return sum / elements.length;
    }

    public static int mode(int[] elements) {
        HashMap modeElements = new HashMap();
        Integer checkElements;
        int mode = 0, currentNumber = 0, previousNumber = 0;

        for (int count = 0; count < elements.length; count++) {
            // Recebe o valor contindo na chave
            checkElements = (Integer) modeElements.get((elements[count]));

            // Se valor é null, adiciona o valor 1 para a chave
            if (checkElements == null) modeElements.put(new Integer(elements[count]), new Integer(1));
            else {
                // Adiciona +1 ao valor anterior contido na chave
                modeElements.put(new Integer(elements[count]), new Integer(checkElements.intValue() + 1));
                currentNumber = checkElements.intValue() + 1;
                // Recebe o número com maior frequência
                if (currentNumber > previousNumber) {
                    previousNumber = currentNumber;
                    mode = new Integer(elements[count]);
                }
            }
        }
        return mode;
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        return (elements.length % 2 == 0) ? (elements[(elements.length / 2) - 1] + elements[elements.length / 2]) / 2 : elements[elements.length / 2];
    }
}