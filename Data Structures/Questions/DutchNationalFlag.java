/**
 * Q. Given some balls of three colors arranged in a line, rearrange them
 * such that all the red balls go first, then green and then blue ones.
 */

public class Main {
    static int index = 0;
    static char balls[] = {'G','B','G','G','R','B','R','G'};
    static void setColour() {
        // Comparing the characters using ASCII values for Red color
        for(int i = 0; i < balls.length; i++) {
            if(balls[i] == 82){
                char temp = balls[index];
                balls[index] = balls[i];
                balls[i] = temp;
                index++;
            }
        }
        // Comparing the characters using ASCII values for green color
        for(int i = index; i < balls.length; i++) {
            if(balls[i] == 71){
                char temp = balls[index];
                balls[index] = balls[i];
                balls[i] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("The balls in correct order are");
        setColour();
        for(int j = 0; j < balls.length; j++) {
            System.out.println(balls[j]);
        }
    }
}
