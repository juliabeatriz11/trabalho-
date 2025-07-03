package br.com.trabalhoSenai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Adquirir produto");
            System.out.println("3. Vender produto");
            System.out.println("4. Verificar disponibilidade");
            System.out.println("5. Totalizar preço do estoque por produto");
            System.out.println("6. Listar todos os produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {

                case 1:
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço unitário: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    produto novoProduto = new produto(codigo, descricao, quantidade, preco, categoria);
                    produtos.add(novoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Código do produto: ");
                    int codAdq = scanner.nextInt();

                    produto prodAdq = buscarProduto(produtos, codAdq);
                    if (prodAdq != null) {
                        System.out.print("Quantidade a adquirir: ");
                        int qtdAdq = scanner.nextInt();
                        prodAdq.adquirirProduto(qtdAdq);
                        System.out.println("Produto adquirido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Código do produto: ");
                    int codVend = scanner.nextInt();

                    produto prodVend = buscarProduto(produtos, codVend);
                    if (prodVend != null) {
                        System.out.print("Quantidade a vender: ");
                        int qtdVend = scanner.nextInt();
                        if (prodVend.venderProduto(qtdVend)) {
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Estoque insuficiente.");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código do produto: ");
                    int codDisp = scanner.nextInt();

                    produto prodDisp = buscarProduto(produtos, codDisp);
                    if (prodDisp != null) {
                        if (prodDisp.verificarDisponibilidade()) {
                            System.out.println("Produto disponível. Quantidade: " + prodDisp.getQuantidade());
                        } else {
                            System.out.println("Produto sem estoque.");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Código do produto: ");
                    int codTot = scanner.nextInt();

                    produto prodTot = buscarProduto(produtos, codTot);
                    if (prodTot != null) {
                        double total = prodTot.totalizarPrecoEstoque();
                        System.out.printf("Valor total do estoque: R$ %.2f\n", total);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 6:
                    if (produtos.isEmpty()) {
                        System.out.println("Estoque vazio.");
                    } else {
                        for (produto p : produtos) {
                            p.exibirDetalhes();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println(); 
        } while (opcao != 0);

        scanner.close();
    }

    private static produto buscarProduto(List<produto> produtos, int codigo) {
        for (produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
} 