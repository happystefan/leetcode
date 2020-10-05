package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q023_Nearest_Points {

    interface PointsOnAPlane {
        void addPoint(Point point);

        Collection<Point> findNearest(Point center, int k);
    }

    class solution_pq implements PointsOnAPlane {

        private final List<Point> points = new LinkedList<>();

        @Override
        public void addPoint(Point point) {
            points.add(point);
        }

        @Override
        public Collection<Point> findNearest(Point center, int k) {
            PriorityQueue<Point> Q = new PriorityQueue<>((a, b) -> dis(a, center) - dis(b, center));
            for (Point p : points) {
                Q.add(p);
                if (Q.size() > k) Q.poll();
            }
            List<Point> rslt = new LinkedList<>(Q);
            return rslt;
        }

        private int dis(Point a, Point b) {
            return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        }

    }

    class solution_quickselect implements PointsOnAPlane {

        private final List<Point> points = new ArrayList<>();

        @Override
        public void addPoint(Point point) {
            points.add(point);
        }

        @Override
        public Collection<Point> findNearest(Point center, int k) {
            int l = 0, r = points.size() - 1;
            while (l < r) {
                int pi = partition(points, l, r, center);
                if (pi < k) l = pi + 1;
                else if (pi > k) r = pi - 1;
                else break;
            }
            return new LinkedList<>(points.subList(0, k));
        }


        private int partition(List<Point> points, int l, int r, Point center) {
            Point pivot = points.get(r);
            int i = l, j = r - 1;
            while (i <= j) {
                if (isGreater(points.get(i), pivot, center)) {
                    swap(points, i, j);
                    j--;
                } else {
                    i++;
                }
            }
            swap(points, i, r);
            return i;
        }

        private void swap(List<Point> points, int i, int j) {
            Point tmp = points.get(i);
            points.set(i, points.get(j));
            points.set(j, tmp);
        }

        private boolean isGreater(Point a, Point b, Point center) {
            return dis(a, center) > dis(b, center);
        }

        private int dis(Point a, Point b) {
            return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        }

    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
