import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char var = 0;
        Pattern p = Pattern.compile(args[0]);
        System.out.println("Press \"F\" if the input information is in the file and \"T\" if you will enter manually");
        System.out.println("(Введите \"F\", если входная информация будет в виде файла или \"T\" если ввод будет осуществлен вручную)");
        while (var != 'F' && var != 'T') {
            var = (char) reader.read();
            if (var == 'F')
                codeForFile(p);
            else if (var == 'T')
                codeForManually(p);
        }
        reader.close();
    }

    static void codeForFile(Pattern p) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String nameOfFile = sc.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
        String line;
        int count = 0 , totalCount = 0;
        while (reader.ready()) {
            line = reader.readLine();
            totalCount++;

            Matcher m = p.matcher(line);
            if (m.find()) {
                System.out.println(line);
                count++;
            }
        }
        System.out.print ("Total number of rows : ");
        System.out.println(totalCount);
        System.out.print ("Number of rows with the source pattern : ");
        System.out.println(count);
        reader.close();
        sc.close();

    }
    static void codeForManually(Pattern p) throws IOException {
        System.out.println("Enter the text");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        int count = 0 , totalCount = 0;
        while ((line = reader.readLine()).length() != 0) {
            totalCount++;

            Matcher m = p.matcher(line);
            if (m.find()) {
                stringBuilder.append(line + ls);
                count++;
            }
        }
        System.out.println(stringBuilder);
        System.out.print ("Total number of rows : ");
        System.out.println(totalCount);
        System.out.print ("Number of rows with the source pattern : ");
        System.out.println(count);
        reader.close();

    }
}
