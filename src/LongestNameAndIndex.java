public class LongestNameAndIndex {
    public static void main(String[] args) {
        String[] names = new String[]{"mohammed", "samy", "ahmed", "Abd Al-rahman" , "mahmoud", "mostafa"};
        int longestNameIndex = longestName(names);
        System.out.println("longest name is : " + names[longestNameIndex]
                + "\nin index : " + longestNameIndex);
    }

    private static int longestName(String[] names) {
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > names[index].length())
                index = i;
        }
        return index;
    }
}
