package definitions;

//import org.springframework.http.HttpEntity;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class StepDefinition {
//	
//	private String addURI;
//	private double doublename_id;
//	private Object user_name;
//	private String name_id;
//	private Object restTemplate;
//	private Object response;
//
//	@Given("I Set POST user service api endpoint")
//	public void i_set_post_user_service_api_endpoint() {
//	    // Write code here that turns the phrase above into concrete actions
//		addURI = "http://localhost:1010/users/addUsers";
//        System.out.println("Add URL :"+addURI);
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Send a POST HTTP request")
//	public void send_a_post_http_request() {
//	    // Write code here that turns the phrase above into concrete actions
//		doublename_id = Math.random();
//        user_name = "zozo_"+name_id;//Just to avoid Duplicate Name entry
//    String jsonBody"{\"name\":\""+user_name+"\",\"salary\":\"123\",\"age\":\"23\"}";
//        System.out.println("\n\n" + jsonBody);
//        HttpEntity<String>entity = new HttpEntity<String>(jsonBody, headers);       
//        //POST Method to Add New Employee
//        this.restTemplate = newRestTemplate ();
//        response = restTemplate.postForEntity(addURI, entity, String.class);
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	private Object newRestTemplate() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Then("I receive valid Response")
//	public void i_receive_valid_response() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//	
//
//	
//	
//
//}
