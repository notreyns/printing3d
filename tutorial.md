# order 3d printing 
## Step 1: Create new project
Open the spring initializr, choose your version of spring.io. This project is done by using maven plugin, so make sure that you chose this type of project. Name project
## Step 2: Dependencies
In next window, you could see list of dependecies. Actually, there are two ways to pick them. In the same window, select dependencies simply by clicking on them. For this project we need:
* Spring Boot Devtools(Developer tools), 
* Spring Web(Web), 
* Thymeleaf(Template engines)
* JDBC API, Spring Data Jpa, PostgreSQL Driver(SQL). But if you accidentally missed any dependencies, you can still add them later in the pom.xml folder. for this write down
~~~
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
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
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
        </dependency>
    </dependencies>
~~~
## Step 3: Create controller
Your Application.java is already in package. For better managing, you should create another controllers package and then declare here new Class MainController. A controller basically controls the flow of the data. It controls the data flow into model object and updates the view whenever data changes.
## Step 4: First task of controller
This code means that if you are in main page, which is located in "localhost:YOUR_LOCALHOST", then homepage.html will appear
~~~
@GetMapping("/")
    public String home() {
        return "homepage";
    }
~~~
## Step 5: Create html, css, locate images
Good way to store all files in the corresponding packages and directories. All html files should be in directory "templates" which is in resources package. If you don't have it, create. Place css files in resources/static/css/YOUR_CSS_FILE.CSS. Images should be also within static resources, but in images directory.
## Step 6: Create homepage.html file
Within head tag,indicate links. Without this links, bootstrap will not work correctly. Right here, indicate your css folder. 
~~~
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/0fd8fbc1b6.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
~~~

## Step 7: jumbotron
Jumbotron is bootstrap class for top of site
~~~
<div class="jumbotron text-center">
    <div class="text-block">
        <h1 style="font-family:'Kaushan Script', cursive;">3d Printing Service</h1>
        <p><i>Upload your 3D model, choose from different finishes and materials, select the size of your print, receive
            a price quote instantly and let us take care of printing and shipping your products.</i></p>
    </div>
</div>
~~~
## Step 8: form group to get input from user
Values of input forms help us to access them by controller
First form group is for name of ordered item. 
~~~
<div class="container-fluid text-center bg-grey">
        <div class="row text-center slideanim col-sm-6">
            <div class="form-group">
                <label for="inputName">Name of shape</label>
                <input type="text" name="name" class="form-control" id="inputName" placeholder="">
                <small id="nameHelp" class="form-text text-muted">Name is case sensitive, please enter name which will
                    match image name on database</small>
            </div>
~~~
## Step 8.1: form group to get input from user(color and material names)
~~~
            <div class="form-group">
                <label for="inputColor">Color</label>
                <input type="text" name="color" class="form-control" id="inputColor" placeholder="Choose a color">
            </div>
        
            <div class="form-group">
                <label for="inputMaterial">Material</label>
                <input type="text" name="material" class="form-control" id="inputMaterial"
                       placeholder="Choose a material">
            </div>
        </div>
~~~
## Step 8.2: label where user can choose size of shape
~~~ 
        <div class="row text-center slideanim col-sm-6">
            <div class="form-group">
                <label for="chooseSize">Size</label>
                <p id="sizeHelp" class="form-text text-muted">Price varies depending on the size of 3d figure</p>
            </div>
        </div>
~~~
## Step : Modal to get message when button is clicked
~~~
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exModalLabel">Result</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Your order has been successfully accepted. Thanks for choosing us!
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary"><a href="/orders">See my basket</a></button>
            </div>
        </div>
    </div>
</div>
~~~


## Step : Script to show specific item(price) when radio is clicked(size) 
~~~
<script>
    $('input[name="sizeradio"]').click(function () {
        var target = $('#block-' + $(this).val());

        $('.block-text').not(target).hide(0);
        target.fadeIn(500);
    });
~~~
## Step : script for smooth scrolling
~~~
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
~~~

~~~
    $(document).ready(function () {
        $(".navbar a, footer a[href='#myPage']").on('click', function (event) {
            if (this.hash !== "") {
                event.preventDefault();
                var hash = this.hash;

                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 900, function () {
                    window.location.hash = hash;
                });
            }
        });

        $(window).scroll(function () {
            $(".slideanim").each(function () {
                var pos = $(this).offset().top;

                var winTop = $(window).scrollTop();
                if (pos < winTop + 600) {
                    $(this).addClass("slide");
                }
            });
        });
    })
</script>
~~~

## Step : create blocks directory with footer.html and header.html folders
We don't need everytime write these elements in each html files. We can create a separated files, and then call them everytime when we need them.
This one is for footer:
~~~
<div th:fragment="footer">
    <footer class="container-fluid text-center">
        <a href="#myPage" title="To Top">
            <span class="fas fa-chevron-up" style="color: #8B4CD0;"></span>
        </a>
        <p>Contacts reina.khasanova@iaau.edu.kg<br>+996755077550</a></p>
    </footer>
</div>
~~~
This one is for header. Take attention for links. There is navbar
~~~
<div th:fragment="header">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Home</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#tutorial">Tutorial</a></li>
                    <li><a href="/orders">Basket</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
~~~
## Step : Insert header and footer
~~~
<div th:insert="blocks/header :: header"></div>
<div th:insert="blocks/footer :: footer"></div>
~~~
## Step 10.0: Time to connect with database!
Please re-check pom.xml to make sure that necessary dependecies are added.
(otherwise go to step2)
Hope, you installed PostgreSQL app(pgAdmin4).
## Step 10.1: Application properties and database
Go to application.properties and paste
~~~
spring.datasource.url=jdbc:postgresql://localhost:YOUR_PORT/YOUR_DATABASE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
~~~
username is viewable in pgAdmin app. Make sure to create database on pgAdmin, then db will be connected
## Step 10.2 : System variables
To deploy this project to heroku we need more specific url address, username and password, cause it works only locally. In order to do this, go to enviromental system variables, create variables for each of url, username and password. For example, create variable with name NEWSPRING_URL and paste value jdbc:postgresql://localhost:YOUR_PORT/YOUR_DATABASE . Then in application.properties replace old names with new variable names
```
spring.datasource.url=${NEWSPRING_URL}
spring.datasource.username=${SPRING_USERNAME}
spring.datasource.password=${SPRING_PASSWORD}
```
## Step 10.3 : Restart your IDE and computer
## Step 10.4 : Deploy project to heroku(by terminal)
- git init (create git, no more needed)
- git add . (use this anytime when your project will be changed)
- git commit -m "" (within quotes, write short description about changes)
- heroku login
- heroku create cs204neworderingapp (use unique names for your project)
- git push heroku master
## Step 10.5 : Heroku data
* your heroku profile -> data -> yourapp -> setting-> view database credential -> you will see list of heroku variables
* yourapp -> setting -> config vars -> reveal config vars -> create => passte here variales from database credentials
## Step 10.6 : If you stored some data on your db locally, it doesnt mean that these data will be available from heroku app. Store data separatedly

## Step 11.0: Size table and Size Repository
Since our db and app are connected, we can create table for this db. Size table will contain sizeName and price. It means that price varies depending on size of item.
## Step 11.1: Size class
* Locate classes on new "managing" directory. 
* Entity annotation means that our class is actually table of db
* generated values annotation means that id is primary key of table(unique and not null identifier)and id is like automatically working counter(int)
* specify other fields
~~~ 
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sizeName;
    private Double price;
~~~
## Step 11.2: Size constructor
~~~
public Size(){ }
    public Size(String name, Double price) {
        this.sizeName=name;
        this.price=price;
    }
~~~
## Step 11.3: Create getter and setter for id, sizeName and price
## Step 11.4: Create SizeRepository interface which will extend CrudRepository interface. 
This is ready interface for posting and deleting data from db,so we need to inherited from it
~~~
public interface SizeRepository extends CrudRepository<Size, Integer> {
}
~~~
## Step 11.5: Creating element for Size table
ok is just a message. 
~~~@Autowired
private SizeRepository sizeRepo;
@PostMapping("/size/add")
    public @ResponseBody
    String addNewSize(@RequestBody Size size) {
        sizeRepo.save(size);
        return "OK";
    }
~~~
## Step 11.6: post items for Size table.
can be done by every request maker. I suggest to do it in firefox and install http request maker.
* In target site specify link http://localhost:8085/size/add.
* method -- post
* content-type:application/json
* body data in format {"sizeName":"", "price":23.59}
## Step 12 : controller for thymeleaf and sizerepo
size is item which will appear in our html, we store all variables from size repository and initialize them as size object. then we go to homepage.html
```
@Autowired
private SizeRepository sizeRepo;
@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("size", sizeRepo.findAll());
        return "homepage";
    }
```
## Step 13: Thymeleaf, radio and size table
"each" is like for-each loop. Take attention to th:value and input name attributes. We are creating radio button for each item from size table,and nearly indicate price for this item
~~~
<div class="radio" th:each="el: ${size}">
                    <input type="radio" name="sizeradio" id="chooseSize" checked th:text="${el.sizeName}"
                                  th:value="${el.sizeName}"/>
                        <input type="text" name="price" th:value="'$'+${el.price}" readonly />
                </div>
~~~
## Step 14: now we should work on facts that we press "order" button, item should go to basket
We should wrap our form-groups by this main form. Wjen button is clicked it calls modal and send data to /orders page
~~~
<form action="/orders" method="post">
<button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Order</button>
</form>
~~~
## Step 15: create another table called Orders with fields [integer] id(pk)  and [String] name, color, material, sizeraio and price
## Step 15.1 : create empty constructor and constructor with fields above
## Step 15.2: create getter and setter for fields
## Step 16.3: create OrdersRepository interface which is also extends CrudRepository<Orders, Integer>
## Step 16.4: create getMapping annotation
```
@Autowired
private OrdersRepository ordersRepo;
@GetMapping("/orders")
    public String seeOrders( Model model){
        model.addAttribute("orders", ordersRepo.findAll());
        return "basket";
}
```
## Step 16.5: create basket.html
since /orders page send as to basket.html, we should create it(templates directory)
insert header and footer, add link attributes to head(style, thymeleaf and bootstrap).

## Step 17: post order
RequestParam annotation help us to get name, color, etc from input form where we indicated them as name="name". Then we create new object with these parameters(that's why we need constructor), save this object and we redirected to main page
~~~
@PostMapping("/orders")
    public String addNewOrder(@RequestParam String name,@RequestParam String color, @RequestParam String material,@RequestParam String sizeradio, @RequestParam String price, Model model) {
        Orders item=new Orders(name, color, material, sizeradio, price);
        ordersRepo.save(item);
        return "redirect:/";
    }
~~~
## Step 18: Basket with selected orderings and thymeleaf
since we already sent model.addAttribute("orders", ordersRepo.findAll());, we can paste orderings and its fields on basket.html.
Every item stored as thumbnail. Take a look for image storing.
~~~
<div id="myorders" class="container-fluid text-center bg-grey">
    <h2>ORDERS</h2>
    <div class="row text-center slideanim">
        <div class="col-sm-4" th:each="element: ${orders}">
            <div class="thumbnail">
                <img th:src="'/images/' + ${element.name} +'.png'" alt="shape img" width="400" height="300">
                <h3 th:text="${element.name}"></h3>
                <p th:text="${element.material}"><strong></strong></p>
                <p th:text="${element.color}"></p>
                <p th:text="${element.sizeradio}"></p>
                <p th:text="${element.price}"></p>
                <p><button type="submit" class="btn">Delete</button></p>
            </div>
        </div>
    </div>
</div>
~~~
## Step 19: Deleting item form basket
You may notice delete button on previous code. Here we will delete item by its id. First, wrap the button with. Deleting also use post method
~~~
<form th:action="'/orders/'+${element.id}+'/delete'" method="post">
                <p><button type="submit" class="btn">Delete</button></p>
                </form>
~~~
## Step 19.1: postmapping for deleting item
pathvariable annotation get the integer id from orders class. When we press button, we are still stayed in this page
```
@PostMapping("/orders/{id}/delete")
    public String orderDelete(@PathVariable(value="id") int id, Model model){
        Orders item = ordersRepo.findById(id).orElseThrow(IllegalStateException::new);
        ordersRepo.delete(item);
        return "redirect:/orders";
    }
```
## FINISH. submit all changes to the github and heroku
