package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.")

public class App {
        @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
        boolean version;

        @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
        boolean help;

        @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
        File format;

        @Parameters(index = "0", description = "path to first file", defaultValue = "/etc/hosts")
        private File filepath1 = new File("/etc/hosts");

        @Parameters(index = "0", description = "path to second file", defaultValue = "/etc/hosts")
        private File filepath2 = new File("/etc/hosts");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        App app = CommandLine.populateCommand(new App(), args);
        if (app.help) {
            CommandLine.usage(new App(), System.out);
            return;
        }
    }
}

