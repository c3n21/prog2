import java.util.Scanner;

public class Test {
    public static void main (String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            SimpleMap map = new SimpleMap();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                switch(line.charAt(0)) {
                    case '+':
                        line = line.substring(1).trim();
                        String [] params = line.split(" ");
                        map.put(params[0], Integer.parseInt(params[1]));
                        break;

                    case '-':
                        String param = line.substring(1).trim();

                        try {
                            int value = map.get(param);
                            System.out.println(value);
                        } catch (NotFoundException e) {
                            //eventualmente gestire questa eccezione
                            //ma non e' richiesto dalla consegna
                        }

                        map.remove(param);
                        break;
                }

                System.out.println(map.toString());
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Comando mal formattato", e);
        }
    }
}
