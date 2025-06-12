/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author rebek
 */
public class Reserva {
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String status;

    private int hospedeId;
    private int quartoId;

    private String nomeHospede;
    private String cpfHospede;
    private String numeroQuarto;
    private String valor;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getHospedeId() {
        return hospedeId;
    }
    public void setHospedeId(int hospedeId) {
        this.hospedeId = hospedeId;
    }

    public int getQuartoId() {
        return quartoId;
    }
    public void setQuartoId(int quartoId) {
        this.quartoId = quartoId;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }
    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getCpfHospede() {
        return cpfHospede;
    }
    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }
    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
}

