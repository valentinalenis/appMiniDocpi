package com.example.valentina.appminidocpi;

public class formula {
    private String medicamento;
    private int horario;

    public formula(String medicamento, int horario){
        this.medicamento = medicamento;
        this.horario = horario;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
}
