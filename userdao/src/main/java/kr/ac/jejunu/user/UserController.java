package kr.ac.jejunu.user;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;
    @RequestMapping(path="/user",produces = "text/html")
    public User getUser(@RequestParam Long id){
        return userDao.findById(id);
    }

    @RequestMapping("/exceoption")
    public void exceoption(){
        throw new RuntimeException("어잌쿠");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e",e.getMessage());
        return modelAndView;
    }
    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public void upload(){
    }
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/")+"/WEB-INF/static/"+file.getOriginalFilename();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url","/images/"+file.getOriginalFilename());
        return modelAndView;
    }
}
