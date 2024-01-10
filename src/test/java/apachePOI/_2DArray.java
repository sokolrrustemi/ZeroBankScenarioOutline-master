package apachePOI;

public class _2DArray {
    public static void main(String[] args) {
        String[][] _2DArray = {
                {"0_0", "0_1", "0_2", "0_3"},
                {"1_0", "1_1"},
                {"2_0", "2_1", "2_2"},
                {"3_0", "0_1"},
                {"4_0", "4_1", "4_2", "4_3"},

        };
        for (int i = 0; i < _2DArray.length; i++) {
            for (int j = 0; j < _2DArray[i].length; j++) {
                System.out.print(_2DArray[i][j] + " ");
            };

            System.out.println();
        }


    }

}
