#Gol!
##Gol!(Pronounced Gol-Bang) is annotation-based HTTP Client for Java
---
```Java
// Http Request Configuration
@Config(server="http://www.nnoco.com/api",
  header={"Content-Type=application/json",
    "Accept=application/json"},
  async=true)
public interface ApiRequest {
  @Request(path="/users/{id}")
  public void getUserAsync(@PathVariable("id") String id, OnSuccessHandler handler);
  
  @Request(path="/users/{id}")
  @IsAsyncRequest(false)
  public User getUser(@PathVariable String id);
}

// use interface.
public class Test {
  public static void main(String[] args) {
    ApiRequest request = GolBang.get(ApiRequest.class);
    
    // Asynchronous request
    request.getUserAsync("123", new OnSuccessHandler() { // or use lambda expression
      public void onSuccess(User user) {
        System.out.println(user.getId() + ": " + user.getName());
      }
    });
    
    // Synchronous request
    User user = request.getUser("123");
    System.out.println(user.getId() + ": " + user.getName());
  }
}
```
