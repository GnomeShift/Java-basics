public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        this.data = new int[rows][cols];
    }

    public int getRows() {
        return data.length;
    }

    public int getCols() {
        return data[0].length;
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    public Matrix add(Matrix other) {
        if (this.getRows() != other.getRows() || this.getCols() != other.getCols()) {
            throw new IllegalArgumentException("Одинаковые матрицы задай!!");
        }

        Matrix result = new Matrix(this.getRows(), this.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                result.set(i, j, this.get(i, j) + other.get(i, j));
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.getCols() != other.getRows()) {
            throw new IllegalArgumentException("Кол-во столбцов 1ой матрицы должно быть = кол-ву строк 2ой матрицы!!");
        }

        Matrix result = new Matrix(this.getRows(), other.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < other.getCols(); j++) {
                for (int k = 0; k < this.getCols(); k++) {
                    result.set(i, j, result.get(i, j) + this.get(i, k) * other.get(k, j));
                }
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main13 {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 4);
        matrix1.set(1, 1, 5);
        matrix1.set(1, 2, 6);
        matrix1.set(2, 0, 7);
        matrix1.set(2, 1, 8);
        matrix1.set(2, 2, 9);

        Matrix matrix2 = new Matrix(3, 3);
        matrix2.set(0, 0, 1);
        matrix2.set(0, 1, 2);
        matrix2.set(0, 2, 3);
        matrix2.set(1, 0, 4);
        matrix2.set(1, 1, 5);
        matrix2.set(1, 2, 6);
        matrix2.set(2, 0, 7);
        matrix2.set(2, 1, 8);
        matrix2.set(2, 2, 9);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("Матрица 2:");
        matrix2.print();

        Matrix sum = matrix1.add(matrix2);
        System.out.println("Сумма:");
        sum.print();

        Matrix mult = matrix1.multiply(matrix2);
        System.out.println("Произведение:");
        mult.print();
    }
}
