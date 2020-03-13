public class Tododone {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(new Output(), new Input());
        userInterface.Run();
    }
}



