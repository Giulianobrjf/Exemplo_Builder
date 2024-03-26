import org.example.Funcionario;
import org.example.FuncionarioBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuncionarioBuilderTest {

    @Test
    public void deveRetornarExcecaoParaFuncionarioSemId() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder ();
            Funcionario funcionario= funcionarioBuilder
                    .setNome("Funcionario 1")
                    .setEmail("funcionario1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("ID inválido", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoParaFuncionarioSemNome() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario= funcionarioBuilder
                    .setId(1)
                    .setEmail("funcionario1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    public void deveRetornarFuncionarioValido() {
        FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
        Funcionario funcionario= funcionarioBuilder
                .setId(1)
                .setNome("Funcionario 1")
                .setEmail("funcionario1@email.com")
                .build();

        assertNotNull(funcionario);
    }
}
