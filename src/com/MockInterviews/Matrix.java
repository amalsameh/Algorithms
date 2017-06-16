package com.MockInterviews;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by amal- on 5/27/2017.
 */
public class Matrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        if (A == null || A.size() == 0)
            return 0;

        int m, n;
        int i, j;

        m = A.size();
        n = A.get(0).size();

        int count[][];
        count = new int[m][n];

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0) {
                    count[i][j] = A.get(i).get(j);
                } else {
                    count[i][j] = A.get(i).get(j) == 0 ? 0 : count[i - 1][j] + 1;
                }
            }
        }

        int res = 0;

        for (i = 0; i < m; i++) {
            res = Math.max(res, maxRect(count[i]));
        }

        return res;

    }

    public int maxRect(int [] histogram) {
        int n;
        int res = 0;
        int prevMin[];
        int nextMin[];
        int num;
        Stack<Integer> stack;

        n = histogram.length;
        prevMin = new int[n];
        nextMin = new int[n];

        stack = new Stack<Integer>();

        prevMin[0] = -1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            num = histogram[i];
            while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
                stack.pop();
            }
            prevMin[i] = -1;
            if (!stack.isEmpty()) {
                prevMin[i] = stack.peek();
            }
            stack.push(i);
        }


        nextMin[n - 1] = n;
        stack.clear();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            num = histogram[i];
            while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
                stack.pop();
            }
            nextMin[i] = n;
            if (!stack.isEmpty())
                nextMin[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int left = prevMin[i] + 1;
            int right = nextMin[i] - 1;
            res = Math.max(res, histogram[i] * (right - left + 1));
        }

        return res;
    }
