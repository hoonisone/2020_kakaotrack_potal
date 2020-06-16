package kr.ac.jejunu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;
    @RequestMapping("/user")
    public User getUser(@RequestParam("id") Integer id) { return userDao.get(id); }

    @RequestMapping("/exception")
    public void exception(){ throw new RuntimeException("어이쿠!"); }

    @RequestMapping(path ="/upload", method = RequestMethod.GET)
    public void upload(){ }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/") + "/WEB-INF/static/" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOUtputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOUtputStream.write(file.getBytes());
        bufferedOUtputStream.close();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", "/images/"+file.getOriginalFilename());
        return modelAndView;
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public void test() throws IOException {
        return;
    }

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public void test(HttpServletRequest request) throws IOException {

        return;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}

