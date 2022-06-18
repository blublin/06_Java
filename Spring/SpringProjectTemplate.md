# Spring Project Template/Notes
@ By Ben Lublin  
@ Last Updated: 6/17/2022 2:00pm

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
# On Mac OS X, it's likely rootroot
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
####  Set in Window > Preferences > Search for: jsp template > New JSP File (html 5)
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
### Display One to Many (Dojo showing Dojo + ninjas)
```
<div class="container w-75 mx-auto">
	<h1 class="text-center">${ model.getName() }</h1>
	<table class="table table-borderless border border-2">
		<thead>
			<tr>
				<td>Attribute 1</td>
				<td>Attribute 2</td>
				<td>Attribute 3</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${model.model2Many}" var="n">
				<tr>
					<td>${n.getAttribute1() }</td>
					<td>${n.getAttribute2() }</td>
					<td>${n.getAttribute3() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
```
### Create One (Dojo)
```
<div class="container w-75 mx-auto">
	<h1 class="text-center">New Model</h1>
	<form:form action="/models/processForm" method="post" modelAttribute="model"
		class="d-flex flex-column align-items-center border border-3 border-dark">
		
		<p>
			<form:errors path="attribute1" cssClass="text-danger" />
		</p>
		<p class="d-flex">
			<form:label class="col-5" path="attribute1">Attribute 1:</form:label>
			<form:input class="col-12" path="attribute1" />
		</p>
		<input type="submit" value="Submit" class="col-3" />
	</form:form>
</div>
```

### Create Many (Ninjas) and Link to One
```
<div class="container w-75 mx-auto">
	<h1 class="text-center">New Model</h1>
	<form:form action="/model/processForm" method="post" modelAttribute="model"
		class="d-flex flex-column align-items-center border border-3 border-dark">
		<p>
			<form:errors path="modelOne" cssClass="text-danger"/>
		</p>
		<p>
			<form:select path="modelOne">
				<c:forEach items="${modelOne}" var="m">
					<option value="${m.getId() }">${m.getName()}</option>
				</c:forEach>
			</form:select>
		</p>
		
		<p>
			<form:errors path="attribute1" cssClass="text-danger" />
		</p>
		<p class="d-flex">
			<form:label class="col-5" path="attribute1">attribute1:</form:label>
			<form:input class="col-12" path="attribute1" />
		</p>

		<p>
			<form:errors path="attribute2" cssClass="text-danger" />
		</p>
		<p class="d-flex">
			<form:label class="col-5" path="attribute2">attribute2:</form:label>
			<form:input class="col-12" path="attribute2" />
		</p>

		<p>
			<form:errors path="attribute3" cssClass="text-danger" />
		</p>
		<p class="d-flex">
			<form:label class="col-5" path="attribute3">attribute3:</form:label>
			<form:input class="col-12" path="attribute3" />
		</p>
		<input type="submit" value="Submit" class="col-3" />
	</form:form>
</div>
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

	//  MANY TO ONE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="model2_id")
    private Model model2;

	//  ONE TO MANY
    @OneToMany(mappedBy="model2MemberVariable", fetch = FetchType.LAZY)
    private List<Model2> model2s;

	// ONE TO ONE (USES FOREIGN KEY)
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="model2_id")
    private Model2 model2;

	// ONE TO ONE (PROVIDES KEY)
	@OneToOne(mappedBy="model2MemberVariable", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Model2 model2;
	
	//	Unique methods for created/updated
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
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
	List<Model> findAll();

//	Add any extra custom queries
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methodss
	Optional<Model> findByCol(Type var);
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
		Optional<Model> modelOpt = mRep.findById(id);
		return modelOpt.isPresent() ? modelOpt.get() : null;
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
		* from form keywords/name
	* @PathVariable String variable (in method signature) (needs to match the path {variable}
		* Method signature
		* match route variable, store as String variable
		* If other than string, try / catch
			```		
			NonStringType var;
			try{
				var = NonStringType.parseNonStringType(id);
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
				return "redirect:/models/new";
			}
			Model m = mServ.readOne(var);
			model.addAttribute("model", m );
			return "viewModel.jsp";
			```

	* @RestController class
		* string, JSON, xml returns
	* @Controller class
		* returns view (.jsp page)

	* @ModelAttribute("front-end-variable") ClassModel localVar
		* 1 line version of Model model to send a blank class object to a form:form
		* Also retrieves the model from the form:form in POST
	* @Valid
		* prefaces @ModelAttribute in POST
	* @BindingResult result
		* creates result object to test if there are errors
		* result.hasErrors()
	* Model model
		* a map interface that passes key-value pairs to the view
		* public String methodName(Model model)
		* model.addAttribute("viewVariable", data)
	* HttpSession session
		* Method parameter
		* import javax.servlet.http.HttpSession
		* creates client cookie automatically
		* session.setAttribute("key", value)
		* session.getAttribute("key")
			* Need to cast val as it's stored as Object data type
				* String value = (String) session.getAttribute("key")
				* Integer value = (Integer) session.getAttribute("key")
			* Use if null to check if the key exists before doing creating/updating
	* Handle Post Forms
	```
	@PostMapping("/mdoels/processForm")
	public String processForm(@Valid @ModelAttribute Model model,
			BindingResult res) {
		if (res.hasErrors()) {
			return "newModel.jsp";
		}
		else {
			mServ.create(model);
			Long id = model.getId();
			return "redirect:/models/" + id;
		}
	}
	```

## 6 src/main/resources > static  
* CSS, JavaScript
	* static/css/style.css
	* static/js/app.js