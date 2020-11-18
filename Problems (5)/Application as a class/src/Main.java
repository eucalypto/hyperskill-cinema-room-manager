class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (var argument : args) {
            System.out.println(argument);
        }
    }
}