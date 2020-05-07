package challenge;

import java.util.ArrayList;
import java.util.List;

import static challenge.Condition.*;

public class Estacionamento {

    List<Carro> cars = new ArrayList<>();

    public void estacionar(Carro carro) {
        verificaQualificacao(carro);
        if (carrosEstacionados() < PARKING_SIZE) {
            cars.add(carro);
        }
        if (carrosEstacionados() == PARKING_SIZE) {
            if (cars.stream().allMatch(c -> c.getMotorista().getIdade() >= IS_ELDERLY)) {
                throw new EstacionamentoException("Estacionamento lotado");
            }
            Carro elderlyCar = cars.stream().filter(c -> c.getMotorista().getIdade() < IS_ELDERLY).findFirst().orElseThrow(()
                    -> new EstacionamentoException("Estacionamento cheio"));
            cars.remove(elderlyCar);

            cars.add(carro);
        }

    }

    public void verificaQualificacao(Carro carro) {
        if (carro.getMotorista().getIdade() < MINIMUN_AGE)
            throw new EstacionamentoException("Motorista não qualificado a dirigir");
        if (carro.getMotorista().getPontos() > LICENSE_POINTS)
            throw new EstacionamentoException("Motorista não qualificado a dirigir");
    }

    public int carrosEstacionados() {
        return cars.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return cars.contains(carro);
    }
}
