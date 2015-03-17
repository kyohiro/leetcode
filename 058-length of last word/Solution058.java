public class Solution058 {
	//Attempt1: 208ms - leverage Java API
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words.length != 0 ? words[words.length - 1].length() : 0;
    }

    //Attempt2: 225ms - loop through the string
    public int lengthOfLastWord2(String s) {
    	int firstIdx = -1, lastIdx = -1;
    	boolean spacePassed = false;
    	for (int i = 0; i < s.length(); ++i) {
    		if (s.charAt(i) != ' ') {
    			if (firstIdx == -1 || spacePassed) {
    				firstIdx = i;
    				spacePassed = false;
    			}
    			lastIdx = i;
    		}
    		else {
    			spacePassed = true;
    		}
    	}

    	return firstIdx == -1 ? 0 : lastIdx - firstIdx + 1;
    }
}