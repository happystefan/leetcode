package facebook;

public class Q273_Integer_to_English_Words {

    String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    int hundred = 100;
    int thousand = 1000;
    int million = 1000000;
    int billion = 1000000000;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return toWords(num);
    }

    private String toWords(int num) {
        String result = "";
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num-10];
        else if (num < hundred) result = belowHundred[num/10]+" "+belowTen[num%10];
        else if (num < thousand) result = toWords(num/hundred)+" "+"Hundred"+" "+ toWords(num%hundred);
        else if (num < million) result = toWords(num/thousand)+" "+"Thousand"+" "+toWords(num%thousand);
        else if (num < billion) result = toWords(num/million)+" "+"Million"+" "+toWords(num%million);
        else result = toWords(num/billion)+" "+"Billion"+" "+toWords(num%billion);
        return result.trim();
    }

}
