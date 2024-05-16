import dao.CarrosDAO;
import dao.iCarrosDAO;
import domain.Carro;
import domain.Luxo;
import domain.Antigo;
import java.util.Scanner;

public class App {
    private static iCarrosDAO ICarrosDAO;
    public static void main(String[] args) {
        ICarrosDAO = new CarrosDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
        int opcao = Integer.parseInt(scanner.next());
        while (!isOpcaoValida(opcao)){
            System.out.println("Opção inválida! ");
            System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
            opcao = Integer.parseInt(scanner.next());
        }
        while (isOpcaoValida(opcao)){
            if (opcao == 1){
                System.out.println("Bem-vindo ao EBACar! Escolha o modelo do seu carro:");
                System.out.println("1 - Mercedes");
                System.out.println("2 - Ferrari");
                System.out.println("3 - Opala");
                System.out.println("4 - Eclipse");
                System.out.print("Escolha o modelo do carro: ");
                int modelo = scanner.nextInt();
                System.out.print("Insira a cor do carro: ");
                String cor = scanner.next();
                System.out.print("O carro é completo? (Digite 'sim' para sim, ou deixe em branco para não): ");
                boolean completo = isCompleto(scanner.next());
                System.out.print("Insira o CPF do proprietário do carro: ");
                Long cpf = Long.parseLong(scanner.next());
                if (modelo == 1 || modelo == 2){
                    Carro carroLuxo = new Luxo(modelo,cor,completo,cpf);
                    Boolean isCadastrado = ICarrosDAO.cadastrarPedido(carroLuxo);
                    confereCadastro(isCadastrado);
                    System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
                    opcao = Integer.parseInt(scanner.next());

                } else if (modelo == 3||modelo == 4) {
                    Carro carroAntigo = new Antigo(modelo,cor,completo,cpf);
                    Boolean isCadastrado = ICarrosDAO.cadastrarPedido(carroAntigo);
                    confereCadastro(isCadastrado);
                    System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
                    opcao = Integer.parseInt(scanner.next());
                }else {
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println("XXXXXXXXX   Modelo Inválido   XXXXXXXX");
                    System.out.println("XXXXX   Digite qualquer Número   XXXXX");
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    modelo = Integer.parseInt(scanner.next()); // Atualiza o valor de 'modelo'
                }
            }
            if (opcao == 2) {
                System.out.println("Escreva o seu cpf para consulta de pedidos: ");
                Long cpf = Long.parseLong(scanner.next());
                Carro carroConsultado = ICarrosDAO.consultarPedidos(cpf);
                if (carroConsultado != null){
                    System.out.println("Detalhes do carro consultado:");
                    System.out.println(carroConsultado.toString());
                    System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
                    opcao = Integer.parseInt(scanner.next());
                }else {
                    System.out.println("Nenhum carro encontrado com o CPF fornecido.");
                    System.out.println("Digite 1 para fazer um pedido ou digite 2 para consultar um pedido  (3 para sair)");
                    opcao = Integer.parseInt(scanner.next());
                }
            }
            if (opcao == 3){
                sair();
                break;
            }


        }
        }


    private static void confereCadastro(Boolean isCadastrado) {
        if (isCadastrado){
            System.out.println("Pedido cadastrado com sucesso!");
        }else {
            System.out.println("Pedido já cadastrado!");
        }
    }

    private static void sair() {
        System.out.println("Saindo...");
    }

    private static boolean isOpcaoValida(int opcao) {
        if(opcao == 1 || opcao == 2 || opcao == 3){
            return true;
        }
        return false;
    }


    private static boolean isCompleto(String resposta) {
        return resposta.equalsIgnoreCase("sim");
    }
}