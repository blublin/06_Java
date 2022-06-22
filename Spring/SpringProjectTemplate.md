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
		* <c:if test=""></c:if>
		* <c:choose>
			* <c:when test=""></c:when>
			* <c:otherwise></c:otherwise>
		* </c:choose>
		* <c:forEach items="${iterableVariable}" var="">
		* <c:out value="" />

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
* Login / Registration Forms, 1 page
```
<h2 class="text-center">Welcome!</h2>
<div class="container w-75 mx-auto d-flex">

	
	<%-- Register --%>
	<div class="container w-75 mx-auto">
		<h1 class="text-center">Register</h1>
		<form:form action="/register" method="post" modelAttribute="regObj"
			class="d-flex flex-column align-items-center border border-3 border-dark">
			<p>
				<form:errors path="userName" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="userName">Username:</form:label>
				<form:input class="col-10" path="userName" />
			</p>

			<p>
				<form:errors path="email" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="email">Email:</form:label>
				<form:input class="col-10" path="email" />
			</p>

			<p>
				<form:errors path="password" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="password">Password:</form:label>
				<form:input class="col-10" path="password" />
			</p>

			<p>
				<form:errors path="confirm" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="confirm">Confirm Password:</form:label>
				<form:input class="col-10" path="confirm" />
			</p>
			<input type="submit" value="Submit" class="col-3" />
		</form:form>
	</div>
	
	<%-- Login --%>
	<div class="container w-75 mx-auto">
		<h1 class="text-center">Login</h1>
		<form:form action="/login" method="post" modelAttribute="loginObj"
			class="d-flex flex-column align-items-center border border-3 border-dark">
			<p>
				<form:errors path="email" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="email">Email:</form:label>
				<form:input class="col-10" path="email" />
			</p>

			<p>
				<form:errors path="password" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="password">Password:</form:label>
				<form:input class="col-10" path="password" />
			</p>
			<input type="submit" value="Submit" class="col-3" />
		</form:form>
	</div>
</div>
```
* If Edit (PUT), place this line below initial form:form.
	* `<input type="hidden" name="_method" value="put">`


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

	// MANY TO MANY
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "thisModels_foreignModels", 
        joinColumns = @JoinColumn(name = "thisModel_id"), 
        inverseJoinColumns = @JoinColumn(name = "foreignModel_id")
    )     
    private List<ForeignModel> foreignModel;
	
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
* Login Model
```
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

    // Retrieves a list of all thisModel for a particular foreignModel
    List<thisModel> findAllByForeignModel(ForeignModel foreignModel);
    
    // Retrieves a list of any thisMOdel a particular foreignModel
    // does not belong to.
    List<thisModel> findByForeignModelNotContains(ForeignModel foreignModel);

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

//	Register User
	public User register(User userFromReg, BindingResult result) {
        
        // Reject if email is taken (present in database)
    	Optional<User> userCheck = uRep.findByEmail( userFromReg.getEmail() );
    	if (userCheck.isPresent()) {
    		result.rejectValue("email", "regError", "Email already exists");
    		//	Test if identical keywords work    		
    		result.rejectValue("email", "regError", "Email already exists STILL");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!userFromReg.getPassword().equals(userFromReg.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
        // Return null if result has errors
    	if (result.hasErrors()) {
    		return null;
    	}
    
    	//	No Errors found, register user    	
        // Hash and set password
    	String hashedPassword = BCrypt.hashpw(userFromReg.getPassword(), BCrypt.gensalt());
    	userFromReg.setPassword(hashedPassword);
    	// Save user to database
    	User validUser = uRep.save(userFromReg);
        return validUser;
    }

//	Login User
    public User login(LoginUser userFromLogin , BindingResult result) {
    	
    	Optional<User> userCheck = uRep.findByEmail( userFromLogin.getEmail() );
    	//	Check if user exists    	
    	if (userCheck.isEmpty()) {
    		result.rejectValue("email", "loginError", "Invalid Login");
    		return null;
    	}
    	//	And check if passwords match    	
    	else if( !BCrypt.checkpw( userFromLogin.getPassword(), userCheck.get().getPassword() )) {
    	    result.rejectValue("password", "loginError", "Invalid Login");
            return null;
    	}
    	else {
    		//	Login Email and Password match
    		return userCheck.get();
    	}
	}

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
* //	|--- Many To Many ---|
* From your Service, adding a relationship between two existing records involves a couple steps:
	* Fetch both the specific product and category out of the database, and assigning the returned object instances to variables.
	* Add the product to the products list for that category. Remember, products is a member variable in the Category class. 
	* Save the category object.
	* List methods to modify data
		* .get() List
		* .add(valutToAdd)
		* .contains(value) returns true/false
	* ```
		// Add foreign model object to this model List
		thisModel.getForeignModel().add(foreignModel);
		// Save updated thisModel
    	modelRepo.save(thisModel);
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

	*  Login / Register GET Route
	```
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("regObj", new User()); // This goes to the register form
        model.addAttribute("loginObj", new LoginUser()); // This goes to the login form
        return "loginReg.jsp";
    }
	```
	* Register POST Route
	```
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession seshRogen) {
        
    	//	Use Service to validate and conditionally register 
    	User validUser = uServ.register(newUser, result);
 
        // to do some extra validations and create a new user!
        if (validUser == null || result.hasErrors() ) {
    		//	Re-rendering, need to provide another newLogin object.
        	model.addAttribute("newLogin", new LoginUser());
    		//	newUser from ModelAttribute still exists and will be sent forward
    		return "index.jsp";
    	}        	
        
        // No errors!
        //	Store user ID in session        
        seshRogen.setAttribute("user_id", newUser.getId());
    
        return "redirect:/home";
    }
	```
	* Login POST Route
	```
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult bRes, Model model, HttpSession seshRogen) {
        
        // Add once service is implemented:
		User userCheck = uServ.login(newLogin, bRes);
		
        if(userCheck == null || bRes.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // No errors! 
		// Store user ID in session        
        seshRogen.setAttribute("user_id", userCheck.getId());
   
        return "redirect:/home";
    }
	```

## 6 src/main/resources > static  
* CSS, JavaScript
	* static/css/style.css
	* static/js/app.js