package com.science;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by amal- on 5/27/2017.
 */
public class Chess {
        private static final int dx[] = new int[] {-2, -2, 1, -1, 2, 2, 1, -1};
        private static final int dy[] = new int[] {1, -1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) {
    int result=knight(8,8,2,1,7,5);
    }
        public static int knight(int N, int M, int x1, int y1, int x2, int y2)
        {
            java.util.Queue _queue = new java.util.LinkedList<ChessNode>();
            ChessNode startNode = new ChessNode(x1, y1);
            HashSet marked = new HashSet<>();
            _queue.add(startNode);
            _queue.add(null);
            int level = 0;
            marked.add(startNode);
            while (!_queue.isEmpty()) {
                ChessNode n = (ChessNode)_queue.remove();
                if (n == null) {
                    level++;
                    if (!_queue.isEmpty()) {
                        _queue.add(null); }
                    continue; }
                if (n.x == x2 && n.y == y2) return level;
                ArrayList<ChessNode> neighbours=getNeighbours(n,N,M);
                for(ChessNode nn:neighbours)
                {
                    if (!marked.contains(nn)) {
                        marked.add(nn);
                        _queue.add(nn);
                    }
                }
            }
            return -1; }

        private static ArrayList<ChessNode> getNeighbours(ChessNode n,int N,int M)
        {
            ArrayList<ChessNode> neighbours=new ArrayList<ChessNode>();
            for (int k = 0; k < 8; k++) {
                int x = n.x + dx[k]; int y = n.y + dy[k];
                if (isValid(x, y, N, M)) {
                    ChessNode nn = new ChessNode(x, y);
                    neighbours.add(nn);
                }
            }
            return neighbours;
        }
        public static boolean isValid(int x, int y, int N, int M) {
            if (x < 1 || x > N || y < 1 || y > M)
                return false;
            return true; }
        static class ChessNode {
            int x, y;
            public ChessNode(int x, int y) { this.x = x; this.y = y; }
            @Override public boolean equals(Object obj) {
                if (obj == null) return false;
                if (obj.getClass() != getClass()) return false;
                if (this == obj) return true;
                ChessNode node = (ChessNode) obj;
                if (this.x == node.x && this.y == node.y)
                    return true;
                return false; }
                @Override public int hashCode() {
                return (int) ((31 * x + y) & 0x7fffffff);
            }
        }
}

