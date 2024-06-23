package com.krisha;
import java.util.HashMap;
import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {


        HashSet<Integer> hs = new HashSet<>();
        //add
        hs.add(10);
        hs.add(16);
        hs.add(23);
        //remove
        hs.remove(16);
        //contain
        System.out.println(hs.contains(16));
        System.out.println(hs.contains(23));
        //hashset size
        System.out.println(hs.size());

        //q1 call
        int[] arr1 ={2,4,6,8,4,3,3,8,2,6};
        System.out.println(distinctElements(arr1));//gives 5
        //q2.call
//        System.out.println(pairSum(arr1,10));
        //q2 method 2
        System.out.println(hashPairSum(arr1,11));

    }

    //q1.given an arr[N], find num of distinct elements.
    static int distinctElements(int[] arr){
        int n = arr.length;
        HashSet<Integer>hs=new HashSet<>();
        for(int i =0; i<n; i++){
            hs.add(arr[i]);
        }
        return hs.size();
        //T.c --> o(n)
    }

    // q2.pair sum == k ;
    static boolean pairSum(int[] arr,int k){
        HashSet<Integer>hs=new HashSet<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for (int j =1;j<n;j++){
                hs.add(arr[i]+arr[j]);
            }
        }
        boolean bool = false;
        if(hs.contains(k)==true){
            bool = true;
        }
        return bool;
        //t.c --> o(n^2)
    }

    static boolean hashPairSum(int[] arr, int k){
        int n = arr.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i=0;i<n;i++) {
            if (hash.containsKey(arr[i]) == true) {
                int temp = hash.get(arr[i]);
                hash.put(arr[i], temp + 1);
            } else {
                hash.put(arr[i], 1);
            }
        }
        boolean bool = false;
        for(int j = 0; j<n ; j++){
            int a = arr[j];
            int b = k-a;
            if(a!=b && hash.containsKey(b)==true){
                bool = true;
            }
            else if(a==b && hash.get(a)>1 ){
                bool=true;
            }
        }
        return bool;
        }
    }

