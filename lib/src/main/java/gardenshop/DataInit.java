package gardenshop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataInit {

	public static List<Shop> loadData() {
		List<Shop> shops = null;
		try {
			FileInputStream fis = new FileInputStream("shops.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			shops = (List<Shop>) ois.readObject();

			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
		return shops;
	}

	public static void saveData(List<Shop> shops) {
		try {
			FileOutputStream fos = new FileOutputStream("shops.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(shops);

			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
