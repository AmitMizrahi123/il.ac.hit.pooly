package il.ac.hit.pooly;

public class MyTask implements Task {
    private int priority;
    private String taskName;
    private Boolean isPerform;

    public MyTask(int priority, String name) {
        setPriority(priority);
        setTaskName(name);
        setPerform(false);
    }

    @Override
    public void perform() {
        setPerform(true);
        System.out.println("Performing task: " + taskName);
    }

    @Override
    public void setPriority(int level) {
        this.priority = level;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public void setPerform(Boolean isPerform) {
        this.isPerform = isPerform;
    }

    @Override
    public Boolean getPerform() {
        return this.isPerform;
    }
}
