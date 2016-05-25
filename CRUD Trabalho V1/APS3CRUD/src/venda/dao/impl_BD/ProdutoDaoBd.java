package venda.dao.impl_BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import venda.dominio.Produto;
import venda.dao.ProdutoDao;

public class ProdutoDaoBd extends DaoBd<Produto> implements ProdutoDao {
  

    //Metodo salvar: trabalhar com data e recebe o id auto-increment 
    //e já relaciona no objeto produto (recebido por parâmetro)
    //Caso queira retornar, só retornar id.
    @Override
    public void salvar(Produto produto) {
        int id = 0;
        try {
            String sql = "INSERT INTO produto (codigo, nome, preco) "
                    + "VALUES (?,?,?)";

            //Foi criado um novo método conectar para obter o id
            conectarObtendoId(sql);
            comando.setInt(1, produto.getCodigo());
            comando.setString(2, produto.getNomeProd());
            comando.setDouble(3, produto.getPreco());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                produto.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar produto no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Produto produto) {
        try {
            String sql = "DELETE FROM produto WHERE id = ?";

            conectar(sql);
            comando.setInt(1, produto.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar produto no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public void atualizar(Produto produto) {
        try {
            String sql = "UPDATE produto SET codigo=?, nome=?, preco=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setInt(1, produto.getCodigo());
            comando.setString(2, produto.getNomeProd());
            comando.setDouble(3, produto.getPreco());
            comando.setInt(4, produto.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar produto no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public List<Produto> listar() {
        List<Produto> listaProdutos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");
               
                Produto pac = new Produto(id, codigo, nome, preco);

                listaProdutos.add(pac);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os Produtos do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (listaProdutos);
    }

    @Override
    public Produto procurarPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
            	int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");

                Produto pac = new Produto(id, codigo, nome, preco);

                return pac;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o produto pelo id do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public Produto procurarPorCodigo(int codigo) {
        String sql = "SELECT * FROM produto WHERE codigo = ?";

        try {
            conectar(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
            	int codigoProd = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");

                Produto pac = new Produto(id, codigoProd, nome, preco);

                return pac;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o produto pelo rg do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<Produto> procurarPorNome(String nome) {
        List<Produto> listaProdutos = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
            	int codigo = resultado.getInt("codigo");
                String nomeProd = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");

                Produto pac = new Produto(id, codigo, nomeProd, preco);

                listaProdutos.add(pac);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os Produtos pelo nome do Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
        return (listaProdutos);
    }
}
