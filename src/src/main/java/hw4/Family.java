package hw4;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Pet pet;
    private Human[] children = new Human[1];

    public String getPet(){return this.pet.toString();}
    public Pet setPet(Pet pet){return this.pet = pet;}
    public String getPetName(){return this.pet.getNickname();}
    public String setPetName(String name){return this.pet.setNickName(name);}
    public int getPetTrickLevel(){
        return this.pet.getTrickLevel();
    }
    public int setPetTrickLevel(int newTrickLevel){
        return this.pet.setTrickLevel(newTrickLevel);
    }
    public String getPetSpecies(){return this.pet.getSpecies();}
    public String setPetSpecies(String species){return this.pet.setSpecies(species);}
    public int getPetAge(){return this.pet.getAge();}
    public int setPetAge(int age){return this.pet.setAge(age);}
    public String getMother(){return this.mother.toString();}
    public Human setMother(Human mother){return this.mother = mother;}
    public String getFather(){return this.father.toString();}
    public Human setFather(Human father){return this.father = father;}
    public int getChildrenQnty(){return this.children.length;}
    public Human[] getChildren(){return this.children;}

    public Human[] addChild(Human child){
        Human[] newChild = {child};
        Human[] both;
        if(this.children[0] == null){
            both = Arrays.copyOf(newChild, 1);
        } else {
            both = Arrays.copyOf(this.children, this.children.length + 1);
            both[this.children.length] = newChild[0];
        }
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

    public Family(Human mother, Human father, Pet pet) {
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
        this.pet = pet;
        this.pet.setOwner(father);
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Family that = (Family) obj;

        return this.getFather().equals(that.getFather()) && this.getMother().equals(that.getMother());
    }
}
