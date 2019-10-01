import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.assertTrue;

public class CompletedTodoTest {

    private ToDoPage todoApp = new ToDoPage();

    @BeforeClass
    public void setUp() {
        Selenide.open("http://localhost:4200");
    }

    @Test
    public void completeTodo() {
        todoApp.addTodo("Drink water for ", 6);
        assertTrue(todoApp.checkedToDoCounter(3));
        assertTrue(todoApp.completedAttributeIsPresent());
    }
}
