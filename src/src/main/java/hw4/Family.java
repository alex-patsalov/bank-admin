package hw4;

import java.util.Arrays;

public class Family {
    private Human mother = this.mother;
    private Human father = this.father;
    private Pet pet;
    private Human[] children = new Human[1];

    public String getPet(){return this.pet.toString();}
    public Pet setPet(Pet pet){return this.pet = pet;}
    public String getMother(){return this.mother.toString();}
    public Human setMother(Human mother){return this.mother = mother;}
    public String getFather(){return this.father.toString();}
    public Human setFather(Human father){return this.father = father;}
    public int getChildrenQnty(){return this.children.length;}
    public Human[] getChildren(){return this.children;}

    public Human[] addChild(Human child){
        Human[] newChild = {child};
//        Human[] both = Arrays.copyOf(this.children, this.children.length + 1);
        Human[] both = Arrays.copyOf(this.children, this.children.length);
        System.out.println("both before" + Arrays.toString(both));
//        System.arraycopy(newChild, 0, both, both.length - 1, 1);
        System.arraycopy(newChild, 0, both, both.length - 1, 1);
        System.out.println("both after1" + Arrays.toString(both));
//        System.arraycopy(both, 1, both, 0, both.length - 1);
//        both = Arrays.copyOfRange(both, 1, both.length);

        System.out.println("both after2" + Arrays.toString(both));
        this.children = both;
        return both;
    }
    public int findIndex(Human child){
        int index = -1;
        for (int i = 0; (i < this.children.length) && (index == -1); i++) {
            if (this.children[i] == child) {
                index = i;
            }
        }
        return index;
    }
    public boolean deleteChild(int index){
        Human[] newChildrenArr = new Human[this.children.length - 1];
        System.arraycopy(this.children, 0, newChildrenArr, 0, index);
        System.arraycopy(this.children, index + 1, newChildrenArr, index, this.children.length - index - 1);
        this.children = newChildrenArr;
        return true;
    }
    public String toString(){
        return String.format("Family: mother='%s', father='%s', pet='%s', children='%s'", this.mother.getName(), this.father.getName(), this.pet.getNickname(), Arrays.toString(this.children));
    }

    public int countFamily(Family family){return 2 + getChildrenQnty();}

    public Family(Human mother, Human father){
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
    }
    public Family(Human mother, Human father, Human child, Pet pet){
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
        this.pet = pet;
        this.pet.setOwner(child);
        child.setFamily(this);
        this.children = this.addChild(child);

    }

}
