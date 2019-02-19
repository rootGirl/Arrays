public class Arrays {
    //Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
    public int trapRain(int[] arr){
        int count=0;
        int max =0;
        int maxIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                maxIndex=i;
            }
        }
        for(int i=0;i<maxIndex;i++) {
            if (arr[i] > 0) {
                int wall = arr[i];
                while (i < maxIndex) {
                    i++;
                    if (arr[i] < wall) {
                        count += Math.min(wall, max) - arr[i];
                    } else if (arr[i] > wall) {
                        wall = arr[i];
                    }
                }
            }
        }
        for(int i=arr.length-1;i>maxIndex;i--) {
            if (arr[i] > 0) {
                int wall = arr[i];
                while (i > maxIndex) {
                    i--;
                    if (arr[i] < wall) {
                        count += Math.min(wall, max) - arr[i];
                    } else if (arr[i] > wall) {
                        wall = arr[i];
                    }
                }
            }
        }

        return count;
    }

    public static int findMaxSubArray(int[] arr){
        int max =arr[0];
        for(int i=1;i<arr.length;i++){
            if(max*arr[i]<max){
                i++;
                if(arr[i]>max){
                    max=arr[i];
                }
            }else{
                max *=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Arrays array = new Arrays();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(array.trapRain(arr));


    }

}