import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("in.txt"));
        PrintWriter out = new PrintWriter("out.txt");

        while (in.hasNextLine()) {
            Parser parser = new Parser(in.nextLine());
            Expression expression = parser.parse();
            if (parser.isParsed())
                out.println(expression.calculate());
            else
                out.println("Invalid expression");
        }

        out.close();
    }
}
