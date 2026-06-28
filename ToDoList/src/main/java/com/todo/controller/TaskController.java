package com.todo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.entity.Task;
import com.todo.service.TaskService;


@Controller
public class TaskController{

	@Autowired
	private TaskService taskService;
	
	// Display Home page
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("taskList", taskService.getAllTasks());{
			return "index";
		}}
		// Show Add Task Form
		@GetMapping("/addTask")
		public String showAddTaskForm(Model model) {
			model.addAttribute("task",new Task());{
			return "add-task";
		}}
			//Save Task
		    @PostMapping("/saveTask")
		    public String saveTask(@ModelAttribute Task task) {
		        taskService.saveTask(task);
		        return "redirect:/";
		    }
		 // Show Edit Task Form
		    @GetMapping("/editTask/{id}")
		    public String showEditTaskForm(@PathVariable Long id, Model model) {
		    	Optional<Task> task = taskService.getTaskById(id);

		        if (task.isPresent()) {
		            model.addAttribute("task", task.get());
		            return "edit-task";
		        }

		        return "redirect:/";
		    }
		    // Update Task
		    @PostMapping("/updateTask")
		    public String updateTask(@ModelAttribute Task task) {
		        taskService.updateTask(task);
		        return "redirect:/";
		    }
		    // DeleteTask
		    @GetMapping("/deleteTask/{id}")
		    public String deleteTask(@PathVariable Long id) {
		        taskService.deleteTask(id);
		        return "redirect:/";
		    }

}

