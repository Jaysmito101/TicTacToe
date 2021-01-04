public class Constants {
    private Constants(){}

    public static int EASY_PROBABILITY=2;
    public static int MEDIUM_PROBABILITY=1;
    public static int HARD_PROBABILITY=0;
    public static int AI=1;
    public static int HUMAN=2;

    public static String getProbability(int probability) {
        switch (probability) {
            case 2:return "EASY";

            case 1:return "MEDIUM";

            case 0:return "HARD";
        }
        return "";
    }
}