package br.com.trabalhoSenai;

public class produto {

    private int codigo;
    private String descricao;
    private int quantidade;
    private double precoUnitario;
    private String categoria;

    
    public produto(int codigo, String descricao, int quantidade, double precoUnitario, String categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

   
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    // Métodos
    public void adquirirProduto(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
            System.out.println(qtd + " unidades de \"" + descricao + "\" adquiridas.");
        } else {
            System.out.println("Quantidade para adquirir deve ser positiva.");
        }
    }

    public boolean venderProduto(int qtd) {
        if (qtd <= 0) {
            System.out.println("Quantidade para vender deve ser positiva.");
            return false;
        } else if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
            System.out.println(qtd + " unidades de \"" + descricao + "\" vendidas.");
            return true;
        } else {
            System.out.println("Estoque insuficiente para \"" + descricao + "\".");
            return false;
        }
    }

    public boolean verificarDisponibilidade() {
        return this.quantidade > 0;
    }

    public double totalizarPrecoEstoque() {
        return this.quantidade * this.precoUnitario;
    }

    public void exibirDetalhes() {
        System.out.println("--- Detalhes do Produto ---");
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Quantidade em Estoque: " + quantidade);
        System.out.printf("Preço Unitário: R$ %.2f\n", precoUnitario);
        System.out.println("Categoria: " + categoria);
        System.out.printf("Total em Estoque: R$ %.2f\n", totalizarPrecoEstoque());
        System.out.println("---------------------------");
    }
}
