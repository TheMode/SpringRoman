package com.example.demo.service;

import com.example.demo.utils.RomanNumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanConversionService {

    @GetMapping("/dec-to-roman/{decimalNumber}")
    public String toRoman(@PathVariable Integer decimalNumber) {
        return RomanNumberUtils.toRoman(decimalNumber);
    }

    @GetMapping("/roman-to-dec/{romanNumber}")
    public Integer toDecimal(@PathVariable String romanNumber) {
        return RomanNumberUtils.fromRoman(romanNumber);
    }

}
