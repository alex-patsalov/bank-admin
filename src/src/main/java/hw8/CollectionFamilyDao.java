package hw8;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{

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
    public void saveFamily(Family family) {
        if(this.familiesDB.contains(family)){
            int index = this.familiesDB.indexOf(family);
            this.familiesDB.set(index, family);
        } else {
            this.familiesDB.add(family);
        }
    }
}
