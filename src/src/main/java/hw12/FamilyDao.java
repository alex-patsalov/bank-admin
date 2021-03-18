package hw12;

import java.io.IOException;
import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    Family saveFamily(Family family);
    void saveData(List<Family> data) throws IOException;
    List<Family> getData() throws IOException, ClassNotFoundException;
}
