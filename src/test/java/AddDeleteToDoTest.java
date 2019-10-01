import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import pages.ToDoPage;

import static org.testng.Assert.assertTrue;



public class AddDeleteToDoTest {

    private ToDoPage todoApp = new ToDoPage();

    @BeforeClass
    public void setUp() {
        Selenide.open("http://localhost:4200");
    }


    @Test
    public void addToDo() {
        todoApp.addTodo("Selenide");
        assertTrue(todoApp.isTodoListCreated(), "No elements in todo list");
    }

    @Test
    public void deleteToDo() {
        todoApp.addTodo("Milk");
        todoApp.addTodo("Potato");
        todoApp.addTodo("Tomato");
        assertTrue(todoApp.deleteToDo(), "Issue with delete todo");
    }
}
