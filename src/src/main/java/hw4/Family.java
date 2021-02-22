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
    public int getChildrenQnty(){return this.children.length;}
    public Human[] getChildren(){return this.children;}

    public Human[] addChild(Human child){
        Human[] newChild = {child};
        Human[] both = Arrays.copyOf(this.children, this.children.length + 1);
        System.arraycopy(newChild, 0, both, this.children.length + 1, 1);
        //might be a mistake
        System.out.printf("this new children array--->> %s", Arrays.toString(both));
        return both;
    }
//    public int findIndex(Human child){
//        Human[] children = getChildren();
//
//        return
//    }
//    public boolean deleteChild(int index){
//
//    }
    public String toString(){
        return String.format("Family: mother='%s', father='%s', pet='%s', children='%s'", this.mother.toString(), this.father.toString(), this.pet.toString(), Arrays.toString(this.children));
    }

    public int countFamily(Family family){return 2 + getChildrenQnty();}

    public Family(Human mother, Human father){
        this.mother = mother;
        this.father = father;
    }

}
