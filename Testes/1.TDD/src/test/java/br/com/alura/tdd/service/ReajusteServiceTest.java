package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest
{
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        System.out.println("Início !");
        service = new ReajusteService();
        funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Fim !");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("ANTES DE TODOS !");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois DE TODOS !");
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoQuandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoQuandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}