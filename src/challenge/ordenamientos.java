/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

/**
 *
 * @author castr
 */
public class ordenamientos {
    
    
    //**----------------------------
    public void bubbleSort(String arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (Integer.parseInt(arr[j])>Integer.parseInt(arr[j+1]))
                {
                    // swap arr[j+1] and arr[j]
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    //**----------------------------
    //**----------------------------
    public void HeapSort(String arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    
    void heapify(String arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && Integer.parseInt(arr[l]) > Integer.parseInt(arr[largest]))
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && Integer.parseInt(arr[r]) > Integer.parseInt(arr[largest]))
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    //**----------------------------
    //**----------------------------
    public void quickSort(String[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public void swap(String[] arr, int i, int j)
    {
        int temp = Integer.parseInt(arr[i]);
        arr[i] = arr[j];
        arr[j] = Integer.toString(temp);
    }
 
/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    public int partition(String[] arr, int low, int high)
    {

        // pivot
        String pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (Integer.parseInt(arr[j]) < Integer.parseInt(pivot))
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
