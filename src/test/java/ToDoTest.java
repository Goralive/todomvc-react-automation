import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ToDoPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class ToDoTest {

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

    @Test
    public void completeTodo() {
        todoApp.addTodo("Drink water for ", 6);
        assertTrue(todoApp.checkedToDoCounter(3));
       // assertTrue();
    }

    @Test
    public void activeTab() {
        todoApp.addTodo("Write tests", 15);
        todoApp.checkedToDoCounter(7);
        assertTrue(todoApp.activeTabPresentsOfElements());
    }
}
