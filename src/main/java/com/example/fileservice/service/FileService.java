package com.example.fileservice.service;

import com.example.fileservice.model.FileEntity;
import com.example.fileservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public Long saveFile(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
        return fileEntity.getId();
    }

    public FileEntity getFile(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public List<FileEntity> getAllFiles(Pageable pageable) {
        Page<FileEntity> files = fileRepository.findAll(pageable);
        return files.getContent();
    }
}