package facebook;

public class Q273_Integer_to_English_Words {

    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final int hundred = 100;
    private final int thousand = 1000;
    private final int million = 1000000;
    private final int billion = 1000000000;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return toWords(num);
    }

    private String toWords(int num) {
        String result = "";
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num-10];
        else if (num < hundred) result = belowHundred[num/10] + " " + toWords(num % 10);
        else if (num < thousand) result = toWords(num/100) + " Hundred " +  toWords(num % 100);
        else if (num < million) result = toWords(num/thousand) + " Thousand " +  toWords(num % thousand);
        else if (num < billion) result = toWords(num/million) + " Million " +  toWords(num % million);
        else result = toWords(num/billion) + " Billion " + toWords(num % billion);
        return result.trim();
    }

}
