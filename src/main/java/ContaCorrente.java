class ContaCorrente{
    private String agencia;
    private String conta;
    private Double saldo;

    ContaCorrente(String agencia, String conta, Double saldo){
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    Double getSaldo(){
        return this.saldo;
    }

    void setSaldo(Double novoSaldo){
        this.saldo = novoSaldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
