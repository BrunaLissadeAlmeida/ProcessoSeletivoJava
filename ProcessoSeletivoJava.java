import java.util.ArrayList;
import java.util.Scanner;

class Candidato {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;


    public Candidato(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("CPF: " + cpf);
        System.out.println();
    }
}
public class ProcessoSeletivoJava {
    private ArrayList<Candidato> candidatos;
    private Scanner scanner;

    public ProcessoSeletivoJava() {
        candidatos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void cadastrarCandidato() {
        System.out.println("Cadastro de Candidato");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        if (validarCandidato(nome, email, telefone, cpf)) {
            Candidato candidato = new Candidato(nome, email, telefone, cpf);
            candidatos.add(candidato);
            System.out.println("Candidato cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro: Todos os campos devem ser preenchidos corretamente.\n");
        }
    }

    // Método para validar candidato
    public boolean validarCandidato(String nome, String email, String telefone, String cpf) {
        return !(nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || cpf.isEmpty());
    }

    // Método para exibir todos os candidatos
    public void exibirCandidatos() {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.\n");
        } else {
            System.out.println("Lista de Candidatos Cadastrados:");
            for (Candidato candidato : candidatos) {
                candidato.exibirInformacoes();
            }
        }
    }

    // Método principal para execução do sistema
    public void executar() {
        while (true) {
            System.out.println("Sistema de Validação de Processo Seletivo");
            System.out.println("1. Cadastrar Candidato");
            System.out.println("2. Exibir Candidatos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCandidato();
                    break;
                case 2:
                    exibirCandidatos();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }
    }

    public static void main(String[] args) {
        ProcessoSeletivoJava sistema = new ProcessoSeletivoJava();
        sistema.executar();
    }
}

