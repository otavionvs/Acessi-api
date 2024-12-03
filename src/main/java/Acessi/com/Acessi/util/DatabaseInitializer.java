//package Acessi.com.Acessi.util;
//
//import Acessi.com.Acessi.model.entity.Address;
//import Acessi.com.Acessi.model.entity.PCD;
//import Acessi.com.Acessi.model.entity.User;
//import Acessi.com.Acessi.model.enums.AccessLevel;
//import Acessi.com.Acessi.model.enums.DisabilityType;
//import Acessi.com.Acessi.model.enums.EducationLevel;
//import Acessi.com.Acessi.model.enums.Gender;
//import Acessi.com.Acessi.repository.PcdRepository;
//import Acessi.com.Acessi.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public class DatabaseInitializer implements CommandLineRunner {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PcdRepository pcdRepository;
//
//    private static final Random random = new Random();
//
//    // Listas com valores possíveis para cada atributo
//    private static final List<String> nomes = Arrays.asList("João", "Maria", "Pedro", "Ana", "Carlos", "Fernanda", "Marcelo", "Juliana");
//    private static final List<String> sobrenomes = Arrays.asList("Silva", "Santos", "Oliveira", "Souza", "Pereira", "Rodrigues", "Costa", "Almeida");
//    private static final List<String> cidades = Arrays.asList("Jaraguá do Sul");
//    private static final List<String> ruas = Arrays.asList("Avenida Brasil", "Rua da Paz", "Rua dos Bobos", "Avenida Central", "Rua Principal", "Rua Nova");
//    private static final List<String> bairros = Arrays.asList("Centro", "Ilha da Figueira", "Vila Nova", "Nova Brasilia", "Barra do Rio Cerro", "Baependi",
//            "Vila Lenzi", "São Luiz", "Tifa Martins", "Centenário", "Água Verde", "Águas Claras", "Amizade", "Barra do Rio Molha", "Boa Vista");
//
//    public static PCD gerarPCDAleatorio(User user) {
//        // Gera dados aleatórios para cada atributo
//        String nome = nomes.get(random.nextInt(nomes.size())) + " " + sobrenomes.get(random.nextInt(sobrenomes.size()));
//        String cpf = gerarCPF();
//        String telefone = gerarTelefone();
//        Date dataNascimento = Date.from(LocalDate.of(random.nextInt(1920, 2024), random.nextInt(1, 13), random.nextInt(1, 28)).atStartOfDay(ZoneId.systemDefault()).toInstant());
//        String email = nome.toLowerCase().replace(" ", "_") + "@gmail.com";
//        Gender genero = Gender.values()[random.nextInt(Gender.values().length)];
//        EducationLevel escolaridade = EducationLevel.values()[random.nextInt(EducationLevel.values().length)];
//
//        Address endereco = new Address(
//                null,
//                cidades.get(random.nextInt(cidades.size())),
//                ruas.get(random.nextInt(ruas.size())),
//                bairros.get(random.nextInt(bairros.size())),
//                random.nextInt(1000),
//                "", // Complemento
//                gerarCEP() // Função para gerar CEP
//        );
//
//        return new PCD(null, nome, cpf, dataNascimento, telefone, email, genero, escolaridade, random.nextBoolean(), random.nextBoolean(), DisabilityType.values()[random.nextInt(DisabilityType.values().length)], endereco, user);
//    }
//
//    // Funções auxiliares para gerar CPF, telefone e CEP
//    private static String gerarCPF() {
//        // Gera um CPF aleatório sem validação
//        StringBuilder cpf = new StringBuilder();
//        for (int i = 0; i < 11; i++) {
//            cpf.append(random.nextInt(10));
//        }
//        return cpf.toString();
//    }
//
//    private static String gerarTelefone() {
//        // Gera um telefone aleatório sem validação
//        StringBuilder telefone = new StringBuilder();
//        telefone.append("(47) "); // DDD exemplo
//        for (int i = 0; i < 9; i++) {
//            telefone.append(random.nextInt(10));
//        }
//        return telefone.toString();
//    }
//
//    private static String gerarCEP() {
//        // Gera um CEP aleatório sem validação
//        StringBuilder cep = new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            cep.append(random.nextInt(10));
//        }
//        return cep.toString();
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        List<User> usuarios =  userRepository.findAll();
//        if(usuarios.size() != 0){
//            return;
//        }
//
//        User admin = userRepository.save(new User(null, "admin", "admin@gmail.com",
//                encoder.encode("123"), AccessLevel.Admin, null));
//        User user = userRepository.save(new User(null, "user", "user@gmail.com",
//                encoder.encode("123"), AccessLevel.User, null));
//
////        PCD pcd = pcdRepository.save(new PCD(null, "PCD 1", "123.456.789-10",
////                new Date("12/11/2024"), "(47) 99142-0119", "pcd1@gmail.com",
////                Gender.Masculino, EducationLevel.EnsinoMedio, true, true,
////                DisabilityType.AUDITIVA, new Address(null, "Jaraguá do Sul", "Isidoro Pedri",
////                "Rio Molha", 263, "", "89259-590"), user));
//
//        for (int i = 0; i < 300; i++) {
//            pcdRepository.save(gerarPCDAleatorio(user));
//        }
//    }
//}
