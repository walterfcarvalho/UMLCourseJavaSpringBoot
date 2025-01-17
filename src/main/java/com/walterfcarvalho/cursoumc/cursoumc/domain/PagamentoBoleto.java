package com.walterfcarvalho.cursoumc.cursoumc.domain;

import java.util.Date;

import com.walterfcarvalho.cursoumc.cursoumc.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    private static final String tipo = "Boleto";
    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoBoleto() {
    }

    public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public String getTipo(){
        return tipo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
