import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private int rgm;
    private ArrayList<String> disciplinas;

    public Aluno(int rgm) {
        this.rgm = rgm;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public int getRgm() {
        return rgm;
    }

    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.print("RGM: ");
            int rgm = scanner.nextInt();
            Aluno aluno = new Aluno(rgm);

            while (true) {
                System.out.print("Disciplina: ");
                String disciplina = scanner.next();
                aluno.adicionarDisciplina(disciplina);

                System.out.print("Mais disciplina? (S/N) ");
                String resposta = scanner.next().toUpperCase();

                if (resposta.equals("N")) {
                    break;
                }
            }

            alunos.add(aluno);

            System.out.print("Mais aluno? (S/N) ");
            String resposta = scanner.next().toUpperCase();

            if (resposta.equals("N")) {
                break;
            }
        }

        System.out.println("Alunos cadastrados:");

        for (Aluno aluno : alunos) {
            System.out.println("RGM: " + aluno.getRgm());

            System.out.println("Disciplinas:");
            for (String disciplina : aluno.getDisciplinas()) {
                System.out.println("- " + disciplina);
            }

            System.out.println();
        }

        System.out.print("Digite o RGM do aluno a ser pesquisado: ");
        int rgm = scanner.nextInt();

        Aluno alunoEncontrado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getRgm() == rgm) {
                alunoEncontrado = aluno;
                break;
            }
        }

        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado:");
            System.out.println("RGM: " + alunoEncontrado.getRgm());
            System.out.println("Disciplinas:");
            for (String disciplina : alunoEncontrado.getDisciplinas()) {
                System.out.println("- " + disciplina);
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }

        System.out.print("Digite o RGM do aluno a ser removido: ");
        int rgmRemover = scanner.nextInt();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            if (aluno.getRgm() == rgmRemover) {
                alunos.remove(i);
                break;
            }
        }

        System.out.println("Lista de alunos após a remoção:");
        for (Aluno aluno : alunos) {
            System.out.println("RGM: " + aluno.getRgm());

            System.out.println("Disciplinas:");
            for (String disciplina : aluno.getDisciplinas()) {
                System.out.println("- " + disciplina);
            }

            System.out.println();
        }
    }
}