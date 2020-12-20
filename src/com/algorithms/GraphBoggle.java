package com.algorithms;

public class GraphBoggle {
    static final String dictionary[] = {"THIS", "WORD", "MEANS", "WAR"};
    static final int n = dictionary.length;
    static final int M = 3, N = 3; // matrix with letters

    static boolean isWord(String str) {
        for (int i = 0; i < n; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }

    static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
        visited[i][j] = true;
        str = str + boggle[i][j];
        if (isWord(str))
            System.out.println(str);
        for (int row = i - 1; row <= i + 1 && row < M; row++) {
            for (int col = j - 1; col <= j + 1 && col < N; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col])
                    findWordsUtil(boggle, visited, row, col, str);
            }
        }
        str = "" + str.charAt(str.length() - 1);
        visited[i][j] = false;
    }

    static void findWords(char[][] boggle) {
        boolean[][] visited = new boolean[M][N];
        String str = "";
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(boggle, visited, i, j, str);
    }

    public static void main(String[] args) {
        char[][] boggle = {
                {'T', 'S', 'H'},
                {'R', 'D', 'W'},
                {'I', 'O', 'R'}
        };
        findWords(boggle);
    }
}
