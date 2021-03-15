package hw11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Family {
    private Woman mother;
    private Man father;
    private Set<Pet> pets = new HashSet<>();
    private ArrayList<Human> children = new ArrayList<>();

    public String getAllPets(){return this.pets.toString();}
    public Pet getPet(Pet pet){
        for (Pet that : this.pets) {
            if (that.equals(pet)) {
                return that;
            }
        }
        return null;
    }
    public boolean addPet(Pet pet){return this.pets.add(pet);}
    public boolean removePet(Pet pet){
        return this.pets.contains(pet) && this.pets.remove(pet);
    }
    public String getPetName(Pet pet){
        return this.getPet(pet).getNickname();
    }
    public String setPetName(String name, Pet pet){
        return this.getPet(pet).setNickName(name);
    }
    public int getPetTrickLevel(Pet pet){
        return this.getPet(pet).getTrickLevel();
    }
    public int setPetTrickLevel(Pet pet, int newTrickLevel){
        return this.getPet(pet).setTrickLevel(newTrickLevel);
    }
    public Species getPetSpecies(Pet pet){
        return this.getPet(pet).getSpecies();
    }
    public int getPetAge(Pet pet){return this.getPet(pet).getAge();}
    public int setPetAge(Pet pet, int age){return this.getPet(pet).setAge(age);}
    public String getMother(){return this.mother.toString();}
    public Human setMother(Woman mother){return this.mother = mother;}
    public String getFather(){return this.father.toString();}
    public Human setFather(Man father){return this.father = father;}
    public String getFamilyName(Family family){return this.father.getSurname();}
    public int getChildrenQnty(){return this.children.size();}
    public ArrayList<Human> getChildren(){return this.children;}
    public ArrayList<Human> addChild(Human child){
        if(!this.children.contains(child)) this.children.add(child);
        return this.children;
}
    public void deleteChild(Human child){
        int index = this.children.indexOf(child);
        if(index >= 0) this.children.remove(child);
    }
    public String toString(){
        return String.format("Family: mother='%s', father='%s', pet='%s', children='%s'", this.mother.getName(), this.father.getName(), this.pets, this.children);
    }
    public String prettyFormat(){
        return String.format("Family:\nmother:\n%s\nfather:\n%s\nkids:\n%s\npets:\n%s\n", this.mother.prettyFormat(), this.father.prettyFormat(), this.prettyChildrenFormat(this.children), this.prettyPetsFormat(this.pets));
    }
    public String prettyChildrenFormat(ArrayList<Human> children){
        return children.stream()
                .map(Human::prettyFormat)
                .collect(Collectors.joining());
    }
    public String prettyPetsFormat(Set<Pet> pets){
        return pets.stream()
                .map(Pet::prettyFormat)
                .collect(Collectors.joining());
    }
    public int countFamily(Family family){return 2 + getChildrenQnty();}
    public Family(Woman mother, Man father){
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
    }
    public Family(Woman mother, Man father, Pet pet) {
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
        this.pets.add(pet);
    }
    public Family(Woman mother, Man father, Human child){
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
        child.setFamily(this);
        this.children = this.addChild(child);
    }
    public Family(Woman mother, Man father, Human child, Pet pet){
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
        this.pets.add(pet);
        child.setFamily(this);
        this.children = this.addChild(child);
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Family that = (Family) obj;

        return this.getFather().equals(that.getFather()) && this.getMother().equals(that.getMother());
    }
    protected void finalize(){
        System.out.printf("This is what've been deleted -->\n-->> %s\n", this.toString());
    }
}
