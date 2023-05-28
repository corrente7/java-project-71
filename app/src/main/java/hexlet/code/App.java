package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable {
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
   boolean version;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
   boolean help;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "json")
    private static String format;

    @Parameters(index = "0", description = "path to first file", defaultValue = "/home/nadi777/stylish1.json")
   private static String filepath1;

    @Parameters(index = "1", description = "path to second file", defaultValue = "/home/nadi777/stylish2.json")
   private static String filepath2;

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
//        System.out.println(Parser.detectTypeFile(getFilepath1()));
//        System.out.println(Parser.detectTypeFile(getFilepath2()));
        System.out.println(Differ.generate(getFilepath1(), getFilepath2(), format));
//        Map<String, Object> file1 = Map.of(
//                "date_end", "2020-06-10T23:59:59+03:00",
//                "description", "product1",
//                "discount_label", "1+1",
//                "id", 11111
//        );
//        Map<String, Object> file2 = Map.of(
//                "barcode", "3113097501031",
//                "description", "product2",
//                "discount_label", "1+1",
//                "price_is_from", false
//        );
//        System.out.println(Differ.generate(file1, file2));
        return 0;
    }

    public static String getFilepath1() {
        return filepath1;
    }

    public static String getFilepath2() {
        return filepath2;
    }

}

