package comparators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private String name;
    private int age;
    private String nationality;
    private int number;
    private String position;

    public String getLastName() {
        if(name.contains(" "))
            return name.substring(name.indexOf(' ') + 1);
        return name;
    }

    public String getFirstName() {
        if(name.contains(" "))
            return name.substring(0, name.indexOf(' '));
        return "";
    }
}
