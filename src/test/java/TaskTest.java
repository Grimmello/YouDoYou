import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TaskTest {
  private Task testTask;

  @Before
  public void setUp(){
    Timestamp newDate = Timestamp.valueOf(LocalDateTime.now().plusDays(10));
    testTask = new Task("Laundry", newDate, 1, 1, 1,1,1);
    // testTask.save();
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void task_instantiatesCorrectly_true(){
    assertTrue(testTask instanceof Task);
  }

  @Test
  public void markCompleted_marksATaskTrueForCompleted_true(){
    assertFalse(testTask.getCompleted());
    testTask.markCompleted();
    assertTrue(testTask.getCompleted());
  }

  @Test
  public void getters_returnExpectedValues_true(){
    assertEquals("Laundry", testTask.getName());
    Timestamp expectedDate = Timestamp.valueOf(LocalDateTime.now().plusDays(10));
    assertEquals(expectedDate.getDate(), testTask.getDue_time().getDate());
    assertEquals(1, testTask.getUser_id());
    assertEquals(1, testTask.getSkill_id());
    assertEquals(1, testTask.getPriority_level());
    assertFalse(testTask.getCompleted());
    assertEquals(1, testTask.getTask_list_id());
    assertEquals(1, testTask.getImportance());
  }

}
