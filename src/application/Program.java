package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDao userDao = DaoFactory.createUserDao();

        int option = -1;

        do {
            System.out.println("\n===============================================");
            System.out.println("               SISTEMA DE USUÁRIOS");
            System.out.println("===============================================");
            System.out.println("  1 - Inserir Usuário");
            System.out.println("  2 - Listar Usuários");
            System.out.println("  3 - Buscar Usuário por ID");
            System.out.println("  4 - Atualizar Usuário");
            System.out.println("  5 - Deletar Usuário");
            System.out.println("  0 - Sair");
            System.out.println("===============================================");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine();

            System.out.println("-----------------------------------------------");

            switch (option) {
                case 1:
                    System.out.println("INSERIR USUÁRIO");
                    System.out.print("Nome: ");
                    String n = sc.nextLine();
                    System.out.print("Email: ");
                    String e = sc.nextLine();
                    User u = new User(null, n, e);
                    userDao.insert(u);
                    System.out.println("Usuário inserido! ID = " + u.getId());
                    break;

                case 2:
                    System.out.println("LISTA DE USUÁRIOS:");
                    List<User> list = userDao.findAll();
                    for (User us : list) {
                        System.out.println(us);
                    }
                    break;

                case 3:
                    System.out.print("ID do usuário: ");
                    String id = sc.nextLine();
                    System.out.println("Resultado:");
                    System.out.println(userDao.findById(id));
                    break;

                case 4:
                    System.out.print("ID do usuário que deseja atualizar: ");
                    String updateId = sc.nextLine();
                    User up = userDao.findById(updateId);

                    if (up != null) {
                        System.out.print("Novo nome: ");
                        up.setName(sc.nextLine());
                        System.out.print("Novo email: ");
                        up.setEmail(sc.nextLine());
                        userDao.update(up);
                        System.out.println("Usuário atualizado!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("ID do usuário para deletar: ");
                    String deleteId = sc.nextLine();
                    userDao.deleteById(deleteId);
                    System.out.println("Usuário deletado!");
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}
