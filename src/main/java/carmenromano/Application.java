package carmenromano;

import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        UUID randomUUID = UUID.randomUUID();
        String uuid = randomUUID.toString();
        if (uuid.length() > 13) {
            uuid = uuid.substring(0, 13);
        }
        System.out.println("ID generated = " + uuid);
    }
}
