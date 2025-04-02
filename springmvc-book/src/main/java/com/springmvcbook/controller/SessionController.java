package com.springmvcbook.controller;

import com.springmvcbook.model.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionController {

  private final Admin admin = new Admin("admin", "1234");

  @PostMapping("/login")
  public String login(@RequestParam(value = "username", required = false) String username,
      @RequestParam(value = "password", required = false) String password, HttpSession session, RedirectAttributes redirectAttributes) {

    if(admin.login(username, password)) {
      session.setAttribute("username", username);
      return "redirect:/book";
    }

    redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
    return "redirect:/";

  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }
}
