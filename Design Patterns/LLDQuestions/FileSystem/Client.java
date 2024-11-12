package LLDQuestions.FileSystem;

public class Client {
    public static void main(String[] args) {
        Directory laptops = new Directory("Laptops");
        FileSystem mac = new File("Mac Apple 16 Pro");
        FileSystem lenovo = new File("Lenovo Pro");

        Directory gamingLaptops = new Directory("Gaming Laptops");
        FileSystem asus = new File("Asus Gamer");
        gamingLaptops.add(asus);

        laptops.add(mac);
        laptops.add(lenovo);
        laptops.add(gamingLaptops);

        laptops.ls();
    }
}
