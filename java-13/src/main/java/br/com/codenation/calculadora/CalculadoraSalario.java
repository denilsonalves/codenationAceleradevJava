package br.com.codenation.calculadora;


public class CalculadoraSalario {

    public long calcularSalarioLiquido(double baseSalary) {
        if (baseSalary <= 1039) return Math.round(0.0);
        return Math.round(calculateInss(baseSalary));
    }

    private double calculateInss(double calculateInssFee) {
        if (calculateInssFee <= 1500) {
            calculateInssFee -= (calculateInssFee * 0.08);
        } else if (calculateInssFee <= 4000) {
            calculateInssFee -= (calculateInssFee * 0.09);
        } else calculateInssFee -= (calculateInssFee * 0.11);
        return calculateIrrf(calculateInssFee);
    }

    private double calculateIrrf(double calculateIrrf) {
        if (calculateIrrf <= 3000) {
            return calculateIrrf;
        } else if (calculateIrrf <= 6000) {
            calculateIrrf -= (calculateIrrf * 0.075);
        } else {
            calculateIrrf -= (calculateIrrf * 0.15);
        }
        return calculateIrrf;
    }
}