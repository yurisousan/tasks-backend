package br.ce.wcaquino.taskbackend.controller;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

    @mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initiMocks(this);
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao () {
        Task todo = new Task();
    //    todo.setTasks("Descricao");
        todo.setDueDate(LocaData.now());
        try{
            controller.save(todo);
            Assert.fail("Não deveria chegar nesse ponto")
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the tasks description", e.getMessage());
        }
    }
    
    @Test
    public void naoDeveSalvarTarefaSemData () {
        Task todo = new Task();
    //    todo.setTasks("Descricao");
        todo.setDueDate(LocaData.now());
        try{
            controller.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }
    
    @Test
    public void naoDeveSalvarTarefaComDataPassada () {
        Task todo = new Task();
    //    todo.setTasks("Descricao");
        todo.setDueDate(LocaData.of(2010, 01, 01));
        try{
            controller.save(todo);
        } catch (ValidationException e) {
            Assert.assertEquals("Dua date must not be in past", e.getMessage());
        }
    }
    
    @Test
    public void deveSalvarTarefaComSucesso () throws ValidationException {
        Task todo = new Task();
        todo.setTasks("Descricao");
        todo.setDueDate(LocaData.now());
        controller.save(todo);
        Mockito.verify(taskRepo).save(todo);
    }
}
