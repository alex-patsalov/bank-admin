package hw12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao, Serializable {

    final List<Family> familiesDB = new ArrayList<>();
    @Override
    public List<Family> getAllFamilies() {
        return this.familiesDB;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return this.familiesDB.get(index);
    }

    @Override
    public Family deleteFamily(int index) {
        return this.familiesDB.remove(index);
    }

    @Override
    public boolean deleteFamily(Family family) {
        return this.familiesDB.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        if(this.familiesDB.contains(family)){
            int index = this.familiesDB.indexOf(family);
            this.familiesDB.set(index, family);
        } else {
            this.familiesDB.add(family);
        }
        return family;
    }

    @Override
    public void saveData(List<Family> data) throws IOException {
        File file = new File("DB.bin");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data);
        oos.close();
    }
    public List<Family> getData() throws IOException, ClassNotFoundException {
        File file = new File("DB.bin");
        FileInputStream fos = new FileInputStream(file);
        ObjectInputStream oos = new ObjectInputStream(fos);
        List<Family> families = (List<Family>) oos.readObject();
        System.out.println("This is data from DB:");
        families.forEach(System.out::println);
        oos.close();
        return families;
    }
}
