package vmware;

public class Q468_Validate_IP_Address {

    public String validIPAddress(String IP) {
        if (IP.contains(".") && isIPv4(IP)) return "IPv4";
        if (IP.contains(":") && isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")) return false;
        String[] parts = IP.split("\\.");
        if (parts.length != 4) return false;
        try {
            for (String part : parts) {
                if (part.startsWith("0") && !part.equals("0")) return false;
                if (part.charAt(0) == '-') return false;
                if (Integer.valueOf(part) > 255) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        IP = IP.toLowerCase();
        if (IP.startsWith(":") || IP.endsWith(":") || IP.contains("::")) return false;
        String[] parts = IP.split(":");
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isLetter(c) && !Character.isDigit(c)) return false;
                if (Character.isLetter(c) && (c < 'a' || c > 'f')) return false;
            }
        }
        return true;
    }

}
