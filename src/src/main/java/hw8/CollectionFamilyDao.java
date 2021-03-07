package hw8;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{

    final List<Family> familiesDB = new ArrayList<>();
    @Override
    public List<Family> getAllFamilies() {
        return null;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return false;
    }

    @Override
    public void saveFamily(Family family) {

    }
}
