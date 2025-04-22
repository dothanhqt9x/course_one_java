package example.read.file;

public class Main {

    static final String FILE_PATH_ONE = "/Users/caominhthai/WorkSpace/java/untitled/src/example_read_file/inputBai1.txt";
    static final String FILE_PATH_TWO = "/Users/caominhthai/WorkSpace/java/untitled/src/example_read_file/inputBai2.txt";

    public static void main(String[] args) {

        //Bai 1
        ReadFile readFileOne = new ReadFile();
        readFileOne.readFileBuffer(FILE_PATH_ONE);
        var result = CountChar.countCharWithCollection(readFileOne.getChars());
        System.out.println(result);

        //Bai 2
        ReadFile readFileTwo = new ReadFile();
        readFileTwo.readFileBuffer(FILE_PATH_TWO);
        var resultTwo = CountChar.countCharWithMap(readFileTwo.getChars());
        System.out.println(resultTwo);

    }

}
