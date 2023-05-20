package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable {
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
   boolean version;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
   boolean help;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
   File format;

    @Parameters(index = "0", description = "path to first file", defaultValue = "/home/nadi777/file1.json")
   private static String filepath1;

    @Parameters(index = "1", description = "path to second file", defaultValue = "/home/nadi777/file2.json")
   private static String filepath2;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        //System.out.println(Differ.getData(getFilepath1()));
        //System.out.println(Differ.getData(getFilepath1()));
        System.out.println(Differ.toString
                (Differ.generate(Differ.getData(getFilepath1()), Differ.getData(getFilepath2()))));
        return 0;
    }

    public static String getFilepath1() {
        return filepath1;
    }

    public static String getFilepath2() {
        return filepath2;
    }
}

