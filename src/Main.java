import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Currency;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição do curso java");
        curso1.setCargaHoraria(8);
        curso1.calcularXp();

        System.out.println(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso java script");
        curso2.setDescricao("descrição do curso java script");
        curso2.setCargaHoraria(8);
        curso2.calcularXp();

        System.out.println(curso2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());
        System.out.println(mentoria);



        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp java developer");
        bootcamp.setDescricao("edscricao do bootcamp java developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        System.out.println(" ");

        Dev devCamila = new Dev();
        devCamila.setNome("Calila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: "+devCamila.getConteudosInscritos());
        devCamila.progredir();

        System.out.println("XP: "+devCamila.calcularTotalXp());
        System.out.println("Conteudos concluidos: "+devCamila.getConteudosConcluidos());
        System.out.println("Conteudos inscritos: "+devCamila.getConteudosInscritos());

        System.out.println(" ");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: "+devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("XP: "+devJoao.calcularTotalXp());
        System.out.println("Conteudos concluidos: "+devJoao.getConteudosConcluidos());
        System.out.println("Conteudos inscritos: "+devJoao.getConteudosInscritos());

    }
}