import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Client a = context.getBean("client1" , Client.class);
        Client b = context.getBean("client2" , Client.class);
        Client test = new Client(1500);

        Bank bank = context.getBean("bank", Bank.class);

        System.out.println(bank.giveDeposit(999,b));
        System.out.println(bank.giveDeposit(1000,b));
        System.out.println(bank.giveCredit(100, test));


        ArrayList<Client> clients = context.getBean("clients",ArrayList.class);
        clients.forEach(n-> System.out.println("Name: " + n.getName() + " salary:" + n.getSalary()));
    }
}
