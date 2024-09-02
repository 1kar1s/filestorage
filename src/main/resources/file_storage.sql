CREATE TABLE files (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    description TEXT,
    file_data TEXT NOT NULL -- Хранение файла в формате base64
);

SELECT * FROM files;

INSERT INTO files (title, creation_date, description, file_data) 
VALUES ('Example File', NOW(), 'This is an example file.', 'base64_encoded_file_content');