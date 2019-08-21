package Y2019.Q0901_Q1200;

import java.util.HashSet;
import java.util.Set;

public class Q0929_Unique_Email_Addresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] pair = email.split("@");
            String local = pair[0];
            String domain = pair[1];
            if (local.contains("+")) local = local.substring(0, local.indexOf("+"));
            local = local.replaceAll("\\.", "");
            set.add(local + "@" + domain);
        }
        return set.size();
    }

}
