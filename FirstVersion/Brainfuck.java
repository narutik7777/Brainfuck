import java.util.Scanner;

class BrainFuck {
    private static Scanner ob = new Scanner(System.in);
    private static int ptr; // Data pinter


    private static int length = 65535;


    private static byte memory[] = new byte[length];

    // Interpreter function which accepts the code
    // a string parameter
    private static void interpret(String s) {
        int c = 0;





        // Parsing through each character of the code
        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == '>') {
                if (ptr == length - 1)
                    ptr = 0;
                else
                    ptr++;
            } else if (s.charAt(i) == '<') {
                if (ptr == 0)
                    ptr = length - 1;
                else
                    ptr--;
            } else if (s.charAt(i) == '+')
                memory[ptr]++;


            else if (s.charAt(i) == '-')
                memory[ptr]--;


            else if (s.charAt(i) == '.')
                System.out.print((char) (memory[ptr]));

                // , inputs a character and store it in the
                // cell at the pointer
            else if (s.charAt(i) == ',')
                memory[ptr] = (byte) (ob.next().charAt(0));


            else if (s.charAt(i) == '[') {
                if (memory[ptr] == 0) {
                    i++;
                    while (c > 0 || s.charAt(i) != ']') {
                        if (s.charAt(i) == '[')
                            c++;
                        else if (s.charAt(i) == ']')
                            c--;
                        i++;
                    }
                }
            } else if (s.charAt(i) == ']') {
                if (memory[ptr] != 0) {
                    i--;
                    while (c > 0 || s.charAt(i) != '[') {
                        if (s.charAt(i) == ']')
                            c++;
                        else if (s.charAt(i) == '[')
                            c--;
                        i--;
                    }
                    i--;
                }
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Enter the code:");
        String code = ob.nextLine();
        System.out.println("Output:");
        interpret(code);
    }
