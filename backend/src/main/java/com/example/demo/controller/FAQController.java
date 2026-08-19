package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FAQ;
import com.example.demo.repository.FAQRepository;

@RestController
@RequestMapping("/faqs")
@CrossOrigin(origins = "*")
public class FAQController {

    @Autowired
    private FAQRepository faqRepository;

    @GetMapping
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @PostMapping
    public FAQ addFAQ(@RequestBody FAQ faq) {
        return faqRepository.save(faq);
    }
}