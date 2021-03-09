package hw8;

import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    Family deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
