package com.sid.controller;

import com.sid.model.User;
import com.sid.service.UserService;
import com.sun.javafx.image.impl.ByteRgb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
//@RequestMapping("/u")
public class Usercontroller {
    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/user",method = POST)

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void home(User user, HttpServletRequest request) throws IOException {

        String id = request.getParameter("id");
        System.out.println("id = " + id);
        byte[] buffer = new byte[1024];
        String xxx = "";
        try (
                InputStream is = request.getInputStream();
        ) {
            while (is.available() > 0) {
                int length = is.read(buffer);
                xxx += new String(buffer, "iso-8859-1");

//                userService.insert(user);
            }

            System.out.println("xxx = " + xxx);

        } catch (IOException ex) {

        }


    }

    @RequestMapping("/hu")
    public String hu(@RequestParam String zhu) {
        return "sasasa";
    }

}
