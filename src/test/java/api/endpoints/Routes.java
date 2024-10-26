package api.endpoints;

/*
 Swagger URI --> https://petstore.swagger.io/
Create user (post) --> https://petstore.swagger.io/v2/user
Get User(Get) --> https://petstore.swagger.io/v2/user/{username}
Update User(update)  ---> https://petstore.swagger.io/v2/user/{username}
Delete User(Delete) --->  https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module
	//public static String post_url="https://petstore.swagger.io/v2/user";
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
}
	
	 

