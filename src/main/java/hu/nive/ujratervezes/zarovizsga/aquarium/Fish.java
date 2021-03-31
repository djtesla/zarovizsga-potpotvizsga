package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish implements HasMemoryLoss {

    private String name;
    private int weight;
    private String color;


    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(", ");
        sb.append("weight: " + weight + ", ");
        sb.append("color: " + color + ", ");
        sb.append("short term memory loss: " + hasMemoryLoss());
        return sb.toString();
    }

    public abstract void feed();


}
