package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ToDoPage {
    private SelenideElement newToDoInp = $(".new-todo");
    private ElementsCollection listOfElements = $$(".todo-list li");
    private SelenideElement deleteBtn = $(".destroy");
    private SelenideElement hoverToDo = $(".view");
    private SelenideElement todoCount = $(".todo-count strong");
    private ElementsCollection completedToDos = $$(".completed");

    int listItemsBeforeWasChecked;
    int listItemsAfterWasChecked;


    public void addTodo(String value) {
        newToDoInp.val(value).pressEnter();
    }

    public void addTodo(String value, int times) {
        for (int i = 1; i < times + 1; i++) {
            newToDoInp.val(value + i).pressEnter();
        }
    }

    public boolean isTodoListCreated() {
        if (listOfElements.size() > 0) {
            return true;
        }
        return false;
    }

    public int todoListSize() {
        return listOfElements.size();
    }

    public boolean deleteToDo() {
        if (isTodoListCreated()) {
            while (isTodoListCreated()) {
                hoverToDo.hover();
                deleteBtn.click();
            }
            return true;
        }
        return false;
    }

    public boolean checkedToDoCounter(int numbersOfClicks) {
        listItemsBeforeWasChecked = Integer.valueOf(todoCount.getText());
        for (int i = 1; i < numbersOfClicks + 1; i++) {
            SelenideElement inputToggle = $(".todo-list li:nth-of-type(" + i + ") input.toggle");
            inputToggle.click();
        }
        listItemsAfterWasChecked = Integer.valueOf(todoCount.getText());

        if (listItemsBeforeWasChecked - numbersOfClicks == listItemsAfterWasChecked) {
            return true;
        }
        return false;
    }

    public boolean completedAttributeIsPresent() {
        return listItemsAfterWasChecked == completedToDos.size();
    }

    public boolean activeTabPresentsOfElements() {
        return true;
    }
}




