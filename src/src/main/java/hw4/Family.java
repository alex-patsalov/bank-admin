package hw4;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Pet pet;
    private Human[] children;

    public String getPet(){return this.pet.toString();}
    public Pet setPet(Pet pet){return this.pet = pet;}
    public String getMother(){return this.mother.toString();}
    public Human setMother(Human mother){return this.mother = mother;}
    public String getFather(){return this.father.toString();}
    public Human setFather(Human father){return this.father = father;}
    public String getChildren(){return Arrays.toString(this.children);}
    public Human[] setChildren(Human child){
        Human[] newChild = {child};
        Human[] both = Arrays.copyOf(this.children, this.children.length + 1);
        System.arraycopy(newChild, 0, both, this.children.length + 1, 1);
        //might be a mistake
        System.out.printf("this new children array--->> %s", Arrays.toString(both));
        return both;
    }

}
