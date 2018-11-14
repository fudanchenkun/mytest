class LongestPlaindromicSubStr {

    public String expand(int i, int l, boolean b, String s, char[] a) {
        int start = 0;
        int end = 0;
        if (b) {
            start = i;
            end = i + 1;
        } else {
            start = i - 1;
            end = i + 1;
        }

        while(start >= 0 && end < l) {
            if(a[start]==a[end]){
                start--;
                end++;
            } else {
                return s.substring(start + 1, end);
            }

        }
        return s.substring(start + 1, end);
    }

    public String longestPalindrome(String s) {
        char[] a = s.toCharArray();
        int l = s.length();
        if(l == 0 || l== 1)return s;
        if(l==2){
            if (a[0] == a[1]) return s;
            else return s.substring(0,1);
        };

        String maxString = "";
        for(int i=0; i < l - 1; i++){
            int o = 0;
            String substring = "";
            if (i>0 && a[i -1] == a[i + 1]) {
                substring = expand(i, l, false, s, a);
            } else if (a[i] == a[i+1]){
                substring = expand(i, l, true, s, a);
            }

            if (!substring.isEmpty() && substring.length() > maxString.length())
                maxString = substring;
        }
        return maxString.isEmpty()?s.substring(0, 1):maxString;
    }
}