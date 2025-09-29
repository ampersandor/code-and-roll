class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> sol;
        if (nums.size() < 3) {
            return sol;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.size() - 1;
            
            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == 0) {
                    sol.push_back({nums[i], nums[j], nums[k]});
                }
                
                if (val > 0) {
                    do {
                      --k;  
                    } while (j < k && nums[k] == nums[k + 1]);
                } else {
                    do {
                      ++j;  
                    } while (j < k && nums[j] == nums[j - 1]);
                }
                
            }
        }
        
        return sol;
    }
};