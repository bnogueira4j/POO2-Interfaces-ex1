import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeNoException;

public class PrivateTestCases {
    @Test
    public void test_realizaDeposito_valorIgualZero_Sucesso() {

        verificaExistenciaClasse("OperacoesContaCorrenteImpl");

        var contaCorrente = new ContaCorrente("0000", "111111-1", 0.0);
        OperacoesContaCorrente operacoes = new OperacoesContaCorrenteImpl();
        assertEquals(0.0, operacoes.realizaDeposito(contaCorrente, 0.0), 0.001);
    }

    @Test
    public void test_realizaDeposito_valorMenorZero_Sucesso() {

        verificaExistenciaClasse("OperacoesContaCorrenteImpl");

        var contaCorrente = new ContaCorrente("0000", "111111-1", 0.0);
        OperacoesContaCorrente operacoes = new OperacoesContaCorrenteImpl();
        assertThrows(Exception.class, () -> operacoes.realizaDeposito(contaCorrente, -10.0));
    }

    @Test
    public void test_realizaSaque_valorMaiorQueSaldo_Sucesso() {

        verificaExistenciaClasse("OperacoesContaCorrenteImpl");

        var contaCorrente = new ContaCorrente("0000", "111111-1", 100.0);
        OperacoesContaCorrente operacoes = new OperacoesContaCorrenteImpl();
        assertEquals(false, operacoes.realizaSaque(contaCorrente, 150.0));
    }

    private void verificaExistenciaClasse(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e){
            assumeNoException(e);
        }
    }
}