import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyTest {
    public static void main (String args[]) {
        SimpleMap map = new SimpleMap();
        SimpleMap map2 = new SimpleMap();

        try (Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    switch(line.charAt(0)) {
                        case '+':
                            line = line.substring(1).trim();
                            String [] params = line.split(" "); try {
                                map.put(params[0], Integer.parseInt(params[1]));
                                map2.put(params[0], Integer.parseInt(params[1]));
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                            break;

                        case '-':
                            line = line.substring(1).trim();
                            params = line.split(" ");

                            try {
                                int value = map.get(params[0]);
                                System.out.println(value);
                                map.remove(params[0]);
                                map2.remove(params[0]);
                            } catch (NoSuchElementException e) {
                                //eventualmente gestire questa eccezione
                                //ma non e' richiesto dalla consegna
                                System.out.println("Not found");
                            }

                            break;
                    }
                } 
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Comando mal formattato", e);
        }
        System.out.println(map.size());

        System.out.println("Testing equals: " + map.equals(map2));
        System.out.println("Testing map.hashcode: " + map.hashCode());
        System.out.println("Testing map.hashcode: " + map2.hashCode());
        System.out.println("Testing map.toString() = " + map);
        System.out.println("Testing map2.toString() = " + map2);

    }

    
}
