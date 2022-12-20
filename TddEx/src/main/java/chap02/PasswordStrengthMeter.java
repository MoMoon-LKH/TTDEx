package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){

        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = getMetCriteriaCounts(s);
        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s){
        int metCounts = 0;

        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUpperCriteria(s)) metCounts++;

        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUpperCriteria(String s){
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c))
                return true;
        }
        return false;
    }
}
