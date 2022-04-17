package com.example.backend.web.rest;

import com.example.backend.entity.Symptoms;
import com.example.backend.service.SymptomsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("api/")
@Api(value = "Symptoms apis")
@ApiModel()
public class SymptomsResource {

    @Autowired
    private SymptomsService symptomsService;

    @GetMapping("/symptoms")
    @ApiOperation(value = "Lấy tất cả triệu chứng")
    public ResponseEntity<List<Symptoms>> getAllSymptoms() {
        Integer b = null;
        System.out.println((b + 1));
        return ResponseEntity.ok().body(symptomsService.getAllSymptoms());
    }

    @PostMapping("/symptoms")
    @ApiOperation(value = "Thêm mới một triệu chứng")
    @ApiResponses({ @ApiResponse(code = 200, message = "thêm Thành công"),
            @ApiResponse(code = 405, message = "Quá thời gian thêm"),
            @ApiResponse(code = 401, message = "Session invalid, đăng nhập lại!"),
            @ApiResponse(code = 403, message = "Bạn không có quyền")})
    public ResponseEntity<Symptoms> addSymptom(@ApiParam(value = "đối tượng Symptom cần thêm vào DB") @RequestBody Symptoms symptoms) {
        String fileName = "test.txt";
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                System.out.println("Creating: "+ fileName +": " + file.createNewFile());
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            String result = bufferedReader. readLine();
            if(result.isEmpty())
                System.out.println("Empty input");
            else System.out.println(result);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(symptomsService.addSymptoms(symptoms));
    }
}
