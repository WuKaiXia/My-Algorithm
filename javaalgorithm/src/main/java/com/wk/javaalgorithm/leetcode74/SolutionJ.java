package com.wk.javaalgorithm.leetcode74;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class SolutionJ {

    public boolean searchMatrix3(int[][] matrix, int target) {
        int n = matrix.length;
        int row = 0, column = matrix[0].length - 1;
        while (row < n && column > -1) {
            if (matrix[row][0] > target) {
                return false;
            }
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] < target) {
                row++;
            }
            if (row < n && matrix[row][column] > target) {
                column--;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix0(int[][] matrix, int target) {
        int rowIndex = binarySearchColumnIndex(matrix, target);
        if (rowIndex == -2) {
            return true;
        }
        if (rowIndex == -1) {
            return false;
        }
        return binarySearchRowIndex(matrix[rowIndex], target);
    }

    private int binarySearchColumnIndex(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int num = matrix[mid][0];
            if (num < target) {
                low = mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                return -2;
            }
        }
        return low;
    }

    private boolean binarySearchRowIndex(int[] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = matrix[mid];
            if (num < target) {
                low = mid + 1;
            } else if (num > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (num == target) {
                    return true;
                } else if (num > target) {
                    return false;
                }
            }
        }
        return false;
    }
}
