package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome do departamento: ");
		String name = sc.nextLine();
		System.out.println("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.println("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.println("Telefone: ");
		String number = sc.nextLine();
		
		Department department = new Department(name, payDay, new Address(email, number));
		
		System.out.println("Quantos funcionarios tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=0; i < n ; i++) {
			System.out.println("Dados do funcionario " + (i+1));
			System.out.println("Nome: ");
			sc.nextLine();
			String nameEmp = sc.nextLine();
			System.out.println("Salario: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(nameEmp, salary);
			department.addEmployee(emp);
		}
		showReport(department);
		
		sc.close();
		
	}
	
	private static void showReport(Department department) {
		
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.printf("Departamento de vendas = R$ %.2f%n", department.payRoll());
		System.out.printf("Pagamento realizado no dia %d%n", department.getPayDay());
		System.out.println("Funcionários: ");
		
		for (Employee emp : department.getEmployees()) {
			System.out.println(emp.getName());
		}
		
		System.out.printf("Para dúvidas, favor entrar em contrato: %s", department.getAddress().getEmail());
	}
}
