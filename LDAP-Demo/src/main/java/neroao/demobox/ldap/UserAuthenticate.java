package neroao.demobox.ldap;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class UserAuthenticate {
	
	private static String URL = "ldap://10.15.15.145:389/";
	private static String BASEDN = "dc=primeton,dc=com";
	private static String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	private static LdapContext ctx = null;
	private static Hashtable env = null;
	private static Control[] connCtls = null;
	
	private static void LDAP_connect(){
		env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, FACTORY);
		env.put(Context.PROVIDER_URL, URL+BASEDN);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=primeton,dc=com");
		env.put(Context.SECURITY_CREDENTIALS, "12345678");
		
		try{
			ctx = new InitialLdapContext(env,connCtls);
		}catch(AuthenticationException e){
			System.out.println("Authentication faild: "+e.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static String getUserDN(String userName){
		String userDN = "";
		LDAP_connect();
		try{
			SearchControls contraints = new SearchControls();
			contraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration en = ctx.search("", "cn="+userName,contraints);
			if(en == null){
				System.out.println("Have no NamingEnumeration");
			}
			if(!en.hasMoreElements()){
				System.out.println("Have no element");
			}
			while(en != null && en.hasMoreElements()){
				Object obj = en.nextElement();
				if(obj instanceof SearchResult){
					SearchResult si = (SearchResult) obj;
					userDN += si.getName();
					userDN +=","+BASEDN;
				}else{
					System.out.println(obj);
				}
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userDN;
	}
	
	public static boolean authenricate(String userName,String password){
		boolean valide = false;  
        String userDN = getUserDN(userName);  
        try {  
            ctx.addToEnvironment(Context.SECURITY_PRINCIPAL,userDN);  
            ctx.addToEnvironment(Context.SECURITY_CREDENTIALS,password);  
            ctx.reconnect(connCtls);  
            System.out.println(userDN + " is authenticated(验证成功！)");  
            valide = true;  
        }catch (AuthenticationException e) {  
            System.out.println(userDN + " is not authenticated");  
            System.out.println(e.toString());  
            valide = false;  
        }catch (NamingException e) {  
            System.out.println(userDN + " is not authenticated");  
            valide = false;  
        }  
         
        return valide;
	}
	
	public static void main(String[] args) {
		authenricate("aoxianqi","00000000");

	}

}
