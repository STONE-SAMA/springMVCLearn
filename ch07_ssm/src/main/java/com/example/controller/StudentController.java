package com.example.controller;

import com.example.beans.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService service;

    //增加学生
    @RequestMapping(value = "addStudent.do")
    public ModelAndView addStudent(Student student){
        String tips = "注册失败！";
        ModelAndView mv = new ModelAndView();
        //调用service处理student
        int nums = service.addStudent(student);
        if(nums > 0){
            //添加成功
            tips = "学生 【" + student.getName() + "】 添加成功！";
        }
        //添加数据
        mv.addObject("tips",tips);
        //指定结果界面
        mv.setViewName("result");
        return mv;
    }

    //处理查询响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查，简单数据处理
        List<Student> students = service.findStudents();
        return students;
    }

}
