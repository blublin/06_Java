# Spring Project Template/Notes
@ By Ben Lublin  
@ Last Updated: 6/17/2022 11:45am

## New Spring Starter Project  
## 1. Setup:
* Name = Artifact (camel case)
* Java Version 8
* Packaging: War
* Group/Package: com.name.projectName
* Save Location: Java/Spring/projectName
* Dependencies: Spring Web, Spring Boot DevTools  

## 2. src/main/resources > application.properties:
```
# .jsp Files Location
spring.mvc.view.prefix=/WEB-INF/
# Data Persistence
spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR-SCHEMA-HERE>>
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
# For Update and Delete method hidden inputs
spring.mvc.hiddenmethod.filter.enabled=true
```

## 3. Dependencies:
* These replace everything between the `<dependencies>` tags
* *If you have Dependncy errors, you may have to force update Maven*
	* *Right click on project in Package Explorer*
	* *Maven -> Update Project*
	* *Check Force Update, then select OK*
```
<!-- DEPENDENCIES FOR STARTING SPRING PROJECTS-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
<!-- DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
</dependency>
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
<!-- DEPENDENCIES FOR INTEGRATING SQL DATABASE AND USING JPA -->
<!-- Note: Project will not run until a schema has been created and the 
	proper settings in application properties are present for 
	connecting to a database. -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<!-- DEPENDENCY FOR USING BCRYPT  -->
<dependency>
	<groupId>org.mindrot</groupId>
	<artifactId>jbcrypt</artifactId>
	<version>0.4</version>
</dependency>
<!-- DEPENDENCIES FOR BOOTSTRAP -->
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>webjars-locator</artifactId>
	<version>0.30</version>
</dependency>
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>bootstrap</artifactId>
	<version>5.0.1</version>
</dependency>
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>jquery</artifactId>
	<version>3.6.0</version>
</dependency>
```

	
## 4. src > main > webapp
* new directory: WEB-INF
* all Dynamic views created in here (.jsp)
	* ${variable} any variable from session, model, etc
	* c: syntax for JSTL
	* <% %> java lines
		* <%= %> in-line java
			*(Ex: <%= i %> in for loop, <%= new Date() %>)

### .jsp template file
####x` Set in Window > Preferences > Search for: jsp template > New JSP File (html 5)
```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
${cursor}
</body>
</html>
```

## 5. src/main/java
* ### Model
	* New Package: `com.name.project.models`
	* New Class: `Models`
```
@Entity
@Table(name="models") 
public class Model {
//	|--- MEMBER VARIABLES (COLUMNS) ---|
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @Size(min = 2, max = 30, message="string must be between 2 and 30 characters")
	private String string;
    
    @NotNull
    @Min(value=18, message="You must be at least 18 years old to be a ninja!")
    @Max(value=115, message="It's time to take a break sensei")
	private int someNum;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
//	Unique methods for created/updated
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
```
* 
	* **JPA Validations**
	* @Entity: represents an entity model for our application
	* @Table: sets this as a table in the database
	* @Id: sets this as the primary key
	* @GeneratedValue: sets this as an auto-incrementing value
	* (@GeneratedValue(strategy = GenerationType.IDENTITY))
	* @Size adds validation that the column must be in the specified range
	* @Min adds validation that the column must be at least the specified value
	* @Max adds validation that the column must be no greater than the specified value
	* @DecimalMin("0.0") adds decimal/floating-point min validation
	* @DecimalMax adds decimal/floating-point max validation
	* @NotNull adds validation that the column must be null
	* @PrePersist runs the method right before the object is created
	* @PreUpdate runs a method when the object is modified


* ### Repository
	* New Package: `com.name.project.repos`
	* New Interface: `ModelRepository`
```
@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {

//	Overwrite findAll
	List<Dojo> findAll();

//	Add any extra custom queries
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methodss
	Optional<Model> findByCol(Type var);

//	Empty Constructor
	public Model() {}
}
```
* ### Service (CRUD)
	* New Package: `com.name.project.services`
	* New Interface: `ModelService`
```
@Service
public class ModelService {

	@Autowired
	private ModelRepository mRep;

//	|--- Get All ---|
	public List<Model> getAll() {
		return mRep.findAll();
	}

//	|--- Get One By ID ---|
	public Model readOne(Long id) {
		Optional<Dojo> dojoOpt = dRep.findById(id);
		return dojoOpt.isPresent() ? dojoOpt.get() : null;
	}

//	|--- Create One ---|
	public Model create(Model m) {
		return mRep.save(m);
	}

//	|--- Update One ---|
	public Model updateOne(Model m) {
		return mRep.save(m);
	}

//	|--- Delete One ---|
	public void deleteOne(Long id) {
		mRep.deleteById(id);
	}
}
```	

	
* ### Controller
	* New Package: `com.name.project.controllers`
	* New Interface: `ModelController` or `MainController` or `TheBigController`


* @RequestMapping("")
	* value="route"
	* method="RequestMethod.GET
	* optional path variables: {variable} (/route/{variable})
	
	* @GetMapping
	* @PostMapping
	* @DeleteMapping
	* @PutMapping
	
* @RequestParam(value, required=true), String searchQuery (in method signature)
	* Method signature :: value stored locally in searchQuery
	* value="q" :: string inserted after route (route?value=)
	* required=false (default true)
		* @RequestParam("value") gets normal form input	
	
 @PathVariable String variable (in method signature) (needs to match the path {variable}
	1. Method signature
	2. match route variable, store as String variable
	3. If other than string, try / catch
		A. type variable
		B. try variable = casted type
		C. catch return some error message
		
d. @RestController class
	1. string, JSON, xml returns
	
e. @Controller class
	1. returns view (.jsp page)

f. @ModelAttribute("front-end-variable") ClassModel localVar
	1. 1 line version of Model model to send a blank class object to a form:form
	2. Also retrieves the model from the form:form in POST

g. @Valid
	1. prefaces @ModelAttribute in POST

h. @BindingResult result
	1. creates result object to test if there are errors
	2. result.hasErrors()
		
			
	2. Model model
		a. a map interface that passes key-value pairs to the view
		b. public String methodName(Model model)
		b. model.addAttribute("viewVariable", data)
	
	3. HttpSession session
		a. Method parameter
		b. import javax.servlet.http.HttpSession
		c. creates client cookie automatically
		d. session.setAttribute("key", value)
		e. session.getAttribute("key")
			1. Need to cast val as it's stored as Object data type
				A. String value = (String) session.getAttribute("key")
				A. Integer value = (Integer) session.getAttribute("key")
			2. Use if null to check if the key exists before doing creating/updating
	
	4. @
				
7. src/main/resources > static
	a. CSS, JavaScript
		1. static/css/style.css
		2. static/js/app.js