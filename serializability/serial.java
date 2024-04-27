import java.io.*;

class MyClass implements Serializable {
    private String name;
    private transient int age; // This field will not be serialized

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object of MyClass
        MyClass obj = new MyClass("John", 30);

        // Serialize the object to a file
        try {
            FileOutputStream fileOut = new FileOutputStream("object.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            fileOut.close();
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object from the file
        try {
            FileInputStream fileIn = new FileInputStream("object.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            MyClass newObj = (MyClass) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Object deserialized successfully:");
            System.out.println(newObj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
