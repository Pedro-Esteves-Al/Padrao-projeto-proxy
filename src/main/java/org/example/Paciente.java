package org.example;

import java.util.Arrays;
import java.util.List;

public class Paciente {
    private String cpf;
    private String nome;
    private String fichaMedica;
    private String convenio;

    public Paciente(String cpf) {
        this.cpf = cpf;
        Paciente objeto = BD.getPaciente(cpf);
        this.nome = objeto.nome;
        this.convenio = objeto.convenio;
        this.fichaMedica = objeto.fichaMedica;
    }

    public Paciente(String cpf, String nome, String convenio, String fichaMedica) {
        this.cpf = cpf;
        this.nome = nome;
        this.convenio = convenio;
        this.fichaMedica = fichaMedica;
    }

    public String getCpf() {
        return cpf;
    }

    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.convenio);
    }

    public String obterFichaMedicaRestrita() {
        return this.fichaMedica;
    }
}
