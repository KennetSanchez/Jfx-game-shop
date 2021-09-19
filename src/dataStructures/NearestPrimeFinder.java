package dataStructures;

import java.util.ArrayList;

public class NearestPrimeFinder {
    private static int MAX = 1000000;
    private static ArrayList<Integer> primes = new ArrayList<>();

    public NearestPrimeFinder(){
        Sieve();
    }

    public int nearestPrime(int n){
        return(binarySearch(0,primes.size()-1,n));
    }

    private void Sieve(){
        int n = MAX;
        int nNew = (int)Math.sqrt(n);
        int[] marked = new int[n/2 + 500];
        for(int i=1;i<=(nNew-1)/2;i++){
            for(int j=(i*(i+1)) << 1;j <= n/2;j=j+2*i+1){
                marked[j]=1;
            }
        }

        primes.add(2);

        for(int i=1;i<=n/2;i++){
            if(marked[i]==0){
                primes.add(2*i+1);
            }
        }
    }

    private int binarySearch(int left,int right,int n){
        if (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0 || mid == primes.size() - 1){
                return primes.get(mid);
            }
            if (primes.get(mid) == n){
                return primes.get(mid - 1);
            }
            if (primes.get(mid) < n && primes.get(mid + 1) > n){
                return primes.get(mid);
            }
            if (n < primes.get(mid)){
                return binarySearch(left, mid - 1, n);
            }
            else{
                return binarySearch(mid + 1, right, n);
            }
        }
        return 0;
    }


}
