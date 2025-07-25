package ConcurrencyModule.Parallelization.MergeSort;

public class MergeSort {
    private int[] nums;
    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
    }

    private Thread createThread(int low, int high, int numOfThreads) {
        return new Thread(() -> {
            parallelMergeSort(low, high, numOfThreads/2);
        });
    }

    public void parallelMergeSort(int low, int high, int numOfThreads) {
        if(numOfThreads <= 1) {
            mergeSort(low, high);
            return;
        }
        int middleIndex = (low + high) / 2;
        Thread leftSorter = createThread(low, middleIndex, numOfThreads);
        Thread rightSortedr = createThread(middleIndex + 1, high, numOfThreads);

        leftSorter.start();
        rightSortedr.start();

        try {
            leftSorter.join();
            rightSortedr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(low, middleIndex, high);
    }

    public void mergeSort(int low, int high) {
        // base-case
        if(low >= high)
            return;

        int middleIndex = (low + high) / 2;

        // keep splitting the array into a smaller and smaller array until array
        // contains just one item
        mergeSort(low, middleIndex);
        mergeSort(middleIndex + 1, high);

        // now we connect those elements
        merge(low, middleIndex, high);

    }

    private void merge(int low, int middle, int high) {
        for(int i = low; i <= high; i++)
            tempArray[i] = nums[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        while(i <= middle && j <= high) {
            if(tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            } else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }
        // here we are copying the leftovers after merging
        while(i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }

        while(j <= high) {
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }
    }

    private void showArray() {
        for(int i : nums)
            System.out.print(i + " ");
    }
}
