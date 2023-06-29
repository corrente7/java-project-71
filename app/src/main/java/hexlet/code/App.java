package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public final class App implements Callable {

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    private static String format;

    @Parameters(index = "0", description = "path to first file", defaultValue = "/home/nadi777/file1.json")
   private static String filepath1;

    @Parameters(index = "1", description = "path to second file", defaultValue = "/home/nadi777/file2.json")
   private static String filepath2;

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return 0;
    }
}

