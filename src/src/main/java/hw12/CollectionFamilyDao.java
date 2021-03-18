package hw12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao, Serializable {

    final List<Family> familiesDB = new ArrayList<>();

    public CollectionFamilyDao() throws IOException, ClassNotFoundException {
    }
    @Override
    public List<Family> getAllFamilies() {
        return this.familiesDB;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return this.familiesDB.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        try{
            List<Family> data = this.getData();
            data.remove(index);
            this.saveData(data);
        } catch (IllegalArgumentException | IOException | ClassNotFoundException e){
            e.getMessage();
        }
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        try{
            List<Family> data = this.getData();
            data.remove(family);
            this.saveData(data);
        } catch (IllegalArgumentException | IOException | ClassNotFoundException e){
            e.getMessage();
        }
        return true;
    }

    @Override
    public Family saveFamily(Family family) {
        if(this.familiesDB.contains(family)){
            int index = this.familiesDB.indexOf(family);
            this.familiesDB.set(index, family);
            try{
                List<Family> data = this.getData();
                data.set(index,family);
                this.saveData(data);
            } catch (IllegalArgumentException | IOException | ClassNotFoundException e){
                e.getMessage();
            }

        } else {
            this.familiesDB.add(family);
            try{
                List<Family> data = this.getData();
                data.add(family);
                this.saveData(data);
            } catch (IllegalArgumentException | IOException | ClassNotFoundException e){
                e.getMessage();
            }
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
