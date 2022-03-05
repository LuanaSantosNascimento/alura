package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest
{
    private BonusService service;
    private Funcionario funcioario;

    @BeforeEach
    public void inicializar(){
        service = new BonusService();
        funcioario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500"));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarComSalarioMuitoAlto() {
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
//      try {
//            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//            fail("Não deu a exception !");
//        } catch (Exception e) {
//            assertEquals("Funcionário com salário maior do que R$10.000,00 não pode receber bônus.", e.getMessage());
//        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(funcioario);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}