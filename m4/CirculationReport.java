public class CirculationReport {

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        for (LibraryMember m : members) {
            report.append(m.displayInfo());
            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m;
                report.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }
            report.append(" | ");
        }

        return report.toString();
    }
}
