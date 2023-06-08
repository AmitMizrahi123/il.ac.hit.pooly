import il.ac.hit.pooly.MyTask;
import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadsPool;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ThreadPoolTests {
    private ThreadsPool threadsPool;

    @BeforeEach
    public void setUp() {
        this.threadsPool = new ThreadsPool(3);
    }

    @Test
    public void verifyTasksName() {

        Task task1 = new MyTask(2, "Task 1");
        Task task2 = new MyTask(1, "Task 2");
        Task task3 = new MyTask(3, "Task 3");

        this.threadsPool.submit(task1);
        this.threadsPool.submit(task2);
        this.threadsPool.submit(task3);

        this.threadsPool.waitUntilAllTaskAreFinishes();

        assertEquals("Task 3", task3.getTaskName());
        assertEquals("Task 1", task1.getTaskName());
        assertEquals("Task 2", task2.getTaskName());
    }

    @Test
    public void verifyTasksSubmit() {

        Task task1 = new MyTask(2, "Task 1");
        Task task2 = new MyTask(1, "Task 2");
        Task task3 = new MyTask(3, "Task 3");

        this.threadsPool.submit(task1);
        this.threadsPool.submit(task2);
        this.threadsPool.submit(task3);

        this.threadsPool.waitUntilAllTaskAreFinishes();

        assertEquals(true, task3.getPerform());
        assertEquals(true, task1.getPerform());
        assertEquals(true, task2.getPerform());
    }

    @AfterEach
    public void afterEachTest() {
        this.threadsPool.shutDownExecutor();
    }
}
