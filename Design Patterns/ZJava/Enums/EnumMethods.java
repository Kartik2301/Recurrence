package ZJava.Enums;

public enum EnumMethods {
    RED {
        @Override
        public void makeNoise() {
            System.out.println("Making Noise at 5000 DB");
        }
    },
    YELLOW {
        @Override
        public void handleMethod() {
            System.out.println("You are most welcome");
        }

        @Override
        public void makeNoise() {
            System.out.println("Making Noice at 1000 DB");
        }
    },
    BLUE {
        @Override
        public void handleMethod() {
            System.out.println("You filthy pig, get out");
        }

        @Override
        public void makeNoise() {
            System.out.println("That is so loud, please shut up");
        }
        
    };

    public void handleMethod() {
        System.out.println("Thanks for calling the method, now get!!");
    }

    public abstract void makeNoise();

    public static void randomStaticMethod() {
        System.out.println("This is a static method, no constant needed to call me.");
    }
}
