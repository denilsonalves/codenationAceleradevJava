package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        return calcularValores(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcularValores(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    public BigDecimal calcularValores(Object object, Class classes){

        Class classe = object.getClass();
        BigDecimal operacao = BigDecimal.ZERO;
        for(Field fields : classe.getDeclaredFields()){
            if(BigDecimal.class.isAssignableFrom(fields.getType()) && fields.getAnnotation(classes) != null){
                try{
                    fields.setAccessible(true);
                    operacao = operacao.add((BigDecimal) fields.get(object));
                } catch (IllegalAccessException e){
                    e.getMessage();
                }
            }
        }
        return operacao;
    }
}
