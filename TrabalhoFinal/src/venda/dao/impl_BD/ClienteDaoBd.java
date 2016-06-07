package venda.dao.impl_BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import venda.dominio.Cliente;
import venda.dao.ClienteDao;

public class ClienteDaoBd extends DaoBd<Cliente> implements ClienteDao {
  

    //Metodo salvar: trabalhar com data e recebe o id auto-increment 
    //e já relaciona no objeto cliente (recebido por parâmetro)
    //Caso queira retornar, só retornar id.
    @Override
    public void salvar(Cliente cliente) {
        int id = 0;
        try {
            String sql = "INSERT INTO clientes (cpf, nome, email, numero_conta, saldo) "
                    + "VALUES (?,?,?,?,?)";

            //Foi criado um novo método conectar para obter o id
            conectarObtendoId(sql);
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getEmail());
            comando.setInt(4, cliente.getNumconta());
            comando.setDouble(5, cliente.getSaldo());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                cliente.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar cliente no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";

            conectar(sql);
            comando.setInt(1, cliente.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar cliente no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public void atualizar(Cliente cliente) {
        try {
            String sql = "UPDATE clientes SET cpf=?, nome=?, email=?, numero_conta=?, saldo=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getEmail());
            comando.setInt(4, cliente.getNumconta());
            comando.setDouble(5, cliente.getSaldo());
            comando.setInt(6, cliente.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar cliente no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                int num_conta = resultado.getInt("numero_conta");
                Double saldo = resultado.getDouble("saldo");
                               
                Cliente pac = new Cliente(id, cpf, nome, email, num_conta, saldo);

                listaClientes.add(pac);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os Clientes do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (listaClientes);
    }

    @Override
    public Cliente procurarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
            	String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                int num_conta = resultado.getInt("numero_conta");
                Double saldo = resultado.getDouble("saldo");
                               
                Cliente pac = new Cliente(id, cpf, nome, email, num_conta, saldo);

                return pac;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o cliente pelo id do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public Cliente procurarPorNumConta(int codigo) {
        String sql = "SELECT * FROM clientes WHERE numero_conta = ?";

        try {
            conectar(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                int num_conta = resultado.getInt("numero_conta");
                Double saldo = resultado.getDouble("saldo");
                               
                Cliente pac = new Cliente(id, cpf, nome, email, num_conta, saldo);

                return pac;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o cliente pelo rg do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<Cliente> procurarPorNome(String nome) {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String cpf = resultado.getString("cpf");
                String nomec = resultado.getString("nome");
                String email = resultado.getString("email");
                int num_conta = resultado.getInt("numero_conta");
                Double saldo = resultado.getDouble("saldo");
                               
                Cliente pac = new Cliente(id, cpf, nomec, email, num_conta, saldo);

                listaClientes.add(pac);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os Clientes pelo nome do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
        return (listaClientes);
    }
}
