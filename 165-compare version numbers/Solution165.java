public class Solution165 {
	//Attempt1: 232ms
	public int compareVersion(String version1, String version2) {
		String[] array1 = version1.split("\\.");
		String[] array2 = version2.split("\\.");
		
		int maxLevel = array1.length > array2.length ? array1.length : array2.length;
		for (int i = 0; i < maxLevel; ++i) {
			int ret = compareSubVersion(array1, array2, i);
			if (ret != 0)
				return ret;
		}
		return 0;
	}
	
	private int compareSubVersion(String[] array1, String[] array2, int level) {
		int v1 = array1.length > level ? Integer.valueOf(array1[level]) : 0;
		int v2 = array2.length > level ? Integer.valueOf(array2[level]) : 0;
		if (v1 > v2)
			return 1;
		else if (v1 < v2)
			return -1;
		else 
			return 0;
	}
}