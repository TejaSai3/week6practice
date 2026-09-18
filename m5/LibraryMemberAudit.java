public class LibraryMemberAudit {
    private static int membersEnrolledCount = 0;

    public final String memberNumber;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMemberAudit(int borrowLimit) {
        membersEnrolledCount++;
        this.memberNumber = "LIB-" + (100 + membersEnrolledCount);
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public static int getMembersEnrolled() {
        return membersEnrolledCount;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {
        // Record genre if needed, then delegate internally
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + facultyCount + " faculty " + regularCount + " regular";
    }
}