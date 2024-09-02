package com.example.fileservice;

import com.example.fileservice.model.FileEntity;
import com.example.fileservice.repository.FileRepository;
import com.example.fileservice.service.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class FileServiceTest {

    @InjectMocks
    private FileService fileService;

    @Mock
    private FileRepository fileRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFile() {
        FileEntity file = new FileEntity();
        file.setTitle("Test");
        when(fileRepository.save(any(FileEntity.class))).thenReturn(file);

        Long id = fileService.saveFile(file);
        assertNotNull(id);
        verify(fileRepository, times(1)).save(file);
    }
}