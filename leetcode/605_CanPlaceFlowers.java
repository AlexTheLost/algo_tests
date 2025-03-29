// 605. Can Place Flowers
// https://leetcode.com/problems/can-place-flowers/description/?envType=problem-list-v2&envId=aqw21527

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // []
        // [0,0,0]
        // [1,1,1]
        int counter = 0;
        int prev = 0;
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                prev = 1;
                continue;
            } else {
                if (i+1<flowerbed.length) {
                    if(flowerbed[i+1] == 1) {
                        continue;
                    } else {
                        if (prev == 0) {
                            counter++;
                            prev = 1;
                        } else {
                            prev = 0;
                        }
                    }
                } else {
                    if (prev == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter >= n;
    }
}