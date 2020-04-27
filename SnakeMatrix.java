import javafx.util.Pair;

public class SnakeMatrix {

    enum Direction {

        RIGHT,
        DOWN,
        LEFT,
        UP;

        // циклический сдвиг для поворота змейки по часовой стрелке
        // RIGHT -> DOWN -> LEFT -> UP -> RIGHT -> ...
        Direction next() {
            return values()[(ordinal() + 1) % values().length];
        }
    }

    static int[][] makeSnakeMatrix(int n) {
        int[][] snakeMatrix = new int[n][n];

        // начинаем извне с фиктивного индекса (0,-1), т.к. след. сдвиг будет вправо на индекс (0,0)
        Pair<Integer, Integer> index = new Pair<>(0, -1);

        Direction direction = Direction.RIGHT;

        // будем итерироваться по сегментам
        int[] segmentSizes = segments(n);

        // собственно, значение, которое будем рисовать в таблице
        int snakeValue = 1;

        for(int i = 0; i < segmentSizes.length; i++) {
            for(int j = 0; j < segmentSizes[i]; j++) {
                // на основании предыдущего индекса и направления сдвига определяем следующий индекс
                index = nextIndex(index, direction);

                // записывыем в табличку и выполняем инкремент
                snakeMatrix[index.getKey()][index.getValue()] = snakeValue++;
            }
            // по окончанию сегмента меняем направления сдвига по циклу

            direction = direction.next();

        }

        return snakeMatrix;
    }

    // массив размеров сегментов
    // пример: если n == 5, то размеры сегментов будут такими: 5, 4, 4, 3, 3, 2, 2, 1, 1
    // основано на следующем свойстве квадрата числа:
    // n^2 = n + 2*(n-1) + 2*(n-2) + ... + 2(n-(n-2)) + 2*(n-(n-1))
    // т.е.
    // например 3^2 = 3 + 2*(3-1) + 2*(3-2) = 3 + 2*2 + 2 = 3 + 4 + 2 = 9
    // в данном разложении последнее слагаемое всегда 2, и если его разложить на 1 + 1
    // то выходит, что кол-во слагаемых в разложении - это кол-во сегментов змейки
    // а само слагаемое - это длина сегмента змейки
    static int[] segments(int n) {
        int[] segments = new int[2*n-1];

        // первый самый большой сегмент по размеру равен n
        segments[0] = n;

        // остальные сегменты идут парами и размерами от n - 1 до 1
        int size = n - 1;

        for(int i = 1; i < segments.length; i++) {
            segments[i] = size;
            if(i % 2 == 0) {
                size--;
            }
        }
        return segments;
    }

    // вычисление двумерного индекса на основе направления поворота
    static Pair<Integer, Integer> nextIndex(Pair<Integer, Integer> source, Direction direction) {
        Pair<Integer, Integer> result;
        switch (direction) {
            case RIGHT:
                result = new Pair<>(source.getKey(), source.getValue() + 1);
                break;
            case DOWN:
                result = new Pair<>(source.getKey() + 1, source.getValue());
                break;
            case LEFT:
                result = new Pair<>(source.getKey(), source.getValue() - 1);
                break;
            case UP:
                result = new Pair<>(source.getKey() - 1, source.getValue());
                break;
            default:
                throw new RuntimeException();
        }
        return result;
    }


    static void printSnakeMatrix(int[][] snakeMatrix) {
        for(int i = 0; i < snakeMatrix.length; i++) {
            for(int j = 0; j < snakeMatrix.length; j++) {
                System.err.print(String.format("%-7d", snakeMatrix[i][j]));
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        printSnakeMatrix(makeSnakeMatrix(0));
    }

}
