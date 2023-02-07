package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "secured/student/list")
    public ModelAndView displayStudent() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
       // List<User> users = userRepository.findAll(Sort.by(sortBy));
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }
//    @GetMapping("secured/student/list/new")
//    public String pageForm(){
//        return "secured/student/new" ;
//    }


    @GetMapping("/secured/student/list/new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "secured/student/new";
    }


    @PostMapping(value = {"/secured/student/list/new"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }

        studentService.addStudent(student);
        return "redirect:/secured/student/list";
    }

//    @GetMapping(value ="secured/student/delete/list/{studntId}")
//    public String deletePublisher(@PathVariable Integer studentId) {
//        studentService.deleteStudentById(studentId);
//        return "redirect:/secured/student/list";
//    }

    @GetMapping(value = {"/student/delete/{id}"})
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/secured/student/list";
    }

    @GetMapping("/updateForm/{id}")
    public ModelAndView updateForm(@PathVariable Integer id) {
        Student student = studentService.findStudentById(id);
        var model = new ModelAndView();
        model.addObject("student", student);
        model.setViewName("/secured/student/updateForm");
        return model;
    }

//    @GetMapping(value = {"secured/student/list/{id}"})
//    public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student){
//        studentService.updatedStudent(id,student);
//        return "redirect:/secured/student/list";
//    }


    @GetMapping(value = {"/secured/student/update/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "secured/student/updateForm";
        }
        return "redirect:/secured/student/list";
    }

    @PostMapping(value = {"/secured/student/update/{studentId}"})
    public String updateStudent(@Valid @ModelAttribute("studentId") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/updateForm";
        }

        var studentSaved = studentService.updatedStudent(student);

        return "redirect:/secured/student/list";
    }


    @GetMapping(value = {"/secured/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var students = studentService.searchStudent(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("/secured/student/searchResult");
        return modelAndView;

    }

}


