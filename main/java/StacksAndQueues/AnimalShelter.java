package StacksAndQueues;

import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<String> catsAndDogs = new LinkedList<>();


    public boolean enqueue(String animal) {
        return catsAndDogs.add(animal);
    }

    public String dequeueAny() {
        return catsAndDogs.removeFirst();
    }

    private String dequeueAnimal(String type) {
        int index = -1;
        for (int i = 0; i < catsAndDogs.size(); i++) {
            if (catsAndDogs.get(i).equalsIgnoreCase(type)) {
                index = i;
            }
        }
        if (index == -1) return null;
        return catsAndDogs.remove(index);
    }

    public String dequeueDog() {
        return dequeueAnimal("Dog");
    }

    public String dequeueCat() {
        return dequeueAnimal("Cat");
    }

}
