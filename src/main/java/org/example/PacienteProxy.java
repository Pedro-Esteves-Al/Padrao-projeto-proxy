package org.example;

import java.util.List;

public class PacienteProxy {
    private Paciente paciente;

    private String cpf;

    public PacienteProxy(String cpf) {
        this.cpf = cpf;
    }

    public List<String> obterDadosPessoais() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.cpf);
        }
        return this.paciente.obterDadosPessoais();
    }

    public String obterFichasMedicas(Funcionario funcionario) {
        if (!funcionario.isMedico()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.cpf);
        }
        return this.paciente.obterFichaMedicaRestrita();
    }
}
