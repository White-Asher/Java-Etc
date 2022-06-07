public class Study {

    private StudyStatus studyStatus;

    private int limit;

    public Study(){

    }

    // Study의 생성자에서 exception을 던지도록 설정
    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public int getLimit() {
        return limit;
    }
}