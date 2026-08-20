

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Run DFS for Left & Right borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);             // Left border (Pacific)
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]); // Right border (Atlantic)
        }

        // 2. Run DFS for Top & Bottom borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);             // Top border (Pacific)
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]); // Bottom border (Atlantic)
        }

        // 3. Cells visited by BOTH ocean traversals reach both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] oceanVisited, int prevHeight) {
        // Base cases: Out of bounds, already visited, or water cannot flow UPWARD (current < prev)
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length 
            || oceanVisited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // Mark cell as reachable from this ocean
        oceanVisited[r][c] = true;

        // Explore 4 directions
        dfs(heights, r - 1, c, oceanVisited, heights[r][c]); // Up
        dfs(heights, r + 1, c, oceanVisited, heights[r][c]); // Down
        dfs(heights, r, c - 1, oceanVisited, heights[r][c]); // Left
        dfs(heights, r, c + 1, oceanVisited, heights[r][c]); // Right
    }
}