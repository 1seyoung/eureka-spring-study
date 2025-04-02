package com.springmvcbook.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
  @GetMapping("/book")
  public String bookPage(HttpSession session) {
    return "book";
  }
}
