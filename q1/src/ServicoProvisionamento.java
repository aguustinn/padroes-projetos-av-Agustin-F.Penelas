public class ServicoProvisionamento {

    public void provisionar(
        String nome,
        String provedor,
        int quantidadeMaquinas,
        int gb
    ) {

        String resultado;

        try {

            if (quantidadeMaquinas < 0 || gb < 0) {
                throw new IllegalArgumentException(
                    "As quantidades não podem ser negativas."
                );
            }

            FabricaNuvem fabrica =
                SeletorProvedor.escolher(provedor);

            double custo =
                quantidadeMaquinas
                * fabrica.getCustoHoraMaquina() * 730
                + gb * fabrica.getCustoGb()
                + fabrica.getCustoFila();

            double orcamento =
                Configuracao.getInstancia().getOrcamento();

            if (custo > orcamento) {

                resultado = "RECUSADO - Orçamento excedido";

                System.out.println(
                    "\nAmbiente recusado: " + nome
                );

            } else {

                MontadorAmbiente montador =
                    new MontadorAmbiente(fabrica);

                Ambiente ambiente = montador.montar(
                    nome, quantidadeMaquinas, gb
                );

                ambiente.mostrarResumo();

                resultado = "ACEITO";
            }

        } catch (Exception e) {

            resultado = "RECUSADO - " + e.getMessage();

            System.out.println(
                "\nErro: " + resultado
            );
        }

        Auditoria.getInstancia().registrar(
            nome, provedor, resultado
        );
    }
}