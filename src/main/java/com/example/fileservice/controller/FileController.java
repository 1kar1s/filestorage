package com.example.fileservice.controller;

import com.example.fileservice.model.FileEntity;
import com.example.fileservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Long> createFile(@RequestBody FileEntity fileEntity) {
        fileEntity.setCreationDate(LocalDateTime.now());
        Long fileId = fileService.saveFile(fileEntity);
        return ResponseEntity.ok(fileId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileEntity> getFile(@PathVariable Long id) {
        FileEntity fileEntity = fileService.getFile(id);
        return ResponseEntity.ok(fileEntity);
    }

    @GetMapping
    public ResponseEntity<List<FileEntity>> getAllFiles(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(fileService.getAllFiles(PageRequest.of(page, size)));
    }
}