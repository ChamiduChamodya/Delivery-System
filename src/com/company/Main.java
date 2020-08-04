package com.company;


import java.util.Arrays;

public class Main {

    static final int V = 9;
    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
    void printSolution(int dist[], int n,int arr[][])
    {
        String local[] = {"Gal", "Mat", "Ham", "Cmb", "Wal", "Mul", "Kar", "Mir", "Hir"};
        int min=1000;
        int temp=arr[0][0];
        String loca="";
        System.out.println("Vertex      Distance from Source");
        for (int j = 0; j < V; j++) {
            temp=arr[j][0];
            if (local[temp]==local[j]) {
                System.out.println(local[j] + "       tt      " + dist[j]);
//                if (dist[j] < min) {
                    min = dist[j];
                    loca = local[temp];

                }
//            }
        }
        System.out.println("************************************************");
        System.out.println("The First Order is from :" + loca+" and the distance from source is " + min +"Km");
    }
    void dijkstra(int graph[][], int src,int arr[][])
    {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist, V,arr);
    }
    public static void sort2D(int [] [] array, int column_index){
        for(int i=1; i<array.length; i++){
            int index = i;
            for(int j=i-1; j>=0; j--, index--)
                if(array[j][column_index]>array[index][column_index])
                    swap2rows(array, index,j);
                else
                    break;
        }
    }
    public static void swap2rows(int [][] array, int index, int j){
        int temp;
        for(int i=0; i<array[j].length; i++){
            temp = array[j][i];
            array[j][i] = array[index][i];
            array[index][i] = temp;
        }
    }
    public static void main(String[] args) {
        int [][] twoD_Arr= new int [][] {{0,400},{1,200},{2,1400},{3,100},{4,1545},{5,1300},{6,1700},{7,500},{8,1900}};
        sort2D(twoD_Arr, 1);

//        System.out.println("arrays after sorting:");
//        for(int i=0; i<twoD_Arr.length; i++){
//            System.out.println(Arrays.toString(twoD_Arr[i]));
//        }

        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Main t = new Main();
        t.dijkstra(graph, 5,twoD_Arr);
    }
}
