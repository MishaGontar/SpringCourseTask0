import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Data
public class Bank {
    @Autowired
    private List<Client> clients;
    private String name;
    @Autowired
    private Logger logger;

    private boolean isClient(Client client) {
        return !Objects.isNull(client) && clients.contains(client);
    }

    public boolean giveCredit(int credit, Client client) {
        return isClient(client) && ((credit * 0.1 + credit) <= client.getSalary() * 12);
    }

    public boolean giveDeposit(int givMon, Client client) {
        return isClient(client) && givMon >= 1000;
    }
}
