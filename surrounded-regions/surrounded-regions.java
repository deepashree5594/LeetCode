    for (int r = 0; r < this.ROWS; ++r) {
      for (int c = 0; c < this.COLS; ++c) {
        if (board[r][c] == 'O')
          board[r][c] = 'X';
        if (board[r][c] == 'E')
          board[r][c] = 'O';
      }
    }
  }
​
  protected void BFS(char[][] board, int r, int c) {
    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
    queue.offer(new Pair<>(r, c));
​
    while (!queue.isEmpty()) {
      Pair<Integer, Integer> pair = queue.pollFirst();
      int row = pair.first, col = pair.second;
      if (board[row][col] != 'O')
        continue;
​
      board[row][col] = 'E';
      if (col < this.COLS - 1)
        queue.offer(new Pair<>(row, col + 1));
      if (row < this.ROWS - 1)
        queue.offer(new Pair<>(row + 1, col));
      if (col > 0)
        queue.offer(new Pair<>(row, col - 1));
      if (row > 0)
        queue.offer(new Pair<>(row - 1, col));
    }
  }
}
​
​
class Pair<U, V> {
  public U first;
  public V second;
​
  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}
​
