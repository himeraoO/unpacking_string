public class UnpackingString {
    public String unpack(String s){
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder str = new StringBuilder();
        boolean strs = false;
        char[] chars = s.toCharArray();
        int count = 0;

        for (char aChar : chars) {
            if (strs) {
                if ((aChar == ']') && (count == 1)) {
                    int cnt = Integer.parseInt(String.valueOf(number));
                    count--;
                    number.setLength(0);
                    strs = false;
                    String tempString = str.toString();
                    str.setLength(0);
                    for (int j = 0; j < cnt; j++) {
                        stringBuilder.append(unpack(tempString));
                    }
                }
                if (aChar == '[') {
                    count++;
                    str.append(aChar);
                }
                if (aChar == ']' && count > 1) {
                    count--;
                    str.append(aChar);
                }
                if (Character.isLetter(aChar)) {
                    str.append(aChar);
                }
                if (Character.isDigit(aChar)) {
                    str.append(aChar);
                }
            }

            if (!strs) {
                if (Character.isLetter(aChar)) {
                    stringBuilder.append(aChar);
                }
                if (Character.isDigit(aChar)) {
                    number.append(aChar);
                }
                if (aChar == '[') {
                    strs = true;
                    count++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public void printUnpackingString(String arg){
        if(validator(arg)){
        System.out.print(unpack(arg));
        System.out.println();
        }else {
            System.out.println("Ошибка во входящей строке");
        }
    }

    public static boolean validator (String s){
        char [] chars = s.toCharArray();
        boolean b = true;
        boolean n = false;
        int count = 0;
        String validStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789[]";
        if ((chars[0] == '[') || (chars[0] == ']')){
            b = false;
            return b;
        }
        for (int i = 0; i < chars.length; i++){
            if(validStr.indexOf(chars[i]) == -1){
                b = false;
                return b;
            }
            if(chars.length < 4){
                if(Character.isDigit(chars[i]) || chars[i] == '['|| chars[i] ==  ']' ){
                    b = false;
                    return b;
                }
            }
            if(chars.length > 3){
                if (i < chars.length-1) {
                    if (Character.isDigit(chars[i])) {
                        n = true;
                    }
                    if(Character.isLetter(chars[i]) && n){
                        b = false;
                        return b;
                    }
                    if(chars[i] == '['){
                        n = false;
                    }
                }
                if(Character.isDigit(chars[chars.length-1]) || chars[chars.length-1] == '[' ){
                    b = false;
                    return b;
                }
                if(Character.isDigit(chars[chars.length-2]) || chars[chars.length-2] == '[' ){
                    b = false;
                    return b;
                }
                if(Character.isDigit(chars[chars.length-3]) ){
                    b = false;
                    return b;
                }
                if(chars[i] == '[' && chars[i+1] == ']'){
                    b = false;
                    return b;
                }
                if (chars[i] == '['){
                    count++;
                }
                if (chars[i] == ']'){
                    count--;
                }
            }
        }
        if (count != 0){
            b = false;
            return b;
        }
        return b;
    }

    public static void main(String[] args) {
        UnpackingString uS = new UnpackingString();
        uS.printUnpackingString("2[3[x]y]");
// xxxyxxxy
        uS.printUnpackingString("3[xyz]2[x]");
// xyzxyzxyzxx
        uS.printUnpackingString("3[xyz]4[xy]z");
// xyzxyzxyzxyxyxyxyz
        uS.printUnpackingString("2[2[2[x]y]z]");
// xxyxxyzxxyxxyz
        uS.printUnpackingString("2[3[x]y]3[xyz]2[x]3[xyz]4[xy]z");
// xxxyxxxyxyzxyzxyzxxxyzxyzxyzxyxyxyxyz
        uS.printUnpackingString("e2[y2[x]t]a2[z]t");
// eyxxtyxxtazzt
        uS.printUnpackingString("2[y2[x]t]");
// yxxtyxxt
        uS.printUnpackingString("e2[2[y2[x]]z]q");
// eyxxyxxzyxxyxxzq

        uS.printUnpackingString("e2[2[y2[2[y2[2[y2[x]]zx]]zx]]z]q");
        uS.printUnpackingString("2[3[2[x]]y]");
        String s1 = "eyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzq";
        String s2 = "eyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzq";
        String s3 = "eyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxyyxxyxxzxyxxyxxzxyyxxyxxzxyxxyxxzxzxzq";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
