package com.krisha;
import java.util.HashMap;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<Integer,String>hm=new HashMap<>();
        //add
        hm.put(1, "Shravan");
        hm.put(2,"Manas");
        hm.put(3,"Rohit");
        //retrieval
        System.out.println(hm.get(1));
        System.out.println(hm.get(3));
        System.out.println(hm.get(5)); //returns null
        //containsKey
        System.out.println(hm.containsKey(2));
        System.out.println(hm.containsKey(10));//prints false
        //removal
        hm.remove(2);
        System.out.println(hm.containsKey(2));//prints false

        //traversing arrays on values not index (for-each loop)
//        int[] arr = new int[50];
//        for(int val:arr){
//            System.out.println(val);
//        }

        //traversing thru a hashMap
        for (int key:hm.keySet()){
            System.out.println(key);
        }
        //to get values thru keys in loop
        for (int key:hm.keySet()){
            System.out.println(hm.get(key));
        }

        //q.Given N array elements and Q queries. For every query find frequency of elements.
        int[] arr1={2,4,6,7,3,2,5,6,9,7,8,9,1,4,6};
        firstNonRepeatingElement(arr1);

        //to get no of keys
        hm.size();
        }

        void printFrequency(int[]arr,int[] queries){
        HashMap<Integer,Integer>hash=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(hash.containsKey(arr[i])==true){
                int temp=hash.get(arr[i]);
                hash.put(arr[i],temp+1);
            }
            else {
                hash.put(arr[i],1);
            }
        }
        //for queries
        for(int i=0;i<queries.length;i++){
            int val=queries[i];
            if(hash.containsKey(val)==true){
                System.out.println(hash.get(val));
            }
            else{
                System.out.println(0);
            }
        }
        //Time complexity of (m+n) here better than m*n not using nested loop(brute force method)

    }

    static void firstNonRepeatingElement(int[] arr){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i<n; i++){
            if(hm.containsKey(arr[i])){
                int temp = hm.get(arr[i]);
                hm.put(arr[i],temp+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }
        for (int i = 0; i<n; i++){
            if (hm.get(arr[i])==1){
                System.out.println("first non repeating element is : "+arr[i]);
                break;
            }
        }
        //o(m+n) t.c or o(2n) if m==n, o(n)=o(2n) broadly
    }
}
