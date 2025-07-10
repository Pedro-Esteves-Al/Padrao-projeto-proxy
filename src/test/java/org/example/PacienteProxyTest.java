package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addPaciente(new Paciente("1", "João", "bradesco","fichaMedica1"));
        BD.addPaciente(new Paciente("2", "Maria", "unimed", "fichaMedica2"));
    }

    @Test
    void deveRetornarDadosPessoaisPaciente() {
        PacienteProxy paciente = new PacienteProxy("1");

        assertEquals(Arrays.asList("João", "bradesco"), paciente.obterDadosPessoais());
    }

    @Test
    void deveRetonarFichaPaciente() {
        Funcionario funcionario = new Funcionario("Ana", true);
        PacienteProxy paciente = new PacienteProxy("2");

        assertEquals("fichaMedica2", paciente.obterFichasMedicas(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasPaciente() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            PacienteProxy paciente = new PacienteProxy("2");

            paciente.obterFichasMedicas(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

}