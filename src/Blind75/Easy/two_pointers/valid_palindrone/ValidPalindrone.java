package Blind75.Easy.two_pointers.valid_palindrone;

public class ValidPalindrone {
    static boolean isPalindromeBruteForce(String s) {
            // Brute force
        if(s.length() == 1 || s.isEmpty())
            return true;

        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuilder reversed = new StringBuilder();
        for(int i = cleaned.length() - 1; i >= 0; i--) {
            reversed.append(cleaned.charAt(i));
        }
        return cleaned.equals(reversed.toString());
    }

    static boolean isPalindromeTwoPointers(String s){
        int k = 0;
        int f = s.length() - 1;

        while(k < f){
            if(!Character.isLetterOrDigit(s.charAt(k))){
                k++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(f))){
                f--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(k)) != Character.toLowerCase(s.charAt(f))){
                return false;
            }

            k++;
            f--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "tab a cat";
        String s2 = "A man, a plan, a canal: Panama";

        System.out.println(isPalindromeBruteForce(s1));
        System.out.println(isPalindromeTwoPointers(s2));
    }
}
