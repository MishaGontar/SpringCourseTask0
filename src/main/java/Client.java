import lombok.Data;
import lombok.NonNull;

@Data
public class Client {
    @NonNull private int salary;
    private String name = "Bot client";
}
