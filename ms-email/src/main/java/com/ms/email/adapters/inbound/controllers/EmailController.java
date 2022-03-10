package com.ms.email.adapters.inbound.controllers;

import com.ms.email.adapters.dtos.EmailDto;
import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.domain.PageInfo;
import com.ms.email.aplication.ports.EmailServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RestController
public class EmailController {

    @Autowired
    private EmailServicePort service;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        this.service.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<Email>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable) {
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Email> emailList= service.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<Email>(emailList, pageable, emailList.size()), HttpStatus.OK);
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity<Object> getOneEmail(@PathVariable (value = "emailId") UUID emailId ) {
        Optional<Email> emailOptional = service.findById(emailId);
        if (!emailOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(emailOptional.get());
        }
    }


}
