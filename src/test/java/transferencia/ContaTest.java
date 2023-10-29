package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvioSantos;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12345678900", "1111111");
        silvioSantos = new Cliente("Silvio Santos", "00987654321", "22222222");

        contaXuxa = new Conta("0025", "225456", 2500.00, xuxa);
        contaSilvioSantos = new Conta("0026", "225111", 3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000.00, contaSilvioSantos);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvioSantos.getSaldo());
    }

    @Test
    public void realizarTransferenciaInvalida(){
        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvioSantos);
        assertFalse(resultado);
    }
}