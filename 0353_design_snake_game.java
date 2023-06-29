class SnakeGame {
    Deque<String> snake;
    Set<String> snakeElements;
    int headRowIdx;
    int headColIdx;
    int width;
    int height;
    int score;
    int[][] food;
    int foodIdx;

    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        snakeElements = new HashSet<>();
        headRowIdx = 0;
        headColIdx = 0;
        this.width = width;
        this.height = height;
        
        String headLoc = headRowIdx + "," + headColIdx;
        snake.add(headLoc);
        snakeElements.add(headLoc);
        score = 0;
        this.food = food;
        foodIdx = 0;
    }

    public int moveUtil(int newHeadRowIdx, int newHeadColIdx) {
        if(newHeadRowIdx < 0 || newHeadRowIdx >= height || newHeadColIdx < 0 || newHeadColIdx >= width) {
            return -1;
        }
        else if(snakeElements.contains(newHeadRowIdx + "," + newHeadColIdx) && !snake.getFirst().equals(newHeadRowIdx + "," + newHeadColIdx)) {
            return -1;
        }
        // snake eats food
        else if(foodIdx < food.length && newHeadRowIdx == food[foodIdx][0] && newHeadColIdx == food[foodIdx][1]) {
            String newHead = newHeadRowIdx + "," + newHeadColIdx;
            snake.add(newHead);
            snakeElements.add(newHead);

            headRowIdx = newHeadRowIdx;
            headColIdx = newHeadColIdx;
            
            ++foodIdx;
            ++score;
            return score;
        }
        // snake goes to the empty spot
        else {
            String tail = snake.poll();
            snakeElements.remove(tail);
            
            String newHead = newHeadRowIdx + "," + newHeadColIdx;
            snake.add(newHead);
            snakeElements.add(newHead);

            headRowIdx = newHeadRowIdx;
            headColIdx = newHeadColIdx;
            
            return score;
        }
    }
        
    public int move(String direction) {
        int newHeadRowIdx = 0;
        int newHeadColIdx = 0;
        
        if(direction.equals("L")) {
            newHeadRowIdx = headRowIdx;
            newHeadColIdx = headColIdx - 1;
        }
        else if(direction.equals("U")) {
            newHeadRowIdx = headRowIdx - 1;
            newHeadColIdx = headColIdx;
        }
        else if(direction.equals("R")) {
            newHeadRowIdx = headRowIdx;
            newHeadColIdx = headColIdx + 1;
        }
        else if(direction.equals("D")) {
            newHeadRowIdx = headRowIdx + 1;
            newHeadColIdx = headColIdx;
        }
        
        return moveUtil(newHeadRowIdx, newHeadColIdx);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

/*
time O(1) space O(n) where n is the number of elements in the 2d array

a format of string is "rowIdx,colIdx" i.e., "0,2"

int size = ?;

queue<string> snake (FIFO) head (0,1) (0,2) (1,2) tail 

hashset<string> snakeBodies

if snake goes out of bound
   || snake eats its body snakeBodies.contains(nextRowIdx + "," + nextColIdx)
   then, return -1
else if snake goes to the empty spot,
   then, snake.pop() and snake.push(nextRowIdx + "," + nextColIdx)
         remove snake.pop() from snakeBodies
         return snakeBodies.size() - 1;
else 
   then, snake.push(nextRowIdx + "," + nextColIdx) and snakeBodies.add(nextRowIdx + "," + nextColIdx)
         return snakeBodies.size() - 1;
*/
