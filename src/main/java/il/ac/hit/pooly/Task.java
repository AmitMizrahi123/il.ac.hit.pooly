package il.ac.hit.pooly;

public interface Task {
    void perform();
    void setPriority(int level);
    int getPriority();
    void setTaskName(String taskName);
    String getTaskName();
    void setPerform(Boolean isPerform);
    Boolean getPerform();
}
