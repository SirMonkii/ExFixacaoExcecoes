package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double wdLimit = sc.nextDouble();

            Account account = new Account(number,holder, initBalance, wdLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw ");
            double amount = sc.nextDouble();


            account.withdraw(amount);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Unexpected data type");
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
