import java.util.HashMap;
import java.util.Map;

public class MemberManager {
    private Map<String, Member> members;

    public MemberManager() {
        members = new HashMap<>();
    }

    public void addMember(String memberId, Member member) {
        members.put(memberId, member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = members.get(memberId);
        if (member != null) {
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = members.get(memberId);
        if (member != null) {
            return member.getLastTransaction();
        }
        return null;
    }
}
