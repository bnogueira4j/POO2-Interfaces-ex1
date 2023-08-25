import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;

public class TestCases {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // VERIFICA EXISTÊNCIA E HERANÇA DAS CLASSES

    @Test
    public void test_verificaExistenciaClasseOperacoesContaCorrenteImpl_Sucesso()
            throws ClassNotFoundException{

        try {
            Class.forName("OperacoesContaCorrenteImpl");
        } catch (ClassNotFoundException e){
            fail("Você deve implementar a classe OperacoesContaCorrenteImpl");
        }
    }

    @Test
    public void test_verificaExistenciaClasseOperacoesContaCorrenteImplImplementaOperacoesContaCorrente_Sucesso() {
        try {
            if(OperacoesContaCorrente.class
                    .isAssignableFrom(Class.forName("OperacoesContaCorrenteImpl")) == false) {
                fail("A classe OperacoesContaCorrenteImpl deve implementar a interface OperacoesContaCorrente");
            }
        } catch (ClassNotFoundException e){
            assumeNoException(e);
        }
    }

    private void verificaExistenciaClasse(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e){
            assumeNoException(e);
        }
    }

    // VERIFICA MÉTODOS

    @Test
    public void test_realizaDeposito_valorMenorQueZero_Sucesso()
            throws Exception {

        verificaExistenciaClasse("OperacoesContaCorrenteImpl");

        var contaCorrente = new ContaCorrente("0000", "111111-1", 0.0);
        OperacoesContaCorrente operacoes = (OperacoesContaCorrente) Class.forName("OperacoesContaCorrenteImpl").newInstance();
        assertEquals(0.0, operacoes.realizaDeposito(contaCorrente, -100.0), 0.001);
    }

    @Test
    public void test_realizaSaque_valorMenorQueSaldo_Sucesso()
            throws Exception {

        verificaExistenciaClasse("OperacoesContaCorrenteImpl");

        var contaCorrente = new ContaCorrente("0000", "111111-1", 100.0);
        OperacoesContaCorrente operacoes = (OperacoesContaCorrente) Class.forName("OperacoesContaCorrenteImpl").newInstance();
        assertEquals(true, operacoes.realizaSaque(contaCorrente, 100.0));
        assertEquals(0.0, contaCorrente.getSaldo(), 0.001);
    }
}
