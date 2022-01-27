import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Main {
    private ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private Client a;
    private Client b;
    private Client test;
    private Bank bank;

    @BeforeTest
    public void create() {
        a = context.getBean("client1", Client.class);
        b = context.getBean("client2", Client.class);
        test = new Client(1500);
        bank = context.getBean("bank", Bank.class);
    }

    @Test
    public void test() {
        Assert.assertFalse(bank.giveDeposit(999, a));
        Assert.assertTrue(bank.giveDeposit(1000, b));
        Assert.assertFalse(bank.giveCredit(100, test));
    }
    @AfterTest
    public void additionalTask(){
        ArrayList<Client> clients = context.getBean("clients", ArrayList.class);
        clients.forEach(n -> System.out.println("Name: " + n.getName() + "\n Salary:" + n.getSalary() + "\n\n"));
    }
}
