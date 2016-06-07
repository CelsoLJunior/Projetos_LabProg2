/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.view;

import venda.dominio.Cliente;
import venda.negocio.NegocioException;
import venda.negocio.ClienteNegocio;
import venda.util.Console;
import venda.view.menu.ClienteMenu;
import java.util.InputMismatchException;
import java.util.List;


/**
 *
 * @author 691001155
 */
public class ClienteUI {

    private ClienteNegocio clienteNegocio;

    public ClienteUI() {
        clienteNegocio = new ClienteNegocio();
    }

    public void menu() {
        int opcao = -1;
        do {
            try {
                System.out.println(ClienteMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case ClienteMenu.OP_CADASTRAR:
                        cadastrarCliente();
                        break;
                    case ClienteMenu.OP_DELETAR:
                        deletarCliente();
                        break;
                    case ClienteMenu.OP_ATUALIZAR:
                        atualizarCliente();
                        break;
                    case ClienteMenu.OP_LISTAR:
                        mostrarClientes();
                        break;
                    case ClienteMenu.OP_CONSULTAR:
                        consultarClientesPorNome();
                        break;
                    case ClienteMenu.OP_SAIR:
                        System.out.println("Retornando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != ClienteMenu.OP_SAIR);
    }

    private void cadastrarCliente() {
        String cpf = Console.scanString("CPF: ");
        String nome = Console.scanString("Nome: ");
        String email = Console.scanString("Email: ");
        int num_conta = Console.scanInt("Numero da conta: ");
        Double saldo = Console.scanDouble("Saldo do cliente: ");
        try {
            clienteNegocio.salvar(new Cliente(cpf, nome, email, num_conta, saldo));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    public void mostrarClientes() {
        List<Cliente> listaClientes = clienteNegocio.listar();
        this.mostrarClientes(listaClientes);
    }

    private void deletarCliente() {
        int codigo = Console.scanInt("Numero de conta do cliente a ser deletado: ");
        try {
            Cliente pac = clienteNegocio.procurarPorCodigo(codigo);
            this.mostrarCliente(pac);
            if (UIUtil.getConfirmacao("Realmente deseja excluir esse cliente?")) {
                clienteNegocio.deletar(pac);
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Operacao cancelada!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void atualizarCliente() {
    	int codigo = Console.scanInt("Numero de conta do cliente a ser alterado: ");
        try {
            Cliente pac = clienteNegocio.procurarPorCodigo(codigo);
            this.mostrarCliente(pac);

            System.out.println("Digite os dados do cliente que quer alterar [Vazio caso nao queira]");
            String cpf = Console.scanString("CPF: ");
            String nome = Console.scanString("Nome: ");
            String email = Console.scanString("Email: ");
            
            if (!cpf.isEmpty()) {
                pac.setCpf(cpf);
            }
            if (!nome.isEmpty()) {
                pac.setNome(nome);
            }
            if (!email.isEmpty()) {
                pac.setEmail(email);
            }

            clienteNegocio.atualizar(pac);
            System.out.println("Cliente " + nome + " atualizado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }

    private void consultarClientesPorNome() {
        String nome = Console.scanString("Nome: ");
        try {
            List<Cliente> listaPac = clienteNegocio.procurarPorNome(nome);
            this.mostrarClientes(listaPac);
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }

    }

    private void mostrarCliente(Cliente p) {
        System.out.println("-----------------------------");
        System.out.println("Cliente");
        System.out.println("CPF: "   + p.getCpf());
        System.out.println("Nome: "   + p.getNome());
        System.out.println("Email: "   + p.getEmail());
        System.out.println("Numero da conta: "   + p.getNumconta());
        System.out.println("Saldo: "   + p.getSaldo());
        System.out.println("-----------------------------");
    }

    private void mostrarClientes(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("Clientes nao encontrados!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-20s", "CPF") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|EMAIL") + "\t"
                    + String.format("%-20s", "|NUMERO DA CONTA") + "\t"
                    + String.format("%-20s", "|SALDO"));
            for (Cliente cliente : listaClientes) {
                System.out.println(String.format("%-20s", cliente.getCpf()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                        + String.format("%-20s", "|" + cliente.getEmail()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNumconta()) + "\t"
                        + String.format("%-20s", "|R$ " + cliente.getSaldo()));
            }
        }
    }
}
