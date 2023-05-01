package p11404;

import java.util.ArrayList;
import java.util.Scanner;

public class p11404_fool {

    static class Course{

        int fromCity;
        int toCity;
        int cost;

        public Course(int fromCity, int toCity, int cost) {
            this.fromCity = fromCity;
            this.toCity = toCity;
            this.cost = cost;
        }

        public Course getCourseByCities(int fromCity, int toCity)
        {
            if(this.fromCity == fromCity && this.toCity == toCity)
            {
                return this;
            }
            else
                return null;
        }

        public int getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       //도시의 개수

        int m = sc.nextInt();       //버스의 개수

        ArrayList<Course> graph = new ArrayList<>();

        for(int i=1; i<n+1; i++)
        {
            for(int j=0; j<n+1; j++)
            {
                if(i != j)
                {
                    graph.add(new Course(i, j, Integer.MAX_VALUE));
                }
                else
                {
                    graph.add(new Course(i, j, 0));
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            int fromCity = sc.nextInt();
            int toCity = sc.nextInt();
            int cost = sc.nextInt();
            Course currentCourse = null;

            for(int j=0; j<graph.size(); j++)
            {
                currentCourse = graph.get(j).getCourseByCities(fromCity, toCity);

                if(graph.get(j).getCourseByCities(fromCity, toCity) != null)
                {
                    break;
                }
            }

            if(currentCourse.cost > cost)
            {
                currentCourse.cost = cost;
            }

        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    Course currentCourse = null;
                    Course subCourse1 = null;
                    Course subCourse2 = null;

                    for(int x=0; x<graph.size(); x++)
                    {
                        currentCourse = graph.get(x).getCourseByCities(i, j);
                        subCourse1 = graph.get(x).getCourseByCities(i, k);
                        subCourse2 = graph.get(x).getCourseByCities(k, j);

                        if(currentCourse != null && subCourse1 != null && subCourse2 != null)
                        {
                            break;
                        }
                    }

                    //삽질 해보려다 포기

                    int currentCost = currentCourse.cost;
                    int subCost1 = subCourse1.cost;
                    int subCost2 = subCourse2.cost;

                    currentCost = Math.min(currentCost, subCost1 + subCost2);

                    currentCourse.cost = currentCost;
                }
            }
        }

//        for(int i=1; i< graph.size(); i++)
//        {
//            System.out.println(graph.get(i).cost);
//        }

    }

}
