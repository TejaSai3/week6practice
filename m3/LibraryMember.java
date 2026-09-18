import java.util.Arrays;

// Additions to LibraryMember class for Fine Ledger functionality:

public class LibraryMember {
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }
}


// Updated StudentMember implementation:
class StudentMemberWithFines extends StudentMember {

    public StudentMemberWithFines(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit, course);
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}
