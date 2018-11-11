package File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileManager implements Serializable {
	
	
	// writing in a file
    public boolean write(String FilePath, Object data) {

        try {
            System.out.print("\nwritting in ! " + FilePath);

            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));

            writter.writeObject(data);

            System.out.println(" ... Done ! ");
            writter.close();
            return true;

        } catch (IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    }

    // Reading from a file
    public Object read(String FilePath) {

        Object Result = null;

        try {
            System.out.println("Reading ! From " + FilePath);

            @SuppressWarnings("resource")
			ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Result;

    }

}