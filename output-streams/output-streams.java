import java.io.*;

public class DataOutputStreamExample {
    public static void main(String[] args) {
        try {
            // Create a DataOutputStream wrapped around a FileOutputStream
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));

            // Write various data types to the file
            dos.writeInt(42);
            dos.writeDouble(3.14);
            dos.writeUTF("Hello, world!");

            // Close the stream
            dos.close();

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
