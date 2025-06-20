
Spring Boot File Upload Application
===================================

This is a simple Spring Boot application that allows users to upload files (such as video, images, or PDFs) through a responsive Bootstrap-based HTML form. The uploaded files are saved to a specified folder on the local file system.

Technologies Used
-----------------
- Java 17+
- Spring Boot (Web, Multipart Support)
- Bootstrap 5
- HTML5
- Maven

Folder Structure
----------------
springboot-upload-any-file/
|
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── demo/
│                       └── controller/
│                           └── FileController.java
│
│       └── resources/
│           ├── application.properties
│           └── static/
│               └── index.html
│
├── pom.xml
└── README.txt

Configuration
-------------
application.properties:

location=C:\Users\Sharad\Desktop\uploadedfiles
spring.servlet.multipart.max-file-size=100MB
spring.servlet.multipart.max-request-size=100MB

Make sure the upload folder exists. If not, create it manually at the path you specified.

FileController.java
-------------------
Handles file upload requests:

@PostMapping("/upload")
public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    // Saves the uploaded file to the specified directory
}

Frontend (index.html)
---------------------
- Located in src/main/resources/static/index.html
- Uses Bootstrap for responsive design
- Accepts all file types, including videos

<form action="/upload" method="post" enctype="multipart/form-data">
  <input type="file" name="file" accept="video/*" required>
  <button type="submit">Upload</button>
</form>

Run the Project
---------------
1. Clone or download the project.
2. Open it in Spring Tool Suite, IntelliJ, or any IDE.
3. Run the main() method.
4. Visit http://localhost:8080/index.html to use the upload form.

Output
------
Uploaded files will be saved to the folder specified in application.properties.

Example:
C:\Users\Sharad\Desktop\uploadedfiles\yourfile.mp4

Features
--------
- Upload any type of file (video, image, PDF, etc.)
- Simple and responsive UI using Bootstrap
- Handles large files (up to 100MB)
- Returns success or error message

To Do (Optional Enhancements)
-----------------------------
- Add file preview for videos/images
- Store uploaded file metadata in database
- Display upload progress bar
- Secure file type/extension validation

Author
------
Sharad Kamble
