import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            int num = scanner.nextInt();
            int x = Integer.bitCount(num);

            if (x % 2 == 0) {
                String dual = Integer.toBinaryString(num);

                StringBuilder sb = new StringBuilder("");
                for (int i = dual.length(); i < 8; i++) {
                    sb.append(0);
                }
                sb.append(dual);
                sb.replace(0,1,"0");

                int decimal = Integer.parseInt(sb.toString(), 2);

                //                System.out.println(num + "/" + sb + "/" + x + "/" + decimal);
                System.out.print(Character.toChars(decimal));
                if(decimal == 46) break;
            }
        }
    }
}
