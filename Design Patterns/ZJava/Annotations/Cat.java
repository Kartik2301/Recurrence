package ZJava.Annotations;

@VeryImportant
public class Cat {
    @ImportantString
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    @RunImmediately
    public void sayMeow() {
        System.out.println("Bark");
    }

    public void eat() {
        System.out.println("Eating Cat");
    }
}
